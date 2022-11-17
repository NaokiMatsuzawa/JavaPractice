package decorator_pattern_test;

abstract public class ShowMessage {
	abstract public void show();
}

class ShowMessageConcrete extends ShowMessage{
	public void show() {
		System.out.println("こちらは本体クラスです？");
	}
}

abstract class ShowMessageDecorator extends ShowMessage{
	ShowMessage component;
	public ShowMessageDecorator(ShowMessage component) {
		this.component =  component;
	}
	
	void call() {
		component.show();
	};
}

class ShowMessageHeaderDecorator1 extends ShowMessageDecorator{
	public ShowMessageHeaderDecorator1(ShowMessage component) {
		super(component);
	}

	@Override
	public void show() {
		System.out.println("こちらはヘッダーデコレータークラスその１です");
		call();
	}	
}

class ShowMessageHeaderDecorator2 extends ShowMessageDecorator{
	public ShowMessageHeaderDecorator2(ShowMessage component) {
		super(component);
	}

	@Override
	public void show() {
		System.out.println("こちらはヘッダーデコレータークラスその２です");
		call();
	}	
}

class ShowMessageFooterDecorator1 extends ShowMessageDecorator{

	public ShowMessageFooterDecorator1(ShowMessage component) {
		super(component);
	}

	@Override
	public void show() {
		call();
		System.out.println("こちらはフッターデコレータークラスその１です");		
	}	
}

class ShowMessageFooterDecorator2 extends ShowMessageDecorator{

	public ShowMessageFooterDecorator2(ShowMessage component) {
		super(component);
	}

	@Override
	public void show() {
		call();
		System.out.println("こちらはフッターデコレータークラスその２です");		
	}	
}

