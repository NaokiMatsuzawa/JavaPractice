package shape;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CircleTest {
	private final DrawMethod draw_method = new shape.DrawShapeInWindows();

	@Test
	@DisplayName("simple test")
	void test() {
		try
		{
			LengthValue radius = new LengthValue(10.0);
			Circle circle = new Circle(draw_method, radius);
			assertThat(circle.calcArea(), is(314.1592653589793));
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
