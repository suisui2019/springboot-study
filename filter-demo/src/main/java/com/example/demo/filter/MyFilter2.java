//package com.example.demo.filter;
//
//import lombok.extern.slf4j.Slf4j;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//@Slf4j
//public class MyFilter2 implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        log.info(filterConfig.getFilterName() + " init");
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
//        log.info("myFilter2 begin");
//        try {
//            log.info("业务方法执行");
//            chain.doFilter(request, response);
//        } catch (Exception e) {
//            log.error("error!", e);
//        }
//        log.info("myFilter2 end");
//    }
//
//    @Override
//    public void destroy() {
//    }
//}