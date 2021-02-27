package org.young.chap6.date_se_de;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

/**
 * <h1>实现自己对时间格式序列化的类</h1>
 * @author:ChuanShanJun
 * @date:2021/2/27
 * @description:
 */
@Slf4j
public class DateJacksonConvert extends JsonDeserializer<Date> {

    /**
     * <h2>可匹配的时间格式</h2>
     */
    private static final String[] PATTERN = new String[]{
            "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd"
    };

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException, JsonProcessingException {
        Date target = null;
        String originDate = jsonParser.getText();

        if (!StringUtils.isEmpty(originDate)) {
            try {
                long longDate = Long.parseLong(originDate.trim());
                target = new Date(longDate);
            } catch (NumberFormatException nfe) {
                log.error("NumberFormatException", nfe);
                try {
                    target = DateUtils.parseDate(originDate, PATTERN);
                } catch (ParseException e) {
                    log.error("log error ParseException", e);
                    e.printStackTrace();
                }
            }
        }

        return target;
    }

    @Override
    public Class<?> handledType() {
        return Date.class;
    }
}
