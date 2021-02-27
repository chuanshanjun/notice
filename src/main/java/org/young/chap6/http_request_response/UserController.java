package org.young.chap6.http_request_response;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:ChuanShanJun
 * @date:2021/2/27
 * @description:
 */
@Slf4j
@RestController
public class UserController {

    @GetMapping("/user")
    public User getUser(@RequestBody(required = false) User user) {
        if (user == null) {
            return new User(-3, "young", -30L);
        }

        return user;
    }
}
