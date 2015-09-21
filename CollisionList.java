import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 * manages objects of collision class
 *  
 * @author kathrynsutton
 *
 */
public class CollisionList {
//	private final int zip = 0;
//	private final int inj =1;
//	private final int cyc_inj =2;
	
	private ArrayList<Collision> list;
	private int feature; //valid options are 3, 8, 12 (See Collision class)

	CollisionList(){
		list = new ArrayList<Collision>();
		this.feature = -1;
	}
	
	public void fill(Collision c){
		this.list.add(c);
		c.feature = this.feature;
		
	}
	
	
	int getFeature(){
		return this.feature;
	}
	
	void setFeature(int f){
		this.feature = f;
		for (int i = 0; i < this.list.size(); i++){
			list.get(i).setFeature(f);
		}
	}
	
	public int size(){
		return this.list.size();
	}
	
	public Collision get(int index){
		return this.list.get(index);
	}
	
	/**
	 * takes an unsorted ArrayList of collisions and sorts them by decreasing order
	 * for a specific attribute
	 * @param feature the attribute to sort by
	 * @param unsorted the input ArrayList
	 * @return an ArrayList of collisions sorted by feature
	 */
	public void sort() {
		//ArrayList<Collision> list = new ArrayList<Collision>();
		if (this.feature == Collision.ZIP || this.feature == Collision.INJ || 
		this.feature == Collision.CYC_INJ){
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
	
	public void print() {
		for (int i = 0; i < this.list.size(); i++){
			Collision a = this.list.get(i);
			a.print();
		}
		System.out.println(" flag 7");
	}
	
	/**
	 * 
	 */
	static void write(ArrayList<String> list, PrintWriter tasks){
		int length = list.size();
		tasks.println();
		for (int i = 0; i<length-1; i++ ){
			tasks.print(list.get(i) + ", ");
		}
		tasks.print(list.get(length-1));
	}
	
	/**
	 * returns true if all entries in the arraylist are full and there are enough entries
	 * @param line
	 * @return true if to be included
	 */
	static boolean longEnough(ArrayList<String> line){
		boolean correct = true;
		//System.out.println(correct);
		if (line.size() < FileReader.ENTRIES){
			correct = false;
			System.out.println("not enough entries");
		} else {
			for (int i = 0; i < line.size(); i++){
				if(line.get(i).equals("")){
					correct = false;
					System.out.println("blank entry at : " + i);
				}
			}
		}
		//System.out.println(correct);
		return correct;
	}
	
	/**
	 *Parses a line of text from a csv file and stores the information in
	 *an ArrayList
	 *
	 *take from StringParsing.java
	 *
	 * @param line a string of text from csv file
	 * @return an ArrayList of strings of the entries in that line
	 */
	static ArrayList<String> parser(String line){
		ArrayList<String> entries = new ArrayList<String>();
		int lineLength = line.length();
		StringBuffer nextWord = new StringBuffer(); 
		char nextChar;
		boolean insideQuotes = false;
		
		for(int i = 0; i < lineLength; i++ ) {
			nextChar = line.charAt(i); 
			//add character to the current entry 
			if ( nextChar != ',' && nextChar != '"' ) {
				nextWord.append( nextChar );
			}
			//double quote found, decide if it is opening or closing one
			else if (nextChar == '"' ) {
				if ( insideQuotes ) {
					insideQuotes = false;
				}
				else {
					insideQuotes = true;
				}
			}
			//found comma inside double quotes, just add it to the string
			else if (nextChar == ',' && insideQuotes) {
				nextWord.append( nextChar );
			}
			//end of the current entry reached, add it to the list of entries
			//and reset the nextWord to empty string
			else if (nextChar == ',' && !insideQuotes) {
				//trim the white space before adding to the list
				entries.add( nextWord.toString().trim() );
				
				nextWord = new StringBuffer();
			}
			
			else {
				System.err.println("This should never be printed.\n");
			}
		}
		//add the last word
		//trim the white space before adding to the list
		entries.add( nextWord.toString().trim() );
		
		//System.out.println("Nailed it!");
		return entries;
	}
	
	/**
	 * prints all the entries in an arraylist of strings
	 * @param list the array list to be printed
	 */
	static void printArrayList(ArrayList<String> list){
		int length = list.size();

		System.out.println();
		for (int i = 0; i<length-1; i++ ){
			System.out.print(list.get(i) + ", ");
		}
		System.out.print(list.get(length-1));
		
	}


}
