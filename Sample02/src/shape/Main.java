package shape;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
        Scanner scn = new Scanner(System.in);

        System.out.print("上辺 = ");
        final double jotei = scn.nextDouble();
        System.out.print("下辺 = ");
        final double katei = scn.nextDouble();
        System.out.print("高さ = ");
        final double takasa = scn.nextDouble();
        Trapezoid trapezoid = new Trapezoid(jotei, katei, takasa);
        final double menseki = trapezoid.calcArea();
        System.out.println("面積 = " + menseki);

        scn.close();
	}

}
