package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;


@ControllerAdvice("com.fastcampus.ch2") // ������ ��Ű������ �߻��� ���ܸ� ó��
// @ControllerAdvice ��� ��Ű���� ����

public class GlobalCatcher {
	
	@ExceptionHandler(NullPointerException.class, FileNotFoundException.class)
	public String Catcher2(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
	}
	
	@ExceptionHandler(Exception.class)
	public String Catcher(Exception ex, Model m) {
		System.out.println("catcher() in ExceptionController");
		m.addAttribute("ex", ex);
		
		return "error";
	}
	
	@RequestMapping("/ex")
	public String main() throws Exception {
		Object m;
		m.attribute("msg", "message from ExceptionController.main()");
		throw new Exception("���ܰ� �߻��߽��ϴ�.");		
		
	}

	@RequestMapping("/ex2")
	public String main2() throws Exception {
			throw new FileNotFoundException("���ܰ� �߻��߽��ϴ�.");
	}
	
}
