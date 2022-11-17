
public class Main {

	public static void main(String[] args) {
		decorator_pattern_test.ShowMessage show_message = decorator_pattern_test.ShowMessageFactory.getInstance().getComponent();
		show_message.show();
	}

}
