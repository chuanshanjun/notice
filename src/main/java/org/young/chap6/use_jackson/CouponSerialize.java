package org.young.chap6.use_jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * <h1>使用自定的序列化类来指定序列化效果</h1>
 * @author:ChuanShanJun
 * @date:2021/3/14
 * @description:
 */
public class CouponSerialize extends JsonSerializer<Coupon> {

    @Override
    public void serialize(Coupon coupon, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        // 开始序列化
        gen.writeStartObject();

        gen.writeStringField("id", String.valueOf(coupon.getId()));
        gen.writeStringField("user", coupon.getUserId().toString());
        gen.writeStringField("couponCode", coupon.getCouponCode());
        gen.writeStringField("assignTime", new SimpleDateFormat("HH:mm:ss").format(coupon.getAssignTime()));
        gen.writeStringField("status", coupon.getStatus().getDesc());

        gen.writeStringField("name", coupon.getTemplate().getName());
        gen.writeStringField("logo", coupon.getTemplate().getLogo());

        // 结束序列化
        gen.writeEndObject();
    }
}
