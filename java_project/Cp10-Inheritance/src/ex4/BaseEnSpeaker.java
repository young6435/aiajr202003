package ex4;

public class BaseEnSpeaker extends Speaker {
	
	private int baseRate;
	
	void setBaseRate(int base) {
		this.baseRate = base;
	}

	@Override
	void showCurrnetState() {
		
		super.showCurrnetState();
		System.out.println("베이스의 크기 : "+baseRate);
	
	}

	@Override
	public String toString() {
		
		return "베이스 스피커";
	}
	
	
}
