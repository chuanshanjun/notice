package org.young.chap6.filter_and_interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author:ChuanShanJun
 * @date:2021/2/27
 * @description:
 */
@Component
@Configuration
public class WebInterceptorAdapter implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/**").order(0);
        registry.addInterceptor(new UpdateLogInterceptor()).addPathPatterns("/**").order(1);
    }
}
