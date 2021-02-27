package org.young.chap6.date_se_de;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author:ChuanShanJun
 * @date:2021/2/27
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
//    @JsonDeserialize(using = DateJacksonConvert.class)
    private Date birthday;
}
