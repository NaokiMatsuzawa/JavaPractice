package decorator_pattern_test;

public class ShowMessageFactory {
	private ShowMessageFactory() {
		
	}
	
	static public ShowMessageFactory getInstance() {
		return Instance.instance;
	}
	
	public ShowMessage getComponent() {
		ShowMessage myComponent = new ShowMessageConcrete();
		myComponent = new ShowMessageHeaderDecorator1(myComponent);
		myComponent = new ShowMessageHeaderDecorator2(myComponent);
		myComponent = new ShowMessageFooterDecorator1(myComponent);
		myComponent = new ShowMessageFooterDecorator2(myComponent);
		return myComponent;
	}
	
	private static class Instance{
		static final ShowMessageFactory instance = new ShowMessageFactory();
	}
}
