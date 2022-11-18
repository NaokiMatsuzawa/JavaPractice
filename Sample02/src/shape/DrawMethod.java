package shape;

public interface DrawMethod {
	void draw();
}

class DrawShapeInWindows implements DrawMethod{

	@Override
	public void draw() {
		System.out.println("Windowsのウィンドウで図形を描画します");
	}
}

class DrawShapeInPS5 implements DrawMethod{

	@Override
	public void draw() {
		System.out.println("PS5の何らかの画面で図形を描画します");
	}
}

