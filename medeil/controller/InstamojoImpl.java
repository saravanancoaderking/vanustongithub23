package com.medeil.controller;

import com.medeil.domain.*;
import com.medeil.util.*;

import org.apache.http.util.Asserts;
import org.apache.http.util.TextUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Class InstamojoImpl.
 */
public class InstamojoImpl implements Instamojo {

    /**
     * The Constant LOGGER.
     */
    private static final Logger LOGGER = Logger.getLogger(InstamojoImpl.class.getName());

    private volatile static Instamojo uniqueInstance;
    /**
     * The access token.
     */
    private static InrAccessTokenResponse accessToken;
    /**
     * The token creation time.
     */
    private static long tokenCreationTime;
    /**
     * The client id.
     */
    private String clientId;
    /**
     * The client secret.
     */
    private String clientSecret;
    /**
     * The api endpoint.
     */
    private String apiEndpoint;
    /**
     * The auth endpoint.
     */
    private String authEndpoint;

    private InstamojoImpl() {
    }

    /**
     * Instantiates a new instamojo impl.
     *
     * @param clientId     the client id
     * @param clientSecret the client secret
     * @param apiEndpoint  the api endpoint
     * @param authEndpoint the auth endpoint
     */
    private InstamojoImpl(String clientId, String clientSecret, String apiEndpoint, String authEndpoint) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.apiEndpoint = apiEndpoint;
        this.authEndpoint = authEndpoint;
    }

    /**
     * Gets the api.
     *
     * @param clientId     the client id
     * @param clientSecret the client secret
     * @param apiEndpoint  the api endpoint
     * @param authEndpoint the auth endpoint
     * @return the api
     * @throws IneConnectionException the connection exception
     */
    public static Instamojo getApi(String clientId, String clientSecret, String apiEndpoint, String authEndpoint)
            throws IneConnectionException {
        Asserts.notEmpty(clientId, "Client Id");
        Asserts.notEmpty(clientSecret, "Client Secret");
        Asserts.notEmpty(apiEndpoint, "API Endpoint");
        Asserts.notEmpty(authEndpoint, "AUTH Endpoint");

        return getInstamojo(clientId, clientSecret, apiEndpoint, authEndpoint);
    }

    /**
     * Gets api.
     *
     * @param clientId     the client id
     * @param clientSecret the client secret
     * @return the api
     * @throws IneConnectionException the connection exception
     */
    public static Instamojo getApi(String clientId, String clientSecret) throws IneConnectionException {
        return getApi(clientId, clientSecret, Constants.INSTAMOJO_API_ENDPOINT, Constants.INSTAMOJO_AUTH_ENDPOINT);
    }

    private static Instamojo getInstamojo(String clientId, String clientSecret, String apiEndpoint, String authEndpoint)
            throws IneConnectionException {
        if (uniqueInstance == null) {
            synchronized (InstamojoImpl.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new InstamojoImpl(clientId, clientSecret, apiEndpoint, authEndpoint);
                    accessToken = getAccessToken(clientId, clientSecret, authEndpoint);
                }
            }
        } else {
            if (isTokenExpired()) {
                synchronized (InstamojoImpl.class) {
                    if (isTokenExpired()) {
                        accessToken = getAccessToken(clientId, clientSecret, authEndpoint);
                    }
                }
            }
        }

        return uniqueInstance;
    }

    private static boolean isTokenExpired() {
        long durationInSeconds = TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - tokenCreationTime);
        return durationInSeconds >= (accessToken.getExpiresIn() - 300);
    }

    /**
     * Gets the access token.
     *
     * @param clientId     the client id
     * @param clientSecret the client secret
     * @param authEndpoint the auth endpoint
     * @return the access token @ the instamojo exception
     */
    private static InrAccessTokenResponse getAccessToken(String clientId, String clientSecret, String authEndpoint)
            throws IneConnectionException {
        Map<String, String> params = new HashMap<>();

        params.put(Constants.CLIENT_ID, clientId);
        params.put(Constants.CLIENT_SECRET, clientSecret);
        params.put(Constants.GRANT_TYPE, Constants.CLIENT_CREDENTIALS);

        try {
            String response = HttpUtils.sendPostRequest(authEndpoint, null, params);

            InrAccessTokenResponse accessTokenResponse = JsonUtils.convertJsonStringToObject(response,
                    InrAccessTokenResponse.class);

            if (TextUtils.isEmpty(accessTokenResponse.getToken())) {
                throw new IneInvalidClientException(
                        "Could not get the access token due to " + accessTokenResponse.getError());
            }

            tokenCreationTime = System.nanoTime();
            accessTokenResponse.setJsonResponse(response);
            return accessTokenResponse;
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
            throw new IneConnectionException(e.toString(), e);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.instamojo.wrapper.api.Instamojo#createNewPaymentOrder(com.instamojo.
     * wrapper.model.PaymentOrder)
     */
    @Override
    public InrCreatePaymentOrderResponse createNewPaymentOrder(InmPaymentOrder paymentOrder)
            throws IneConnectionException, IneInvalidPaymentOrderException {
        Asserts.notNull(paymentOrder, "Payment Order");

        boolean isValid = paymentOrder.validate();
        
    	System.out.println("isValid"+isValid);

        if (!isValid) {
               throw new IneInvalidPaymentOrderException();
        }

        Map<String, String> headers = new HashMap<>();
        headers.put(Constants.AUTHORIZATION, getAuthorization());
        Map<String, String> params = new HashMap<>();

        params.put("name", paymentOrder.getName());
        params.put("email", paymentOrder.getEmail());
        params.put("phone", paymentOrder.getPhone());
        params.put("currency", paymentOrder.getCurrency());
        params.put("amount", String.valueOf(paymentOrder.getAmount()));
        params.put("description", paymentOrder.getDescription());
        params.put("transaction_id", paymentOrder.getTransactionId());
        params.put("redirect_url", paymentOrder.getRedirectUrl());
        params.put("webhook_url", paymentOrder.getWebhookUrl());

        try {
            String response = HttpUtils.sendPostRequest(this.getApiPath(Constants.PAYMENT_ORDER_API_PATH), headers,
                    params);
            
        	System.out.println("isValid"+response);
            InrCreatePaymentOrderResponse createPaymentOrderResponse = JsonUtils.convertJsonStringToObject(response,
                    InrCreatePaymentOrderResponse.class);
            if (createPaymentOrderResponse.getPaymentOrder() == null) {
                Map<String, Object> map = JsonUtils.convertJsonStringToMap(response);
                if (map != null && map.get(Constants.TRANSACTION_ID) != null) {
                    paymentOrder.setTransactionIdInvalid(true);
                }

                if (map != null && map.get(Constants.WEBHOOK_URL) != null){
                    paymentOrder.setWebhookInvalid(true);
                }

                if (map != null && map.get(Constants.CURRENCY) != null) {
                    paymentOrder.setCurrencyInvalid(true);
                }
               throw new IneInvalidPaymentOrderException();
            }
            createPaymentOrderResponse.setJsonResponse(response);
            return createPaymentOrderResponse;
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
            throw new IneConnectionException(e.toString(), e);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.instamojo.wrapper.api.Instamojo#getPaymentOrderDetails(java.lang.
     * String)
     */
    @Override
    public InrPaymentOrderDetailsResponse getPaymentOrderDetails(String id) throws IneConnectionException {
        Asserts.notEmpty(id, "Order Id");

        Map<String, String> headers = new HashMap<>();
        headers.put(Constants.AUTHORIZATION, getAuthorization());

        try {
            String response = HttpUtils.sendGetRequest(
                    this.getApiPath(Constants.PAYMENT_ORDER_API_PATH + "id:" + id + "/"), headers,
                    null);
            InrPaymentOrderDetailsResponse paymentOrderDetailsResponse = JsonUtils.convertJsonStringToObject(response,
                    InrPaymentOrderDetailsResponse.class);

            paymentOrderDetailsResponse.setJsonResponse(response);
            return paymentOrderDetailsResponse;
        } catch (IOException | URISyntaxException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
            throw new IneConnectionException(e.toString(), e);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.instamojo.wrapper.api.Instamojo#getPaymentOrderDetailsByTransactionId
     * (java.lang.String)
     */
    @Override
    public InrPaymentOrderDetailsResponse getPaymentOrderDetailsByTransactionId(String transactionId)
            throws IneConnectionException {
        Asserts.notEmpty(transactionId, "Transaction Id");

        Map<String, String> headers = new HashMap<>();
        headers.put(Constants.AUTHORIZATION, getAuthorization());

        try {
            String response = HttpUtils.sendGetRequest(
                    this.getApiPath(Constants.PAYMENT_ORDER_API_PATH + "transaction_id:" + transactionId + "/"),
                    headers, null);
            InrPaymentOrderDetailsResponse paymentOrderDetailsResponse = JsonUtils.convertJsonStringToObject(response,
                    InrPaymentOrderDetailsResponse.class);
            paymentOrderDetailsResponse.setJsonResponse(response);
            return paymentOrderDetailsResponse;
        } catch (IOException | URISyntaxException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
            throw new IneConnectionException(e.toString(), e);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.instamojo.wrapper.api.Instamojo#getPaymentOrderList(com.instamojo.
     * wrapper.model.PaymentOrderFilter)
     */
    @Override
    public InrPaymentOrderListResponse getPaymentOrderList(InmPaymentOrderFilter paymentOrderFilter)
            throws IneConnectionException {
        Asserts.notNull(paymentOrderFilter, "Payment Order Filter");

        Map<String, String> headers = new HashMap<>();
        headers.put(Constants.AUTHORIZATION, getAuthorization());
        Map<String, String> params = new HashMap<>();

        String id = paymentOrderFilter.getId();
        String transactionId = paymentOrderFilter.getTransactionId();
        Integer page = paymentOrderFilter.getPage();
        Integer limit = paymentOrderFilter.getLimit();

        if (!TextUtils.isEmpty(id)) {
            params.put("id", id);
        }
        if (!TextUtils.isEmpty(transactionId)) {
            params.put("transaction_id", transactionId);
        }
        if (page != null && page != 0) {
            params.put("page", String.valueOf(page));
        }
        if (limit != null && limit != 0) {
            params.put("limit", String.valueOf(limit));
        }

        try {
            String response = HttpUtils.sendGetRequest(this.getApiPath(Constants.PAYMENT_ORDER_API_PATH), headers,
                    params);
            InrPaymentOrderListResponse paymentOrderListResponse = JsonUtils.convertJsonStringToObject(response,
                    InrPaymentOrderListResponse.class);
            paymentOrderListResponse.setJsonResponse(response);
            return paymentOrderListResponse;
        } catch (IOException | URISyntaxException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
            throw new IneConnectionException(e.toString(), e);
        }
    }

    /* (non-Javadoc)
    * @see com.instamojo.wrapper.api.Instamojo#createNewRefund(com.instamojo.wrapper.model.Refund)
    */
    @Override
    public InrCreateRefundResponse createNewRefund(InmRefund refund) throws IneConnectionException, IneInvalidRefundException {
        Asserts.notNull(refund, "Refund");

        boolean isValid = refund.validate();

        if (!isValid) {
            throw new IneInvalidRefundException();
        }

        Map<String, String> headers = new HashMap<>();
        headers.put(Constants.AUTHORIZATION, getAuthorization());

        Map<String, String> params = new HashMap<>();
        params.put("payment_id", refund.getPaymentId());
        params.put("type", refund.getType());
        params.put("body", refund.getBody());
        params.put("refund_amount", String.valueOf(refund.getRefundAmount()));

        try {
            String response = HttpUtils.sendPostRequest(
                    this.getApiPath(Constants.REFUND_API_PATH + refund.getPaymentId() + "/refund/"), headers, params);
            InrCreateRefundResponse createRefundResponse = JsonUtils.convertJsonStringToObject(response,
                    InrCreateRefundResponse.class);

            if (createRefundResponse.getRefund() == null) {
                Map<String, Object> map = JsonUtils.convertJsonStringToMap(response);
                if (map != null && map.get(Constants.TYPE) != null) {
                    refund.setTypeInvalid(true);
                }
                throw new IneInvalidRefundException();
            }
            createRefundResponse.setJsonResponse(response);
            return createRefundResponse;
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
            throw new IneConnectionException(e.toString(), e);
        }
    }

    /**
     * Clears the current cached Instance
     */
    public static void ClearInstance() {
        if (uniqueInstance != null){
            synchronized (InstamojoImpl.class){
                uniqueInstance=null;
                accessToken=null;
            }
        }
    }

    /**
     * Gets the authorization.
     *
     * @return the authorization
     */
    private String getAuthorization() {
        return accessToken.getTokenType() + " " + accessToken.getToken();
    }

    /**
     * Gets the api path.
     *
     * @param path the path
     * @return the api path
     */
    private String getApiPath(String path) {
        String apiPath = this.apiEndpoint + path;

        if (!apiPath.endsWith("/")) {
            apiPath += Character.toString('/');
        }
        return apiPath;
    }

}
