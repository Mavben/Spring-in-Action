package com.fastcampus.ch2;

import java.net.URLEncoder;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.tools.javac.util.List;

@Controller // ctrl+shift+o 자동 import
@RequestMapping("/register")
public class RegisterController {

	@InitBinder
	public void toDate(WebDataBinder binder) {
		ConversionService conversionService = binder.getConversionService();
		System.out.println("conversionService="+conversionService);
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(df,false));
		binder.registerCustomEditor(String[].class, "hobby", new StringArrayPropertyEditor("#"));
//		binder.setValidator(new UserValidator()); // UserValidator를 WebDataBinder의 로컬 validator로 등록
		binder.addValidators(new UserValidator());
		List<Validator> validatorList = binder.getValidators();
	}
	
	@RequestMapping(value="/add", method={RequestMethod.GET, RequestMethod.POST})
//	@GetMapping("/add")
	public String register() {
		return "registerForm"; // WEB-INF/views/registerForm.jsp
	}
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/save") // 4.3부터
	public String save(User user, Model m) throws Exception {
		System.out.println("result="+result);
		System.out.println("user="+user);
		
		UserValidator userValidator = new UserValidator();
		userValidator.validate(user, result); // BinderResult는 Error의 자손
		
		// User 객체를 검증한 결과 에러가 있으면, registerForm을 이용하여 에러를 보여줘야 함.
		if(result.hasErrors() ) {
			return "registerForm";
		}
//		// 1. 유효성 검사
//		if(!isValid(user)) {
//			String msg = URLEncoder.encode("id를 잘못 입력하셨습니다.", "utf-8");
//			
//			m.addAttribute("msg", msg);
//			// redirect : 재요청
//			return "redirect:/register/add";
////			return "redirect:/register/add?msg="+msg; // URL재작성(rewriting)
//		}
		
		// 2. DB에 신규회원 정보를 저장
		return "registerInfo";
	}

private boolean isValid(User user) {
	// TODO Auto-generated method stub
	return true;
}
}
