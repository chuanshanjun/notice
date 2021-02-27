package org.young.chap6.http_status_code;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.young.chap5.transaction_lost.CustomException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author:ChuanShanJun
 * @date:2021/2/27
 * @description:
 */
@RestController
public class CustomStatusCodeController {

    /**
     * <h2>第一种方式自定义返回状态码</h2>
     */
    @GetMapping("/first")
    public ResponseEntity<GeneralResponse<String>> first(HttpServletRequest request) {
        GeneralResponse<String> response = new GeneralResponse<>();
        response.setCode(200);
        response.setMsg("good");
        response.setData("data");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * <h2>第二种方式自定义返回状态码</h2>
     * 可以在自定义的异常上面加上@ResponseStatus
     * @return
     */
    @GetMapping("/second")
    public GeneralResponse<String> second() {
        // 业务逻辑
        throw new BadRequestException();
    }

    /**
     * <h2>第三种方式返回状态码</h2>
     * 直接在方法上加上@ResponseStatus
     * 我们可以直接重定向到这个方法上返回一些我们需要的错误情况
     * 或者给出错误页面
     * @return
     */
    @GetMapping("/third")
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "current http request 404")
    public void third() {

    }

    @GetMapping("/fourth")
    public GeneralResponse<String> fourth() throws CustomException {
        throw new CustomException("error");
    }
}
