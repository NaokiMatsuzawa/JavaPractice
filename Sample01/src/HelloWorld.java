import java.util.Scanner;

class Person{
	public PersonWeight weight;
	public PersonHeight height;
	
	class PersonHeight{
		public final double height_cm;
		
		PersonHeight(final double height_cm){
			this.height_cm = height_cm;
		}
	}

	class PersonWeight{
		public final double weight;
		
		PersonWeight(final double weight){
			this.weight = weight;
		}
	}
	
	Person(final double height, final double weight){
		this.height = new PersonHeight(height);
		this.weight = new PersonWeight(weight);
	}
	
	double calcBMI() {
		final double height_m = height.height_cm / 100.0;
		final double bmi = weight.weight / height_m/ height_m;
		return bmi;
	}
	
}

public class HelloWorld {
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//System.out.println("Hello World");
		Scanner scn = new Scanner(System.in);
		
		System.out.println("１つ目の値を入力してください = ");
		final double height = scn.nextDouble();
		System.out.println("２つ目の値を入力してください = ");
		final double weight = scn.nextDouble();
		
		Person person = new Person(height, weight);
		
		scn.close();
		
		double bmi = person.calcBMI();
		
		System.out.println("BMI = " + bmi);
	}

}
