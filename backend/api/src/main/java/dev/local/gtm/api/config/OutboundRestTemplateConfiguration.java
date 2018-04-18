package dev.local.gtm.api.config;

import dev.local.gtm.api.interceptor.LeanCloudRequestInterceptor;
import dev.local.gtm.api.config.propsupport.LeanCloudProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 为应用访问外部 Http Rest API 提供配置
 *
 * @author Peng Wang (wpcfan@gmail.com)
 */
@RequiredArgsConstructor
@Configuration
public class OutboundRestTemplateConfiguration {

    private static final int TIMEOUT = 5000;
    private final LeanCloudProperties leanCloudProperties;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplateBuilder()
                .setConnectTimeout(TIMEOUT)
                .interceptors(new LeanCloudRequestInterceptor(leanCloudProperties))
                .build();
    }
}