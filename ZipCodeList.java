import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 * this class is meant to organize zipcode objects
 * @author kathrynsutton
 *
 */
public class ZipCodeList {
	
	private ArrayList<ZipCode> zip_list;
	private int feature;
	//public static final int COLL = 2;

	/**
	 * takes a collision list sorted by zipcode and generates a ZipCodeList
	 * @param list a collision list sorted by zipcode
	 */
	ZipCodeList(CollisionList list){
		this.feature = -1;
		//if the collision list has entries
		if (list.size() >0){
			ArrayList<ZipCode> zips = new ArrayList<ZipCode>();
			//add first collision as a zipcode object
			ZipCode a = new ZipCode(list.get(0));
			if (list.size() > 1){
			//for the remaining collisions
			for (int i = 1; i< list.size(); i++){
				Collision b = list.get(i);
				//if it's a new zipcode, make a new zipcode object
				if (b.getZip() != a.getZip()){
					//add new zipcode object to zipcode list
					zips.add(a);
					//start comparing to last new zipcode
					a = new ZipCode(b);
				} else {
					//if same zipcode as current, combine the zipcode data
					a.Collide(b);
				}
			}
			} else {
				//if only one collision, just add that
				zips.add(a);
			}
			//set to zipcode list
			this.zip_list = zips;
		} else {
			System.out.println("need more collisions, there were only : " + list.size());
		}
	}
	
	/**
	 * sets feature if valid, see setFeature() CollisionList
	 * @param f int feature
	 */
	public void setFeature(int f){
		if (Collision.isValidFeature(f)){
			this.feature = f;
			for (int i = 0; i < this.zip_list.size(); i ++){
				this.zip_list.get(i).feature = f;
			}
		}
	}
	
	/**
	 * sorts zip list according to feature
	 */
	public void sort() {
		if (Collision.isValidFeature(this.feature) == true){
			Collections.sort(this.zip_list);
		}
		else{
			System.out.println("invalid feature");
		}
		
	}
	
	/**
	 * prints out all the zipcodes in a zipcodelist
	 */
	public void print(){
		for (int i = 0; i< this.zip_list.size(); i++){
			this.zip_list.get(i).print();
		}
	}
	
	/*
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
	*/
	
	
	/**
	 * runs through the 6 tasks
	 */
	public void runTasks(){
		//task1(tasks);
		//task2(tasks);
		//task3(tasks);
		//task4();
		//task5();
		//task6();
	}

	/*
	private  void task1(ZipCodeList zips, PrintWriter tasks) {
		tasks.println("ZIP Codes with the largest number of collisions");
		int i = 0;
		int top = 3;
		if (zips.size() < top){
			top = zips.size();
		}
		tasks.println(zips.getZip(i) + " : " + zips.getColl(i) + " Collisions");
		top --;
		while (top >0){

			i++;
			if (zips.getColl(i) == zips.getColl(i-1)){
				tasks.println(zips.getZip(i) + " : " + zips.getColl(i) + " Collisions");
			} else {

				tasks.println(zips.getZip(i) + " : " + zips.getColl(i) + " Collisions");
				top --;
			}
		}
	}
	
	private  void task2(ZipCodeList zips, PrintWriter tasks) {
		tasks.println("ZIP Codes with the smallest number of collisions");
		int i = zips.size() -1;
		int top = 3;
		if (zips.size() < top){
			top = zips.size();
		}
		tasks.println(zips.getZip(i) + " : " + zips.getColl(i) + " Collisions");
		top --;
		while (top >0){

			i--;
			if (zips.getColl(i) == zips.getColl(i-1)){
				tasks.println(zips.getZip(i) + " : " + zips.getColl(i) + " Collisions");
			} else {

				tasks.println(zips.getZip(i) + " : " + zips.getColl(i) + " Collisions");
				top --;
			}
		}
	}

	private  void task3(ZipCodeList zips, PrintWriter tasks){
		tasks.println("ZIP Codes with the most injuries and fatalities (combined");
		int i = 0;
		int top = 3;
		//boolean matches = true;
		if (zips.size() < top){
			top = zips.size();
		}
		tasks.println(zips.getZip(i) + " : " + zips.getInj(i) + " injuries and fatalities");
		while (top >= 0){
			
				i++;
				if (zips.getColl(i) == zips.getColl(i-1)){
					tasks.println(zips.getZip(i) + " : " + zips.getInj(i) + " injuries and fatalities");
					tasks.println(top);
				} else {
					tasks.println(zips.getZip(i) + " : " + zips.getInj(i) + " injuries and fatalities");
					
					top --;
					tasks.println(top);
				}
			}
		
		i++;
		tasks.println(zips.getZip(i) + " : " + zips.getInj(i) + " injuries and fatalities");
		i++;
		tasks.println(zips.getZip(i) + " : " + zips.getInj(i) + " injuries and fatalities");
	}
	*/
}
