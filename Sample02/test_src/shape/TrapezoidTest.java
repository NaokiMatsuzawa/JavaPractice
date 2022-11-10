package shape;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.Test;

class TrapezoidTest {

	@Test
	void test() {
		LengthValue jotei = new LengthValue(10.0);
		LengthValue katei = new LengthValue(20.0);
		LengthValue takasa = new LengthValue(5.0);
		Trapezoid trapezoid = new Trapezoid(jotei, katei, takasa);
		assertThat(trapezoid.calcArea(), is(75.0));
	}
	
	@Test
	void test00() {
		//平行四辺形
		LengthValue jotei = new LengthValue(10.0);
		LengthValue katei = new LengthValue(10.0);
		LengthValue takasa = new LengthValue(10.0);
		Trapezoid trapezoid = new Trapezoid(jotei, katei, takasa);
		assertThat(trapezoid.calcArea(), is(100.0));
	}

}
