package com.demo.custom_validation.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
@Component
public class CustomFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;


        // Log the request details
        System.out.println("Received request: " + httpRequest.getMethod() + " " + httpRequest.getRequestURI());

        // Proceed with the filter chain
        chain.doFilter(request, response);
    }
}
