package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

@Controller
public class YoilTellerMVC {
    @RequestMapping("/getYoilMVC") // http://localhost/ch2/getYoilMVC?year=2021&month=10&day=1
    //    public static void main(String[] args) {
    	public ModelAndView main(int year, int month, int day) throws IOException {

    	ModelAndView mv = new ModelAndView();
    	
    	// 1. 유효성 검사
//    	if(!isVaild(year, month, day))
//    		return "yoilError";
    	
    	// 2. 요일 계산
    	char yoil = getYoil(year, month, day);

    	// 3. 계산한 결과를 model에 저장
    	mv.addObject("year", year);
    	mv.addObject("month", month);
    	mv.addObject("day", day);
    	mv.addObject("yoil", yoil);
    	
    	// 4. 결과를 보여줄 view를 지정
    	mv.setViewName("yoil");
    	
    	return mv;
    	
    	
//    return "yoil"; // WEB-INF/views/yoil.jsp
        
        // 3. 출력
//        System.out.println(year + "년 " + month + "월 " + day + "일은 ");
//        System.out.println(yoil + "요일입니다.");
//        response.setContentType("text/html");    // 응답의 형식을 html로 지정
//        response.setCharacterEncoding("utf-8");  // 응답의 인코딩을 utf-8로 지정
//        PrintWriter out = response.getWriter();  // reponse객체에서 브라우저로의 출력 스트림(out)을 얻는다.
//        out.println("<html>");
//        out.println("<head>");
//        out.println("</head>");
//         out.println("<body>");
//        out.println(year + "년 " + month + "월 " + day + "일은 ");
//        out.println(yoil + "요일입니다.");
//        out.println("</body>");
//        out.println("</html>");
//        out.close();
    }

	private boolean isVaild(int year, int month, int day) {
		// TODO Auto-generated method stub
		return false;
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
    	cal.set(year, month - 1, day);
        
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return " 일월화수목금토".charAt(dayOfWeek);   // 일요일:1, 월요일:2, ... 
	}
}

