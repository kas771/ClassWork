import java.util.ArrayList;

/**
 * collision class
 *  
 * @author kathrynsutton
 *
 */
public class Collision implements Comparable<Collision> {
	//location in ArrayList for each from source file
	public final static int ZIP = 3;
	public final static int INJ = 8;
	private final int KILL = 9;
	public final static int CYC_INJ = 12;
	private final int CYC_KILL = 13;
	private final int VEH = 19;
	

	
	private int zip;//zipcode where it occurred
	private int injured;//total number injured
	private int killed;//total number killed
	private int cyc_injuried;//number cyclists injured
	private int cyc_killed;//number cyclists killed
	private String vehicle;//vehicle type
	
	private int feature;//used for sorting purposes
	
	//default constructor
	Collision(){}
	
	/**
	 * 
	 * @param event
	 */
	public Collision(ArrayList<String> event){
		this.zip = zip(event);
		this.injured = injured(event);
		this.killed = killed(event);
		this.cyc_injuried = cycInj(event);
		this.cyc_killed = cycKill(event);
		this.vehicle = vehicle(event);
		this.feature = -5;
	}


	//getters and setters
	/////////////////////
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
	public void setZip(int z){
		this.zip = z;
	}
	/**
	 * 
	 * @return
	 */
	public int getInj(){
		return this.injured;
	}
	public void setInj(int inj){
		this.injured =inj;
	}
	public int getKill(){
		return this.killed;
	}
	
	public void setKill(int kill){
		this.killed =kill;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getCycInj(){
		return this.cyc_injuried;
	}
	
	public void setCycInj(int cyc){
		this.cyc_injuried = cyc;
	}
	
	public int getCycKill(){
		return this.cyc_killed;
	}
	
	public void setCycKill(int kill){
		this.cyc_killed = kill;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getVeh(){
		return this.vehicle;
	}
	
	public void setVeh(String v){
		this.vehicle = v;
	}

	///gets information from the event passed in
	/////////////////////////////
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
		int inj = Integer.parseInt(i);
		return inj;
	}
	
	private int killed(ArrayList<String> event){
		String k = event.get(KILL);
		int kill = Integer.parseInt(k);
		return kill;
	}
	
	/**
	 * 
	 * @param event
	 * @return
	 */
	private int cycInj(ArrayList<String> event){
		String i = event.get(CYC_INJ);
		int inj = Integer.parseInt(i);
		return inj;
	}
	
	private int cycKill(ArrayList<String> event){
		String k = event.get(CYC_KILL);
		int kill = Integer.parseInt(k);
		return kill;
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
	
	/////other methods
	/**
	 * 
	 */
	public void print(){
		System.out.println("Zipcode: " + this.zip);
		System.out.println("Number total injured or killed: " + this.injured + this.killed);
		System.out.println("Number cyclists injured or killed: " + this.cyc_injuried + this.cyc_killed);
		System.out.println("Vehicle type: " + this.vehicle);
		System.out.println("Feature: " + this.feature);
		System.out.println(" flag 8");
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
