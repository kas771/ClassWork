import java.util.ArrayList;

/**
 * collision class
 *  
 * @author kathrynsutton
 *
 */
public class Collision {
	//location in arraylist for each
	private final int ZIP = 3;
	private final int INJ = 8;
	private final int KILL = 9;
	private final int CYC_INJ = 12;
	private final int CYC_KILL = 13;
	private final int VEH = 19;

	//zipcode where it occurred
	int zip;
	
	//number total persons injuries and fatalities
	int injured;
	
	//number of cyclist injuries and fatalities
	int cyc_injuried;
	
	//vehicle type
	String vehicle;
	
	//default constructor
	Collision(){}
	
	public Collision(ArrayList<String> event){
		this.zip = zip(event);
		this.injured = injured(event);
		this.cyc_injuried = cyc(event);
		this.vehicle = vehicle(event);
	}
	
	public void print(){
		System.out.println("Zipcode: " + this.zip);
		System.out.println("Number total injured or killed: " + this.injured);
		System.out.println("Number cyclists injured or killed: " + this.cyc_injuried);
		System.out.println("Vehicle type: " + this.vehicle);
	}
	
	int getZip(){
		return this.zip;
	}
	
	int getInj(){
		return this.injured;
	}
	
	int getCycInj(){
		return this.cyc_injuried;
	}
	
	String getVeh(){
		return this.vehicle;
	}
	
	private int zip(ArrayList<String> event){
		String z  = event.get(ZIP);
		int zip = Integer.parseInt(z);
		return zip;
	}
	
	private int injured(ArrayList<String> event){
		String i = event.get(INJ);
		String k = event.get(KILL);
		int inj = Integer.parseInt(i);
		int kill = Integer.parseInt(k);
		inj+= kill;
		return inj;
	}
	
	private int cyc(ArrayList<String> event){
		String i = event.get(CYC_INJ);
		String k = event.get(CYC_KILL);
		int inj = Integer.parseInt(i);
		int kill = Integer.parseInt(k);
		inj+= kill;
		return inj;
	}
	
	private String vehicle(ArrayList<String> event){
		String vehicle = event.get(VEH);
		return vehicle;
	}
}
