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
