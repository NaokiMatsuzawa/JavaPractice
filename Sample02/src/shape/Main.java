package shape;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		shape.Shape[] shapes = new shape.Shape[2];
		shape.DrawMethod method_in_windows = new shape.DrawShapeInWindows();
		shape.DrawMethod method_in_ps5 = new shape.DrawShapeInPS5();
		shapes[0] = shape.Circle.create(method_in_windows);
		shapes[1] = shape.Trapezoid.create(method_in_ps5);
		for(Shape shape : shapes) {
			System.out.println("This shape's area is " + shape.calcArea());
			shape.draw();
		}
	}

}
