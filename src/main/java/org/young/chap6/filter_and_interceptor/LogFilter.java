package org.young.chap6.filter_and_interceptor;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author:ChuanShanJun
 * @date:2021/2/27
 * @description:
 */
@Slf4j
@WebFilter(filterName = "LogFilter", urlPatterns = "/*")
public class LogFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("beforeDoFilter");
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("afterDoFilter");
    }

    @Override
    public void destroy() {
        log.info("filter destroy");
    }
}
