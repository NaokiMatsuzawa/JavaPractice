
public class Main {

	public static void main(String[] args) {
		decorator_pattern_test.ShowMessageFactory factory = new decorator_pattern_test.ShowMessageFactory();
		decorator_pattern_test.ShowMessage show_message = factory.getComponent();
		show_message.show();
	}

}
