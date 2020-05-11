package ex;		// 0511 월요일 수업.

import java.io.BufferedReader;		// 한줄씩 읽을때 사용.
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class NetworkTest3 {

	public static void main(String[] args) {
		
		URL url = null;
		
		String address = "https://cafe.naver.com/aiajr202003?iframe_url=/MyCafeIntro.nhn%3Fclubid=30056261";
		
		BufferedReader input = null;
		
		String line = "";
		
		try {
			
			url = new URL(address);
			
			
			input = new BufferedReader(new InputStreamReader(url.openStream()));
			
			while(true){
				
				line = input.readLine();
				if(line==null) {
					break;
				}
				
				System.out.println(line);
			}
			
			input.close();
			
		
		
		
		
		
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
