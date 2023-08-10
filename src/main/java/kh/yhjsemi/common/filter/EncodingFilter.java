package kh.yhjsemi.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");		
	response.setContentType("text/html; charset=UTF-8");
	//다음 filter 동작 또는 doGet()/ do Post()호출
	chain.doFilter(request, response);
}
}
