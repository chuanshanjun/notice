package org.young.chap6.http_request_response;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author:ChuanShanJun
 * @date:2021/2/27
 * @description:
 */
@Slf4j
@WebFilter
public class UserFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("RequestWrapperFilter Replace InputStream!");
        RequestWrapper bw = new RequestWrapper((HttpServletRequest) servletRequest);
        filterChain.doFilter(bw, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
