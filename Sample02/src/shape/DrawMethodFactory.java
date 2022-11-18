package shape;

//描画を担当するクラス。１個だけにしたいのでシングルトン。
public class DrawMethodFactory {
	private final DrawMethod method;
	private DrawMethodFactory(DrawMethod method) {
		this.method = method;
	}
	
	public static DrawMethodFactory getInstance() {
		return DrawMethodInstance.instance;
	}
	
	public final DrawMethod getDrawMethod() {
		return method;
	}
	
	private static class DrawMethodInstance{
		//実行するシステムでどれを生成するか分けるべき。
		public static final DrawMethodFactory instance = new DrawMethodFactory(new DrawShapeInWindows());
	}
}
