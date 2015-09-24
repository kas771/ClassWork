
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * manages objects of collision class 
 *  
 * @author kathrynsutton
 *
 */
public class CollisionList {
	
	private ArrayList<Collision> list;
	
	private int feature; //same options as collision class

	/**
	 * default constructor initializes ArrayList and sets feature to -1
	 */
	CollisionList(){
		list = new ArrayList<Collision>();
		this.feature = -1;
	}
	
	/**
	 * adds collision to collision list and sets feature of all collisions
	 * to same feature as collisionlist
	 * @param c collision to add to collision list
	 */
	public void fill(Collision c){
		this.list.add(c);
		c.setFeature(this.feature);
		
	}
	
	/**
	 * 
	 * @return the feature of the collision list and all its collisions
	 */
	public int getFeature(){
		return this.feature;
	}
	
	/**
	 * if the feature is valid sets the feature of the collision list and all
	 * collisions in the list to that feature
	 * @param a the int feature
	 */
	public void setFeature(int a){
		if (Collision.isValidFeature(a)== true){
			this.feature = a;
			for (int i = 0; i < this.list.size(); i++){
				list.get(i).setFeature(a);
			}
		}
	}
	
	/**
	 * @return the number of elements in the collisionlist
	 */
	public int size(){
		return this.list.size();
	}
	
	/**
	 * returns the collision object for a given index in the collision list
	 * @param index in collision list
	 * @return the collision object at the index, or the collision at 0 if index was invalid
	 */
	public Collision get(int index){
		if (index >= 0 && index < this.size()){
			return this.list.get(index);
		} else {
			return this.list.get(0);
		}
	}
	
	/**
	 * takes an unsorted collision list and sorts the elements by increasing order
	 * for a specific attribute
	 * need to set feature of input list with setFeature()
	 * @return an ArrayList of collisions sorted by feature, or unchanged if invalid feature
	 */
	public void sort() {
		//ArrayList<Collision> list = new ArrayList<Collision>();
		if (Collision.isValidFeature(this.feature)== true){
			Collections.sort(this.list);
		}
		else{
			System.out.println("invalid feature");
		}
		
	}

	/*
	void sorter(int feature){
		int order = -5;
		for (int i = 0; i < this.list.size()-1; i++){
			int j = i+1;
			Collision a = this.list.get(i);
			Collision b = this.list.get(i+1);
			order = a.compareTo(b, feature);
			System.out.println("order: " + order);
			if (order == -1){
				Collections.swap(this.list, i, j);
			}
		}
	}
	*/
	
	/**
	 * prints all the collision in the collision list
	 */
	public void print() {
		for (int i = 0; i < this.list.size(); i++){
			Collision a = this.list.get(i);
			a.print();
		}
		//System.out.println(" flag 7");
	}
	
	/**
	 * writes an ArrayList to the output file
	 * @param list an ArrayList of strings
	 * @param tasks the PrintWriter to the output file
	 */
	public void write(ArrayList<String> list, PrintWriter tasks){
		int length = list.size();
		tasks.println();
		for (int i = 0; i<length-1; i++ ){
			tasks.print(list.get(i) + ", ");
		}
		tasks.print(list.get(length-1));
	}
	
	/**
	 * reads in the input file line by line and populates a CollisionList
	 * with collisions, ignoring lines with empty elements
	 * @param input the scanner from the input file
	 * @return a full CollisionList
	 */
	public CollisionList generateList(Scanner input){
		boolean correct;
		int count = 0;//counter to discard first line
		CollisionList list = new CollisionList();
		while (input.hasNextLine()) {
			count ++;
			correct = false;
			String line = input.nextLine(); 
			ArrayList <String> words = Collision.parser(line);
			//System.out.println(correct);
			correct = Collision.longEnough(words);
			//System.out.println(correct);
			if (correct == true && count > 1){

				//System.out.println("flag 9");
				//printArrayList(words);
				//CollisionList.write(words, tasks);
				//System.out.println(words.get(3));
				Collision c = new Collision(words);
				list.fill(c);
			}
		}
		return list;
	}
	
}
