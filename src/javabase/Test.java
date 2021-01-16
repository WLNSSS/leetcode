package javabase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class Test {
	 private int age;
	    private String name;
	    private int testint;
	 
	    public Test(int age) {
	        this.age = age;
	    }
	 
	    public Test(int age, String name) {
	        this.age = age;
	        this.name = name;
	    }
	 
	    private Test(String name) {
	        this.name = name;
	    }
	 
	    public Test() {
	    }
	    public static void main(String[] args) {
	        try (//����һ��ObjectOutputStream�����
	             ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.txt"))) {
	            //���������л����ļ�s
	            Person person = new Person("9��", 23);
	            oos.writeObject(person);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        try (//����һ��ObjectInputStream������
	                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.txt"))) {
	               Person brady = (Person) ois.readObject();
	               System.out.println(brady);
	           } catch (Exception e) {
	               e.printStackTrace();
	           }
	    }
}
