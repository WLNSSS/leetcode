package javabase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class Test {
public void test2() {
		
			
			try {
				test1();
			} catch (CustomException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	
	}
	
	public void test1() throws CustomException{
		
		throw new CustomException("我喝酒了");
	}
// main方法
	public static void main(String[] args) {
		
		Test  object =  new  Test();
		
		//try{
			
			object.test2();
			
		//}catch(Exception e){
			
		//e.printStackTrace();
			
		//}

	}
}
