package org.young.chap6.http_request_response;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author:ChuanShanJun
 * @date:2021/2/27
 * @description:
 */
@Slf4j
@Component
public class UserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (RequestParseUtil.isJson(request, response)) {
            String jsonStr = RequestParseUtil.getBodyString(request);
            User user;
            ObjectMapper ob = new ObjectMapper();
            try {
                user = ob.readValue(jsonStr, User.class);
            } catch (Exception e) {
                user = null;
            }

            if (user != null) {
                log.info("UserInterceptor preHandle() process: {}", user);
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
