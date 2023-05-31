package com.project.bookMyMeal.config;

import java.io.IOException;


import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.*;

public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        System.out.println("Logging Request  "+ req.getMethod() + req.getRequestURI());
        if(req.getRequestURI().equals("/meal/register")) {
        	chain.doFilter(request, response);
        }
        String authHeader = req.getHeader("Authorization");
        chain.doFilter(request, response);

	}

}
