package ex;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSerializableMain2 {
	// 객체 역직렬화
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// 직렬화를 통해서 불러오려면 받는 쪾에서도 같은 Circle class가 있어야한다. 
		
		// 기본스트림
		FileInputStream fi=new FileInputStream("Object.ser");
		
		// 파일에서 데이터를 축출 ㅡ> 객체 역질렬화 필터스트림
		ObjectInputStream in=new ObjectInputStream(fi);
		
		Circle c1=(Circle) in.readObject();
		Circle c2=(Circle) in.readObject();
		String string=(String) in.readObject();
		
		c1.showCircleInfo();
		c2.showCircleInfo();
		System.out.println(string);
		
		in.close();
		

		
		
		
	}

}