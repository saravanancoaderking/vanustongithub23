//package com.medeil.securityconfig;
//
//import org.apache.http.HttpHost;
//import org.apache.http.auth.AuthScope;
//import org.apache.http.auth.UsernamePasswordCredentials;
//import org.apache.http.client.CredentialsProvider;
//import org.apache.http.impl.client.BasicCredentialsProvider;
//import org.elasticsearch.client.RestClient;
//import org.elasticsearch.client.RestClientBuilder;
//import org.elasticsearch.client.RestHighLevelClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.env.Environment;
//
//public class ElasticSearchConfig {
//	
//	private Environment environment;
//    @Bean(destroyMethod = "close")
//    public RestHighLevelClient restClient() {
//
//        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
//        credentialsProvider.setCredentials(AuthScope.ANY,
//                new UsernamePasswordCredentials(environment.getProperty("${elasticsearch.username}"), environment.getProperty("${elasticsearch.password}")));
//
//        RestClientBuilder builder = RestClient.builder(new HttpHost(environment.getProperty("${elasticsearch.host}"),Integer.valueOf(environment.getProperty("${elasticsearch.port}"))))
//                .setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider));
//
//        RestHighLevelClient client = new RestHighLevelClient(builder);
//
//
//        return client;
//
//    }
//
//}