package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@ResponseStatus(HttpStatus.BAD_REQUEST) // 500 -> 400
class MyException extends RuntimeException {
	MyException(String msg) {
		super(msg);
	}
	MyException() { this(""); }
}


@Controller
public class ExceptionController2 {
	
	@RequestMapping("/ex3")
	public String main() throws Exception {
			throw new Exception("���ܰ� �߻��߽��ϴ�.");		
		
	}

	@RequestMapping("/ex4")
	public String main2() throws Exception {
			throw new FileNotFoundException("���ܰ� �߻��߽��ϴ�.");
	}
}
