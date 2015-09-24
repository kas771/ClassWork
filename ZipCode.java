/**
 * a zipcode object holds similar info as compared to collision object, but also has
 * number of collisions per zipcode
 * @author kathrynsutton
 *
 */
public class ZipCode extends Collision {
	//int zip;
	private int collisions; //the number of collisions per zipcode
	/*
	int inj_fat;
	int cyc_inj_fat;
	int feature;
	 */

	/**
	 * generates a zipcode object from a collision object
	 * @param c
	 */
	ZipCode(Collision c){
		this.zip = c.getZip();
		this.collisions = 1;
		this.injured = c.getInj();
		this.killed = c.getKill();
		this.cyc_injuried = c.getCycInj();
		this.feature = -1;
	}

	/**
	 * @return the int zipcode 
	 */
	public int getZip(){
		return this.zip;
	}

	/**
	 * sets the zip to a given int
	 */
	public void setZip(int z){
		this.zip = z;
	}

	/**
	 * 
	 * @return the number of collisions in this zipcode
	 */
	int getCollisions(){
		return this.collisions;
	}

	/**
	 * set the number of collisions for this zipcode
	 * @param z
	 */
	void setCollisions(int z){
		if (isValidNumber(z)){
			this.collisions = z;
		}
	}

	/**
	 * for a new collision, adds data for zipcode
	 * @param a collision of same zipcode
	 */
	void Collide(Collision a){
		if (this.zip == a.getZip()){
			this.collisions ++;
			this.injured += a.getInj();
			this.killed += a.getKill();
			this.cyc_injuried += a.getCycInj();
			this.cyc_killed += a.getCycKill();
		}
	}

	/*
	int getInj(){
		return this.inj_fat;
	}

	void setInj(int z){
		this.inj_fat = z;
	}

	int getCycInj(){
		return this.cyc_inj_fat;
	}

	void setCycInj(int z){
		this.cyc_inj_fat = z;
	}
	 */
	@Override
	public void print(){
		super.print();
		System.out.println("Number Collisions: " + this.collisions);
	}


	/**
	 * same as compareTo in Collision class with the addition of compare by number of
	 * collisions per zipcode
	 * @param z the zipcode to compare with
	 * @return sorts highest to lowest for given feature, unchange if invalid feature
	 */
	public int compareTo(ZipCode z) {
		if (isValidFeature(this.feature) == true && isValidFeature(z.feature) == true){
			if (feature == f[3]){
				if (this.collisions > z.collisions){
					return -1;
				}

				if (this.collisions == z.collisions){
					return 0;
				}

				else{
					return 1;
				}
			} 


			if (feature == f[0]){
				if (this.zip > z.zip){
					return -1;
				}

				if (this.zip == z.zip){
					return 0;
				}

				else{
					return 1;
				}
			} 

			if (feature == f[1]){
				int ik = this.injured + this.killed;
				int IK = z.injured + z.killed;
				if (ik > IK){
					return -1;
				}

				if (ik == IK){
					return 0;
				}

				else{
					return 1;
				}
			}

			if (feature == f[2]){
				int ci = this.cyc_injuried + this.cyc_killed;
				int CI = z.cyc_injuried + z.cyc_killed;
				if (ci > CI){
					return -1;
				}

				if (ci == CI){
					return 0;
				}

				else{
					return 1;
				}
			} else {
				return -5;
			}
		}

			else {
				//System.out.println("Invalid comparison");
				return -5;
			}
	}
}
