import java.util.ArrayList;

/**
 * this class is meant to organize zipcode objects
 * @author kathrynsutton
 *
 */
public class ZipCodeList {
	
	ArrayList<ZipCode> zip_list;

	/*
	 * requires collision list sorted by zipcode
	 */
	ZipCodeList(CollisionList list){
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
	
	/**
	 * 
	 */
	public void print(){
		for (int i = 0; i< this.zip_list.size(); i++){
			this.zip_list.get(i).print();
		}
	}
}
