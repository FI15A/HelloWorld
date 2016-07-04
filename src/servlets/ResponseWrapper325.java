package servlets;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class ResponseWrapper325 extends HttpServletResponseWrapper {

	private CharArrayWriter writer = new CharArrayWriter();
	
	public ResponseWrapper325(HttpServletResponse response) {
		super(response);
	}
	
	@Override
	public PrintWriter getWriter() throws IOException {
		return new PrintWriter(writer);
	}
	
	@Override
	public String toString() {
		return writer.toString();
	}

}
