package ex0404.view;

import java.util.List;

import ex0404.domain.Employee;

public class SuccessView {
	
	public static void printAll(List<Employee> list) {
		System.out.println("**Employee List**");
		for(Employee e : list) {
			System.out.println(e);
		}
	}
	
	public static void printOne(Employee em) {
		System.out.println(em);
	}
	
	public static void printMessage(String s) {
		System.out.println(s);
	}

}
