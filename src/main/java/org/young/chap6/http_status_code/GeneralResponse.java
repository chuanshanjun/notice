package org.young.chap6.http_status_code;

import lombok.Data;

/**
 * @author:ChuanShanJun
 * @date:2021/2/27
 * @description:
 */
@Data
public class GeneralResponse<T> {

    private int code;
    private String msg;
    private T data;
}
