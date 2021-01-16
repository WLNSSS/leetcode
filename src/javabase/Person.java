package javabase;

import java.io.Serializable;

public class Person implements Serializable{
	public int age;
	public String name;
	public Person(String name, int age) {
	      this.name = name;
	      this.age = age;
	  }

	  @Override
	  public String toString() {
	      return "Person{" +
	              "name='" + name + '\'' +
	              ", age=" + age +
	              '}';
	  }

}
