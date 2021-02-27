package org.young.chap6.date_se_de;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;

/**
 * @author:ChuanShanJun
 * @date:2021/2/27
 * @description:
 */
@Configuration
public class DateConverterConfig {

    @Bean
    public DateJacksonConvert dateJacksonConvert() {
        return new DateJacksonConvert();
    }

    /**
     * <h2>要让jackson知道我们需要对Date类型的反序列化用这个convert</h2>
     * 所以DateJacksonConvert要重载handledType()
     * @param dateJacksonConvert
     * @return
     */
    @Bean
    public Jackson2ObjectMapperFactoryBean jackson2ObjectMapperFactoryBean(@Autowired DateJacksonConvert dateJacksonConvert) {
        Jackson2ObjectMapperFactoryBean jackson2ObjectMapperFactoryBean = new Jackson2ObjectMapperFactoryBean();
        jackson2ObjectMapperFactoryBean.setDeserializers(dateJacksonConvert);

        return jackson2ObjectMapperFactoryBean;
    }
}
