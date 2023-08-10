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
    	
    	// 1. ��ȿ�� �˻�
//    	if(!isVaild(year, month, day))
//    		return "yoilError";
    	
    	// 2. ���� ���
    	char yoil = getYoil(year, month, day);

    	// 3. ����� ����� model�� ����
    	mv.addObject("year", year);
    	mv.addObject("month", month);
    	mv.addObject("day", day);
    	mv.addObject("yoil", yoil);
    	
    	// 4. ����� ������ view�� ����
    	mv.setViewName("yoil");
    	
    	return mv;
    	
    	
//    return "yoil"; // WEB-INF/views/yoil.jsp
        
        // 3. ���
//        System.out.println(year + "�� " + month + "�� " + day + "���� ");
//        System.out.println(yoil + "�����Դϴ�.");
//        response.setContentType("text/html");    // ������ ������ html�� ����
//        response.setCharacterEncoding("utf-8");  // ������ ���ڵ��� utf-8�� ����
//        PrintWriter out = response.getWriter();  // reponse��ü���� ���������� ��� ��Ʈ��(out)�� ��´�.
//        out.println("<html>");
//        out.println("<head>");
//        out.println("</head>");
//         out.println("<body>");
//        out.println(year + "�� " + month + "�� " + day + "���� ");
//        out.println(yoil + "�����Դϴ�.");
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
        return " �Ͽ�ȭ�������".charAt(dayOfWeek);   // �Ͽ���:1, ������:2, ... 
	}
}

