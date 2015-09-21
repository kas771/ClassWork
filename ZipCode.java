/**
 * a zipcode object holds similar info as compared to collision object
 * @author kathrynsutton
 *
 */
public class ZipCode {
	int zip;
	int collisions;
	int inj_fat;
	int cyc_inj_fat;
	
	ZipCode(Collision c){
		this.zip = c.getZip();
		this.collisions = 1;
		this.inj_fat = c.getInj();
		this.cyc_inj_fat = c.getCycInj();
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
	
	
}
