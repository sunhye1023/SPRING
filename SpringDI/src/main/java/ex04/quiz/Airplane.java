package ex04.quiz;

public class Airplane {

	private IBattery battery;
	
	public Airplane() {
		
	}
	
	public Airplane(IBattery battery) {
		this.battery = battery;
	}  

	public IBattery getBattery() {
		return battery;
	}

	public void setBattery(IBattery battery) {
		this.battery = battery;
	}
	
	
	
}
