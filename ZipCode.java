/**
 * a zipcode object holds similar info as compared to collision object
 * @author kathrynsutton
 *
 */
public class ZipCode implements Comparable<ZipCode> {
	int zip;
	int collisions;
	int inj_fat;
	int cyc_inj_fat;
	int feature;
	
	ZipCode(Collision c){
		this.zip = c.getZip();
		this.collisions = 1;
		this.inj_fat = c.getInj();
		this.cyc_inj_fat = c.getCycInj();
		this.feature = -1;
	}
	
	int getZip(){
		return this.zip;
	}

	void setZip(int z){
		this.zip = z;
	}
	
	int getCollisions(){
		return this.collisions;
	}

	void setCollisions(int z){
		this.collisions = z;
	}
	
	void Collide(Collision a){
		this.collisions ++;
		this.inj_fat += a.getInj();
		this.cyc_inj_fat += a.getCycInj();
	}
	
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
	
	public void print(){
		System.out.println("Zipcode: " + this.zip);
		System.out.println("Number Collisions: " + this.collisions);
		System.out.println("Number Injuries: " + this.inj_fat);
		System.out.println("Number Cyclist Injuries: " + this.cyc_inj_fat);
	}

	@Override
	public int compareTo(ZipCode z) {
		if (feature == ZipCodeList.COLL){
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
		
		if (feature == Collision.INJ){
			if (this.inj_fat > z.inj_fat){
				return -1;
			}
			
			if (this.inj_fat == z.inj_fat){
				return 0;
			}
			
			else{
				return 1;
			}
		}
		
		if (feature == Collision.CYC_INJ){
			if (this.cyc_inj_fat > z.cyc_inj_fat){
				return -1;
			}
			
			if (this.cyc_inj_fat == z.cyc_inj_fat){
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
