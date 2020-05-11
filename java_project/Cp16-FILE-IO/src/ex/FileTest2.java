package ex;		// 0511 월요일 수업.

import java.io.File;

public class FileTest2 {

	public static void main(String[] args) {
		
		// 폴더 경로 객체 생성.
		File myDir = new File("c:\\myJava");
		
		String[] fNames = myDir.list();
		
//		for(int i=0; i<fNames.length; i++) {
//			System.out.println(fNames[i]);		// 디렉터리안에 파일 이름 반환.
//		}
		
		
		File[] files = myDir.listFiles();	// 디렉터리인지 파일인지 확인할수있다.
		
		for(int i=0; i<files.length; i++) {
			
			if(files[i].isDirectory()) {	// 디렉터리냐 아니냐 
				System.out.print("[DIR]\t");
			}else {
				System.out.print("[FILE]\t");
			}
			System.out.println(files[i].getName()+"\t");
		}
	
	}

}
