package shape;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CircleTest {

	@Test
	@DisplayName("simple test")
	void test() {
		Circle circle = new Circle(10.0);
		assertThat(circle.calcArea(), is(314.1592653589793));
	}

	@Test
	@DisplayName("zero test")
	void illegal_test() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Circle(0.0);						
		});
	}
}
