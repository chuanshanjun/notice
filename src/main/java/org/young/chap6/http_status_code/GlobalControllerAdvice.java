package org.young.chap6.http_status_code;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.young.chap5.transaction_lost.CustomException;

import javax.servlet.http.HttpServletRequest;

/**
 * <h1>全局异常统一处理</h1>
 * @author:ChuanShanJun
 * @date:2021/2/27
 * @description:
 */
@RestControllerAdvice
public class GlobalControllerAdvice {

    /**
     * <h2>对指定的异常做处理</h2>
     * @return
     */
    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<GeneralResponse<String>> handleCustomException(HttpServletRequest request, CustomException ce) {
        GeneralResponse<String> gr = new GeneralResponse<>();
        gr.setCode(400);
        gr.setMsg("wahaha");
        gr.setData("good job");
        return new ResponseEntity<>(gr, HttpStatus.BAD_REQUEST);
    }
}
