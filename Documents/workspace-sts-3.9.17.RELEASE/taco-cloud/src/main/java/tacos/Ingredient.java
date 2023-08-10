package tacos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Ingredient {
	
	// getter, setter method 없다?
	// equals(), hashCode(), toString() 없다?
	// -> lombok 좋은 라이브러리 사용해서 그런 메서드들을 자동으로 생성하기 때문
	private final String id;
	private final String name;
	private final Type type;
	
	public static enum Type {
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
	}
}
