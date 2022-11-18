package shape;

import java.util.Scanner;

public class ShapeFactory {
	public Shape createCircle(DrawMethod method) {
		Scanner scn = system_in.SystemIn.getScanner();

        System.out.print("半径？");
        LengthValue radius = new LengthValue(scn.nextDouble());;
        Circle circle = new Circle(method, radius);
        //scn.close();
        
		return circle;
	}
	
	public Shape createTrapezoid(DrawMethod method) {
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
