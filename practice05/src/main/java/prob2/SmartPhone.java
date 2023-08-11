package prob2;

public class SmartPhone extends MusicPhone {

	@Override
	public void execute(String function) {
		if ("앱".equals(function)) {
			startApp();
			return;
		}
		super.execute(function);
	}

	private void startApp() {
		System.out.println("앱실행");
	}

}
