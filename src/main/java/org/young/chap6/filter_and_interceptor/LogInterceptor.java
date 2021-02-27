package org.young.chap6.filter_and_interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
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
public class LogInterceptor implements HandlerInterceptor {

    long startTime = System.currentTimeMillis();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        log.info("LogInterceptor preHandle(): {}", handlerMethod.getBean().getClass().getName());
        log.info("LogInterceptor preHandle(): {}", handlerMethod.getMethod().getName());

        return true;
    }

    /**
     * <h2>post在controller之后在ModelAndView渲染之前</h2>
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("LogInterceptor postHandle(): {}, {} -> {}", request.getRequestURI(), startTime, System.currentTimeMillis() -startTime);
    }

    /**
     * <h2>在ModelAndView渲染之后</h2>
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("LogInterceptor afterCompletion");
    }
}
