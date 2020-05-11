package ex;		// 0511 월요일 수업.

import java.io.File;

public class FileTest1 {

	public static void main(String[] args) {
		
		//File myFile = new File("c:\\myJava\\test.txt");	
		//File myFile = new File("c:\\myJava","test.txt");	// 폴더,파일이름
		File myFile = new File("c:"+File.separator+"myJava"+File.separator+"test.txt");	// 이방식이 좀 더 안전하다.	
		
		
		// 파일 존재 유무 확인.
		if(myFile.exists()==false) {	//true or false
			System.out.println("파일이 존재하지 않습니다.");
			return;
		}
		
		// 새로운 폴더 경로 생성.
		File reDir = new File("c:\\yourJava");		// 경로설정.
		reDir.mkdir();	// 여기서 실제로 디렉토리 만든다.
		
		// 새로운 파일 경로 생성.
		File newFile = new File(reDir, "new.txt");
		myFile.renameTo(newFile);	// 위에서 만든거 여기에 들어간다.
		
		if(newFile.exists()) {
			System.out.println("파일 이동 성공.");	//myJava안에 test 파일이, yourJava안에 new로 저장된다.(파일이동)
		}else {
			System.out.println("파일 이동 실패.");
		}
		
	}

}
