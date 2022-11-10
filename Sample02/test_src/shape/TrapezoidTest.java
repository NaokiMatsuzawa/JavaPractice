package shape;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.Test;

class TrapezoidTest {

	@Test
	void test() {
		Trapezoid trapezoid = new Trapezoid(10.0, 20.0, 5.0);
		assertThat(trapezoid.calcArea(), is(75.0));
	}
	
	@Test
	void test00() {
		//平行四辺形
		Trapezoid trapezoid = new Trapezoid(10.0, 10.0, 10.0);
		assertThat(trapezoid.calcArea(), is(100.0));
	}

}
