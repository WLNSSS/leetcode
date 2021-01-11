package javabase;

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
			Test t = new Test();
			Class c = t.getClass();
			Constructor[] constructors;
			constructors = c.getDeclaredConstructors();
		}
}
