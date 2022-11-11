package shape;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CircleTest {
	private final String CLASS_NAME = "shape.Circle";
	private final String METHOD_NAME = "calcArea";

	private Constructor<?> circle_constructor;
	private Method method;
	
	@BeforeEach
	void before() {
		try {
			Class<?> circle_class = Class.forName(CLASS_NAME);
			circle_constructor = circle_class.getDeclaredConstructor(LengthValue.class);
			circle_constructor.setAccessible(true);			
			method = circle_class.getMethod(METHOD_NAME);
		} catch (Exception e) {
			e.printStackTrace();
			fail("初期化失敗によりテスト強制終了");
		}
	}
	
	@Test
	@DisplayName("simple test")
	void test() {
		try
		{
			LengthValue radius = new LengthValue(10.0);
			Object test_circle = circle_constructor.newInstance(radius);
			assertThat(method.invoke(test_circle), is(314.1592653589793));
		}catch (Exception e) {
			e.printStackTrace();
			fail("例外発生によりテスト強制終了");
		}
	}

	@Test
	@DisplayName("zero test")
	void illegal_test() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			//new Circle(new LengthValue(0.0));						
			new LengthValue(0.0);
		});
	}
}
