package com.medeil.domain;

import com.google.gson.annotations.SerializedName;


public class InrCreateRefundResponse extends InrResponse {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 5958526618846686222L;

    /**
     * The refund.
     */
    @SerializedName("refund")
    private InmRefund refund;

    private Object caseResponse;

    /**
     * Gets the refund.
     *
     * @return the refund
     */
    public InmRefund getRefund() {
        return refund;
    }

    /**
     * Sets the refund.
     *
     * @param refund the new refund
     */
    public void setRefund(InmRefund refund) {
        this.refund = refund;
    }

    public Object getCaseResponse() {
        return caseResponse;
    }

    public void setCaseResponse(Object caseResponse) {
        this.caseResponse = caseResponse;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.instamojo.wrapper.response.Response#toString()
     */
    @Override
    public String toString() {
        return "CreateRefundResponse{" + "refund=" + refund +
                ", success=" + success +
                ", message='" + message + '\'' +
                ", case='" + caseResponse + '\'' +
                ", jsonResponse='" + jsonResponse + '\'' +
                '}';
    }
}
