package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class FormatFilter
 */
public class FormatFilter implements Filter {

	private static final String KURSNAME = "kurs"; 
	private FilterConfig fConfig;
	
    /**
     * Default constructor. 
     */
    public FormatFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse resp = (HttpServletResponse)response;
		ResponseWrapper325 wrapper = new ResponseWrapper325(resp);
		
		chain.doFilter(request, wrapper);
		
		String respString = wrapper.toString();
		String words[] = wrapper.toString().split("\\s");
		ArrayList<String> newWords = new ArrayList<>(Arrays.asList(words));
		for (int i=0; i<words.length; i++) {
			if (words[i].equals(fConfig.getInitParameter(KURSNAME)))
				newWords.set(i, "<a href=\"http://www.cbm-bremen.de\">"+ words[i] +"</a>");
		}
		respString = String.join(" ", newWords);
				
		response.getWriter().write(respString);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.fConfig = fConfig;
	}

}
