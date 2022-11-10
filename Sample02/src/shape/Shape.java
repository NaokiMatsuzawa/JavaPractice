package shape;

public interface Shape {
	public double calcArea();
}

class Trapezoid implements Shape{
	final double jotei;
	final double katei;
	final double takasa;
	
	public Trapezoid(final double jotei, final double katei, final double takasa) {
		this.jotei = jotei;
		this.katei = katei;
		this.takasa = takasa;
	}
	
	@Override
	public double calcArea() {
		return (jotei + katei) * takasa / 2.0;
	}
}

class Circle implements Shape{
	final double radius;
	
	public Circle(final double radius) {
		if(radius <= 0.0) {
			throw new IllegalArgumentException("入力された半径が不正です");
		}
		this.radius = radius;
	}

	@Override
	public double calcArea() {
		return radius * radius * Math.PI;
	}
}

