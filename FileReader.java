import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class opens the csv file and parses the lines
 * 
 * @author kathrynsutton
 *
 */

public class FileReader {
	static final int ENTRIES = 21;
	public static void main(String[] args) throws FileNotFoundException {
		/*
		//check how many command line arguments
		System.out.printf("There are %d arguments in the command line. \n", args.length);
		
		//Then print all the arguments to the console one per line
		for (int i = 0; i < args.length; i++ ) {
			System.out.println(args[i]);
		}
		*/
		
		//check that file names were provided
		if (args.length < 2) {
			System.err.println("Must provide both input and output filenames");
			System.err.printf("Usage: java FileReader inputFile outputFile\n\n" );
			System.exit(0);
		}
		
		//assign input file object
		java.io.File file = new java.io.File(args[0]);
		
		//check that file exists
		if (!file.exists()){
			System.err.println("input file does not exist");
			System.exit(1);
		}
		
		//check that file can be read
		if (!file.canRead()) {
			System.err.printf("Cannot read from file %s\n.", file.getAbsolutePath());
			System.exit(2);
		}
		
		//assign output file object
		java.io.File file2 = new java.io.File(args[1]);
		
		//check that file exists
		if (!file2.exists()){
			System.err.println("output file does not exist");
			System.exit(1);
		}
		
		//check that file can be read
		if (!file2.canWrite()) {
			System.err.printf("Cannot write to file %s\n.", file2.getAbsolutePath());
			System.exit(2);
		}
		
		//create scanner object for this in file
		Scanner input = new Scanner(file);
		
		//create writer for out file
		PrintWriter tasks = new PrintWriter(file2);
		
		//parse the lines
		boolean correct;
		while (input.hasNextLine()) {
			correct = false;
			String line = input.nextLine(); 
			ArrayList <String> words = parser(line);
			//System.out.println(correct);
			correct = longEnough(words);
			//System.out.println(correct);
			if (correct == true){
				//printArrayList(words);
				write(words, tasks);
			}
		}
		
		System.out.println("Total success!");
		
		//close scanner
		input.close();
		tasks.close();
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
		if (line.size() < ENTRIES){
			correct = false;
		} else {
			for (int i = 0; i < line.size(); i++){
				if(line.get(i).equals("")){
					correct = false;
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
