package com.example.demo.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

@Slf4j
@WebFilter(filterName = "myFilter1", urlPatterns = "/test")
public class MyFilter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info(filterConfig.getFilterName() + " init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        log.info("myFilter1 begin");
        try {
            log.info("业务方法执行");
            chain.doFilter(request, response);
        } catch (Exception e) {
            log.error("error!", e);
        }
        log.info("myFilter1 end");
    }

    @Override
    public void destroy() {
    }
}