package Ch7;

// 8.4 내부 클래스의 제어자와 접근성


public class InnerEx1 {
	
	// 인스턴스 내부 클래스
	class InstanceInner {
		int iv = 100;
//		static int cv = 100; // 에러! static 변수를 선언할 수 없다!
		final static int CONST = 100; // final static은 상수이므로 허용
	}
	
	// static 내부 클래스
	static class StaticInner {
		int iv = 200;
		static int cv = 200; // static 클래스만 static 멤버를 정의할 수 있다!
	}
	
	void myMethod() {
		class LocalInner {                                                                     
			int iv = 300;
//			static int cv = 300; // 에러! static 변수를 선언할 수 없다!
			final static int CONST = 300; // final static은 상수이므로 허용
		}
	}
	
	public static void main(String args[]) {
		System.out.println(InstanceInner.CONST);
		System.out.println(StaticInner.cv);
	}
}
