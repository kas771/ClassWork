import java.util.ArrayList;

/**
 * collision class
 *  
 * @author kathrynsutton
 *
 */
public class Collision implements Comparable<Collision> {
	//location in arraylist for each
	public final static int ZIP = 3;
	public final static int INJ = 8;
	private final int KILL = 9;
	public final static int CYC_INJ = 12;
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
	
	int feature;
	
	//default constructor
	Collision(){}
	
	/**
	 * 
	 * @param event
	 */
	public Collision(ArrayList<String> event){
		this.zip = zip(event);
		this.injured = injured(event);
		this.cyc_injuried = cyc(event);
		this.vehicle = vehicle(event);
		this.feature = -5;
	}

	/**
	 * 
	 */
	public void print(){
		System.out.println("Zipcode: " + this.zip);
		System.out.println("Number total injured or killed: " + this.injured);
		System.out.println("Number cyclists injured or killed: " + this.cyc_injuried);
		System.out.println("Vehicle type: " + this.vehicle);
		System.out.println("Feature: " + this.feature);
		System.out.println(" flag 8");
	}
	
	int getFeature(){
		return this.feature;
	}
	
	void setFeature(int f){
		this.feature = f;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getZip(){
		return this.zip;
	}
	
	/**
	 * 
	 * @return
	 */
	int getInj(){
		return this.injured;
	}
	
	/**
	 * 
	 * @return
	 */
	int getCycInj(){
		return this.cyc_injuried;
	}
	
	/**
	 * 
	 * @return
	 */
	String getVeh(){
		return this.vehicle;
	}
	
	/**
	 * 
	 * @param event
	 * @return
	 */
	private int zip(ArrayList<String> event){
		String z  = event.get(ZIP);
		int zip = Integer.parseInt(z);
		return zip;
	}
	
	/**
	 * 
	 * @param event
	 * @return
	 */
	private int injured(ArrayList<String> event){
		String i = event.get(INJ);
		String k = event.get(KILL);
		int inj = Integer.parseInt(i);
		int kill = Integer.parseInt(k);
		inj+= kill;
		return inj;
	}
	
	/**
	 * 
	 * @param event
	 * @return
	 */
	private int cyc(ArrayList<String> event){
		String i = event.get(CYC_INJ);
		String k = event.get(CYC_KILL);
		int inj = Integer.parseInt(i);
		int kill = Integer.parseInt(k);
		inj+= kill;
		return inj;
	}
	
	/**
	 * 
	 * @param event
	 * @return
	 */
	private String vehicle(ArrayList<String> event){
		String vehicle = event.get(VEH);
		return vehicle;
	}

	/**
	 * 
	 */
	@Override
	public int compareTo(Collision c) {
		if (feature == ZIP){
			if (this.zip > c.zip){
				return -1;
			}
			
			if (this.zip == c.zip){
				return 0;
			}
			
			else{
				return 1;
			}
		} 
		
		if (feature == INJ){
			if (this.injured > c.injured){
				return -1;
			}
			
			if (this.injured == c.injured){
				return 0;
			}
			
			else{
				return 1;
			}
		}
		
		if (feature == CYC_INJ){
			if (this.cyc_injuried > c.cyc_injuried){
				return -1;
			}
			
			if (this.cyc_injuried == c.cyc_injuried){
				return 0;
			}
			
			else{
				return 1;
			}
		}
		
		else {
			System.out.println("Invalid comparison");
			return -5;
		}
	}
}
