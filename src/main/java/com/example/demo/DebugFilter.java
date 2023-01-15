package com.example.demo;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/emp/*")
public class DebugFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.getParameterMap().forEach((t,u)->{
			System.out.println(t);
			Arrays.stream(u).forEach(v-> System.out.print(v+" "));
		});
		chain.doFilter(request, response);
	}

}
