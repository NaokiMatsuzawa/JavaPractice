package shape;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrapezoidTest {

	private final String CLASS_NAME = "shape.Trapezoid";
	private final String METHOD_NAME = "calcArea";
	private final DrawMethod draw_method = new shape.DrawShapeInWindows();
	
	private Constructor<?> constructor;
	private Method method;
	
	@BeforeEach
	void before() {
		try {
			Class<?> test_class = Class.forName(CLASS_NAME);
			constructor = test_class.getDeclaredConstructor(DrawMethod.class, LengthValue.class, LengthValue.class, LengthValue.class);
			constructor.setAccessible(true);
			method = test_class.getMethod(METHOD_NAME);
		} catch (Exception e) {
			e.printStackTrace();
			fail("初期化失敗によりテスト強制終了");
		}
	}
	
	@Test
	void test() {
		try {
			LengthValue jotei = new LengthValue(10.0);
			LengthValue katei = new LengthValue(20.0);
			LengthValue takasa = new LengthValue(5.0);
			Object test_trapezoid = constructor.newInstance(draw_method, jotei, katei, takasa);
			assertThat(method.invoke(test_trapezoid), is(75.0));	
		} catch(Exception e) {
			e.printStackTrace();
			fail("例外発生によりテスト強制終了");
		}
	}

}
