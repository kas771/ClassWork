import java.util.ArrayList;
import java.util.Collections;

/**
 * this class is meant to organize zipcode objects
 * @author kathrynsutton
 *
 */
public class ZipCodeList {
	
	ArrayList<ZipCode> zip_list;
	int feature;
	public static final int COLL = 2;

	/*
	 * requires collision list sorted by zipcode
	 */
	ZipCodeList(CollisionList list){
		feature = -1;
		if (list.size()> 1){
		ArrayList<ZipCode> zips = new ArrayList<ZipCode>();
		ZipCode a = new ZipCode(list.get(0));
		for (int i = 1; i< list.size(); i++){
			Collision b = list.get(i);
			if (b.getZip() != a.getZip()){
				zips.add(a);
				a = new ZipCode(b);
			} else {
				a.Collide(b);
			}
		}
		this.zip_list = zips;
		} else {
			System.out.println("need more collisions, there were only : " + list.size());
		}
	}
	public void setFeature(int f){
		this.feature = f;
		for (int i = 0; i < this.zip_list.size(); i ++){
			this.zip_list.get(i).feature = f;
		}
	}
	public void sort() {
		if (this.feature == COLL || this.feature == Collision.INJ || 
		this.feature == Collision.CYC_INJ){
			Collections.sort(this.zip_list);
		}
		else{
			System.out.println("invalid feature");
		}
		
	}
	
	/**
	 * 
	 */
	public void print(){
		for (int i = 0; i< this.zip_list.size(); i++){
			this.zip_list.get(i).print();
		}
	}
	
	public int getZip(int i){
		return this.zip_list.get(i).getZip();
	}
	
	public int getColl(int i){
		return this.zip_list.get(i).getCollisions();
	}
	public int size() {
		return this.zip_list.size();
	}
	public int getInj(int i) {
		return this.zip_list.get(i).getInj();
	}
}
