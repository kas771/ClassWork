import java.util.ArrayList;

/**
 * collision class represents a single collision from one line of the 
 * input file
 *  
 * @author kathrynsutton
 *
 */
public class Collision implements Comparable<Collision> {
	//location in ArrayList of each variable from source file
	private final int ZIP = 3;
	private final int INJ = 8;
	private final int KILL = 9;
	private final int CYC_INJ = 12;
	private final int CYC_KILL = 13;
	private final int VEH = 19;


	private int zip;//zipcode where it occurred
	private int injured;//total number injured
	private int killed;//total number killed
	private int cyc_injuried;//number cyclists injured
	private int cyc_killed;//number cyclists killed
	private String vehicle;//vehicle type

	public final int[] f = {0, 1, 2, 3};//used for sorting purposes
	//valid values are:
	//0 = zipcode, 1 = injured and killed, 2 = cyclists injured and killed, 
	//3 = number collisions
	
	//the types of vehicles of interest
	private final String[] VEHICLE_TYPES = {"taxi", "bus", "bicycle", "fire truck", "ambulance"};

	//must be set to one of the above values in f
	private int feature;

	/**
	 * default constructor
	 */
	Collision(){}

	/**
	 * generates a collision object from one line of the input file
	 * requires all elements in ArrayList contain a string
	 * sets feature to -1, must be reset for sorting
	 * @param event the ArrayList of Strings 
	 */
	public Collision(ArrayList<String> event){
		if(isValid(event) == true){
			this.zip = zip(event);
			this.injured = injured(event);
			this.killed = killed(event);
			this.cyc_injuried = cycInj(event);
			this.cyc_killed = cycKill(event);
			this.vehicle = vehicle(event);
			this.feature = -1;
		}
	}


	//getters and setters
	/////////////////////
	/**
	 * @return the feature of the collision object
	 */
	int getFeature(){
		return this.feature;
	}	

	/**
	 * sets feature to input integer if that integer is a valid value
	 * contained in the array 
	 * @param a integer for sorting
	 */
	void setFeature(int a){
		//check that a is a valid feature
		if (isValidFeature(a) == true){
			this.feature = a;
		}
	}
	/**
	 * 
	 * @return the int zipcode of the collision object
	 */
	public int getZip(){
		return this.zip;
	}

	/**
	 * sets the zipcode of the collision object
	 * @param z int value of zipcode
	 */
	public void setZip(int z){
		this.zip = z;
	}

	/**
	 * @return the total number of injured people in the collision
	 */
	public int getInj(){
		return this.injured;
	}

	/**
	 * sets the total number of people injured
	 * @param inj the number of injured
	 */
	public void setInj(int inj){
		if (isValidNumberPeople(inj) == true){
			this.injured =inj;
		}
	}

	/**
	 * @return the total number of people killed in the collision
	 */
	public int getKill(){
		return this.killed;
	}

	/**
	 * sets the total number of people killed
	 * @param kill
	 */
	public void setKill(int kill){
		if (isValidNumberPeople(kill) == true){
			this.killed =kill;
		}
	}

	/**
	 * 
	 * @return the total number of cyclists injured
	 */
	public int getCycInj(){
		return this.cyc_injuried;
	}

	/**
	 * 
	 * @param cyc sets number of cyclists injured
	 */

	public void setCycInj(int cyc){
		if (isValidNumberPeople(cyc) == true){
			this.cyc_injuried = cyc;
		}
	}

	/**
	 * 
	 * @return number cyclists killed in collision
	 */

	public int getCycKill(){
		return this.cyc_killed;
	}

	/**
	 * sets the number of cyclists killed in collision
	 * @param kill
	 */

	public void setCycKill(int kill){
		if (isValidNumberPeople(kill) == true){
			this.cyc_killed = kill;
		}
	}
	
	//TODO: build in check for vehicle type

	/**
	 * 
	 * @return the vehicle type as a string
	 */
	public String getVeh(){
		return this.vehicle;
	}

	/**
	 * sets the vehicle type
	 * @param v string vehicle type name
	 */

	public void setVeh(String v){
		this.vehicle = vehicleType(v);
	}



	///gets information from the event passed in
	/////////////////////////////
	/**
	 * finds zipcode element in input and returns the integer representation
	 * @param event ArrayList of strings
	 * @return an integer representation of the zipcode, -1 if the event was invalid
	 */
	private int zip(ArrayList<String> event){
		if (isValid(event) == true){
			String z  = event.get(ZIP);
			int zip = Integer.parseInt(z);
			return zip;
		} else {return -1;}
	}

