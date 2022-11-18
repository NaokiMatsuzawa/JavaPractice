package shape;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TrapezoidTest {

	private final DrawMethod draw_method = new shape.DrawShapeInWindows();


	@Test
	@DisplayName("Trapezoid Test")
	void test() {
		try {
			LengthValue jotei = new LengthValue(10.0);
			LengthValue katei = new LengthValue(20.0);
			LengthValue takasa = new LengthValue(5.0);
			Trapezoid test_trapezoid = new Trapezoid(draw_method, jotei, katei, takasa);
			assertThat(test_trapezoid.calcArea(), is(75.0));	
		} catch(Exception e) {
			e.printStackTrace();
			fail("例外発生によりテスト強制終了");
		}
	}

}
