package kr.co.mlec.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter
{
	String charset;
	public void destroy()
	{
		// TODO Auto-generated method stub		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException
	{
		// TODO Auto-generated method stub
		request.setCharacterEncoding(charset);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fc) throws ServletException
	{
		/* <init-param>
  				<param-name>charset</param-name>
  				<param-value>utf-8</param-value>
  		   </init-param>
		 */
		 charset = fc.getInitParameter("charset");
	}	
}
