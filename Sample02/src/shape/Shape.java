package shape;

import java.util.Scanner;

public interface Shape {
	public double calcArea();
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

class Trapezoid implements Shape{
	LengthValue jotei;
	LengthValue katei;
	LengthValue takasa;
	
	private Trapezoid(LengthValue jotei, LengthValue katei, LengthValue takasa) {
		this.jotei = jotei;
		this.katei = katei;
		this.takasa = takasa;
	}
	
	@Override
	public double calcArea() {
		return (jotei.length + katei.length) * takasa.length / 2.0;
	}

	public static Shape create() {
        Scanner scn = system_in.SystemIn.getScanner();

        System.out.print("上辺 = ");
        LengthValue jotei = new LengthValue(scn.nextDouble());
        System.out.print("下辺 = ");
        LengthValue katei = new LengthValue(scn.nextDouble());
        System.out.print("高さ = ");
        LengthValue takasa = new LengthValue(scn.nextDouble());
        Trapezoid trapezoid = new Trapezoid(jotei, katei, takasa);

		return trapezoid;
	}
}

class Circle implements Shape{
	LengthValue radius;
	
	private Circle(LengthValue radius) {
		this.radius = radius;
	}

	@Override
	public double calcArea() {
		return radius.length * radius.length * Math.PI;
	}

	public static Shape create() {
		Scanner scn = system_in.SystemIn.getScanner();

        System.out.print("半径？");
        LengthValue radius = new LengthValue(scn.nextDouble());;
        Circle circle = new Circle(radius);
        //scn.close();
        
		return circle;
	}
}

