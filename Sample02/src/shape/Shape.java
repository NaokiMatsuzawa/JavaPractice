package shape;

import java.util.Scanner;

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
	
	private Trapezoid(DrawMethod method, LengthValue jotei, LengthValue katei, LengthValue takasa) {
		super(method);
		this.jotei = jotei;
		this.katei = katei;
		this.takasa = takasa;
	}
	
	@Override
	public double calcArea() {
		return (jotei.length + katei.length) * takasa.length / 2.0;
	}

	public static Shape create(DrawMethod method) {
        Scanner scn = system_in.SystemIn.getScanner();

        System.out.print("上辺 = ");
        LengthValue jotei = new LengthValue(scn.nextDouble());
        System.out.print("下辺 = ");
        LengthValue katei = new LengthValue(scn.nextDouble());
        System.out.print("高さ = ");
        LengthValue takasa = new LengthValue(scn.nextDouble());
        Trapezoid trapezoid = new Trapezoid(method, jotei, katei, takasa);

		return trapezoid;
	}
}

class Circle extends Shape{
	LengthValue radius;
	
	private Circle(DrawMethod method, LengthValue radius) {
		super(method);
		this.radius = radius;
	}

	@Override
	public double calcArea() {
		return radius.length * radius.length * Math.PI;
	}

	public static Shape create(DrawMethod method) {
		Scanner scn = system_in.SystemIn.getScanner();

        System.out.print("半径？");
        LengthValue radius = new LengthValue(scn.nextDouble());;
        Circle circle = new Circle(method, radius);
        //scn.close();
        
		return circle;
	}
}

