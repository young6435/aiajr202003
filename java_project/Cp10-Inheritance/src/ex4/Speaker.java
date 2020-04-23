package ex4;						// // Speaker, OverridingTest, BaseEnSpeaker 한세트.

public class Speaker {

	private int volumeRate;
	
	void showCurrnetState() {
		System.out.println("볼륨의 크기 : "+this.volumeRate);
		
	}

	void setVolume(int vol) {
		
		this.volumeRate = vol;
	}




}
