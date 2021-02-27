package org.young.chap6.http_status_code;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author:ChuanShanJun
 * @date:2021/2/27
 * @description:
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "This second way to set http status code")
public class BadRequestException extends RuntimeException {
}
