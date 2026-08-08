package dsa_java.common;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

class A {
	public void printOut() {
		System.out.println("In A printout");
	}
}

class B extends A {
	public void printOut() {
		System.out.println("In B printout");
	}
}

public class Demo {

	public final Instant NOW_TIME = Instant.now(); 

	public static void main(String args[]) {
		A obj = new B();
		obj.printOut();
    
	}

}
