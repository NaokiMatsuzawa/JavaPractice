package shape;

interface ShapeMethod {
	public double calcArea();
	public void draw();
}

class LengthValue{
	final double length;
	
	LengthValue(final double length){
		if(length <= 0.0) {
			throw new IllegalArgumentException("入力された長さの値が0以下の値です。正の値を入れてください");
		}
		this.length = length;
	}
}

public abstract class Shape implements ShapeMethod{
	final private DrawMethod method;
	
	protected Shape(DrawMethod method) {
		if(method == null) {
			throw new IllegalArgumentException("NULLのDrawMethodが指定されました");
		}
		this.method = method;
	}

	@Override
	public void draw() {
		method.draw();
	}
}

/*
 * 画面に図形を描画したい場合は
 * 円であれば中心点を
 * 四角形であれば台形などの具体的な図形にせず、４点を指定するなどの処理に変えるべき
 */

class Trapezoid extends Shape{
	LengthValue jotei;
	LengthValue katei;
	LengthValue takasa;
	
	Trapezoid(DrawMethod method, LengthValue jotei, LengthValue katei, LengthValue takasa) {
		super(method);
		this.jotei = jotei;
		this.katei = katei;
		this.takasa = takasa;
	}
	
	@Override
	public double calcArea() {
		return (jotei.length + katei.length) * takasa.length / 2.0;
	}
}

class Circle extends Shape{
	LengthValue radius;
	
	Circle(DrawMethod method, LengthValue radius) {
		super(method);
		this.radius = radius;
	}

	@Override
	public double calcArea() {
		return radius.length * radius.length * Math.PI;
	}
}

