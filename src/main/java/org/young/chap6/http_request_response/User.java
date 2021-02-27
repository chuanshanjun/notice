package org.young.chap6.http_request_response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:ChuanShanJun
 * @date:2021/2/27
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;

    private String name;

    private long age;
}
