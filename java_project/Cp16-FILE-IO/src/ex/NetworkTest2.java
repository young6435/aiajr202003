package ex;		// 0511 월요일 수업.

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class NetworkTest2 {

	public static void main(String[] args) throws IOException {
		URL url = null;
		
		String address = "https://www.google.com/search?q=java&oq=java&aqs=chrome..69i57j35i39l2j0l5.1136j0j8&sourceid=chrome&ie=UTF-8";
		
		try {
			url = new URL(address);
			URLConnection conn = url.openConnection();
			
			System.out.println("conn.toString():"+conn);
			System.out.println("getAllowUserInteraction():" + conn.getAllowUserInteraction());
			System.out.println("getConnectTimeout():" + conn.getConnectTimeout());
			//System.out.println("getContent():" + conn.getContent());
			System.out.println("getContentEncoding():" + conn.getContentEncoding());
			
			System.out.println("getContentLength():" + conn.getContentLength());
			System.out.println("getContentType():" + conn.getContentType());
			System.out.println("getDate():" + conn.getDate());
			System.out.println("getDefaultAllowUserInteraction():" + conn.getDefaultAllowUserInteraction());
			System.out.println("getDefaultUseCaches():" + conn.getDefaultUseCaches());
			System.out.println("getDoInput():" + conn.getDoInput());
			System.out.println("getDoOutput():" + conn.getDoOutput());
			System.out.println("getExpiration():" + conn.getExpiration());
			System.out.println("getHeaderFields():" + conn.getHeaderFields());
			System.out.println("getIfModifiedSince():" + conn.getIfModifiedSince());
			System.out.println("getLastModified():" + conn.getLastModified());
			System.out.println("getReadTimeout():" + conn.getReadTimeout());
			System.out.println("getURL():" + conn.getURL());
			System.out.println("getUseCaches():" + conn.getUseCaches());
			
		
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
	
	}

}