	/**
	 * finds total injured element in input and returns the integer representation
	 * @param event ArrayList of strings
	 * @return an integer representation of total number injured, -1 if the event was invalid
	 * 		or number of injured was invalid
	 */
	private int injured(ArrayList<String> event){
		if (isValid(event) == true){
			String i = event.get(INJ);
			int inj = Integer.parseInt(i);
			if (isValidNumberPeople(inj)== true){
				return inj;
			} else{
				return -1;
			}
		} else {
			return -1;
		}
	}

	/**
	 * finds total killed element in input and returns the integer representation
	 * @param event ArrayList of strings
	 * @return an integer representation of total number killed, -1 if the event was invalid
	 * 		or number of killed was invalid
	 */

	private int killed(ArrayList<String> event){
		if (isValid(event) == true){
			String k = event.get(KILL);
			int kill = Integer.parseInt(k);
			if (isValidNumberPeople(kill)== true){
				return kill;
			} else {
				return -1;
			}
		} else {
			return -1;
		}

	}


	/**
	 * finds total cyclists injured element in input and returns the integer representation
	 * @param event ArrayList of strings
	 * @return an integer representation of total number cyclists injured, -1 if the event was invalid
	 * 		or number of injured was invalid
	 */
	private int cycInj(ArrayList<String> event){
		if (isValid(event) == true){
			String i = event.get(CYC_INJ);
			int inj = Integer.parseInt(i);
			if (isValidNumberPeople(inj)== true){
				return inj;
			} else {
				return -1;
			}
		} else {
			return -1;
		}
	}

	/**
	 * finds total cyclists killed element in input and returns the integer representation
	 * @param event ArrayList of strings
	 * @return an integer representation of total number cyclists killed, -1 if the event was invalid
	 * 		or number of killed was invalid
	 */

	private int cycKill(ArrayList<String> event){
		if (isValid(event) == true){
			String k = event.get(CYC_KILL);
			int kill = Integer.parseInt(k);
			if (isValidNumberPeople(kill)== true){
				return kill;
			} else {
				return -1;
			}
		} else {
			return -1;
		}
	}

	
	/**finds vehicle element in input and returns the string representation
	 * @param event ArrayList of strings
	 * @return one of the vehicle types or "other"
	 */
	private String vehicle(ArrayList<String> event){
		String vehicle = event.get(VEH);
		return vehicleType(vehicle);
	}

	/////other methods
	/**
	 * print to screen attributes of collision
	 */
	public void print(){
		System.out.println("Zipcode: " + this.zip);
		System.out.println("Number total injured or killed: " + this.injured + this.killed);
		System.out.println("Number cyclists injured or killed: " + this.cyc_injuried + this.cyc_killed);
		System.out.println("Vehicle type: " + this.vehicle);
		System.out.println("Feature: " + this.feature);
		//System.out.println(" flag 8");
	}


	/**
	 * compares collisions based on designated feature of collision which must be 
	 * set with setFeature method
	 * 
	 * valid values of feature are given by: 0 = zipcode, 1 = injured and killed,
	 * 2 = cyclists injured and killed, 3 = number collisions
	 * 
	 * ranks higher values of all features first
	 * 
	 * does not change order if could not rank
	 */
	@Override
	public int compareTo(Collision c) {
		if (isValidFeature(this.feature) == true && isValidFeature(c.feature) == true){
			if (feature == f[0]){
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

			if (feature == f[1]){
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

			if (feature == f[2]){
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
		}  else {
			System.out.println("Invalid comparison");
			return -5;
		} 
			return -5;
		
	}

	/**
	 * checks whether an integer is a valid feature by seeing if it's
	 * in the integer array f
	 * @param a the integer that might be in f
	 * @return true if a is a valid feature, false if invalid
	 */
	public boolean isValidFeature(int a){
		boolean contains = false;
		for (int i = 0; i < f.length; i++){
			if (f[i]== a){
				return true;
			}
		}
		return contains;
	}

	/**
	 * ensures that there are no negative values of injuries or fatalities
	 * @param a the number of injured/killed
	 * @return true if a is non-negative
	 */
	private boolean isValidNumberPeople(int a){
		if (a >= 0){
			return true;
		} else { return false;}
	}

	/**
	 * checks that the input list of strings from a line of the input file has the 
	 * correct number of elements
	 * @param event ArrayList that should have 21 elements
	 * @return true if has exactly 21 elements
	 */
	private boolean isValid( ArrayList<String> event){

		if (event.size() == 21){
			return true;
		} else { return false;}
	}

	/**
	 * checks if the string vehicle matches one of the vehicle types 
	 * @param s the string to compare to vehicle types
	 * @return the type of vehicle as a string if it matches one of the types, or "other" if
	 * it doesn't
	 */
	private String vehicleType(String s){
		for (int i = 0; i < VEHICLE_TYPES.length; i++){
			if (s.equalsIgnoreCase(VEHICLE_TYPES[i]) == true){
				return VEHICLE_TYPES[i];
			} 
		} return "other";
	}
	
}
