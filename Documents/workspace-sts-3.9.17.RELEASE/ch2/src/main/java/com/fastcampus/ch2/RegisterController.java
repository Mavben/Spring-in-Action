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

@Controller // ctrl+shift+o �ڵ� import
@RequestMapping("/register")
public class RegisterController {

	@InitBinder
	public void toDate(WebDataBinder binder) {
		ConversionService conversionService = binder.getConversionService();
		System.out.println("conversionService="+conversionService);
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(df,false));
		binder.registerCustomEditor(String[].class, "hobby", new StringArrayPropertyEditor("#"));
//		binder.setValidator(new UserValidator()); // UserValidator�� WebDataBinder�� ���� validator�� ���
		binder.addValidators(new UserValidator());
		List<Validator> validatorList = binder.getValidators();
	}
	
	@RequestMapping(value="/add", method={RequestMethod.GET, RequestMethod.POST})
//	@GetMapping("/add")
	public String register() {
		return "registerForm"; // WEB-INF/views/registerForm.jsp
	}
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/save") // 4.3����
	public String save(User user, Model m) throws Exception {
		System.out.println("result="+result);
		System.out.println("user="+user);
		
		UserValidator userValidator = new UserValidator();
		userValidator.validate(user, result); // BinderResult�� Error�� �ڼ�
		
		// User ��ü�� ������ ��� ������ ������, registerForm�� �̿��Ͽ� ������ ������� ��.
		if(result.hasErrors() ) {
			return "registerForm";
		}
//		// 1. ��ȿ�� �˻�
//		if(!isValid(user)) {
//			String msg = URLEncoder.encode("id�� �߸� �Է��ϼ̽��ϴ�.", "utf-8");
//			
//			m.addAttribute("msg", msg);
//			// redirect : ���û
//			return "redirect:/register/add";
////			return "redirect:/register/add?msg="+msg; // URL���ۼ�(rewriting)
//		}
		
		// 2. DB�� �ű�ȸ�� ������ ����
		return "registerInfo";
	}

private boolean isValid(User user) {
	// TODO Auto-generated method stub
	return true;
}
}
