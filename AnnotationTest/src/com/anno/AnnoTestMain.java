package com.anno;

import java.lang.reflect.Method;

public class AnnoTestMain {
	@MyAnnotation(count = 5)
	public static void print() {
		System.out.println("프린트입니다.");
	}

	public static void main(String[] args) throws Exception {

//		AnnoTestMain at = new AnnoTestMain();
//		at.getClass(); 랑 밑에 코드랑 같음

		Method m = AnnoTestMain.class.getMethod("print");

		if (m.isAnnotationPresent(MyAnnotation.class)) {
			System.out.println("Anno");
		} else {
			print();
		}
		
	}
}
