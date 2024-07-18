package com.example.demo.httpClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class BioHttpClients {

    @Bean
    public MemberClient memberClient(RestClient.Builder restClientBuilder) {
        var exchangeAdapter = RestClientAdapter.create(restClientBuilder.build());
        var factory = HttpServiceProxyFactory.builderFor(exchangeAdapter).build();
        return factory.createClient(MemberClient.class);
    }
}
