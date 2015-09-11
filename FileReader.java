import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class opens the csv file and parses the lines
 * 
 * @author kathrynsutton
 *
 */
public class FileReader {
	public static void main(String[] args) throws FileNotFoundException {
		/*
		//check how many command line arguments
		System.out.printf("There are %d arguments in the command line. \n", args.length);
		
		//Then print all the arguments to the console one per line
		for (int i = 0; i < args.length; i++ ) {
			System.out.println(args[i]);
		}
		*/
		
		//check that file was provided
		if (args.length < 1) {
			System.err.println("Must provide filename");
			System.exit(0);
		}
		
		//assign file object
		java.io.File file = new java.io.File(args[0]);
		
		//check that file exists
		if (!file.exists()){
			System.err.println("File does not exist");
			System.exit(1);
		}
		
		//check that file can be read
		if (!file.canRead()) {
			System.err.printf("Cannot read from file %s\n.", file.getAbsolutePath());
			System.exit(2);
		}
		
		//create scanner object for this file
		Scanner input = new Scanner(file);
		
		//parse the lines
		while (input.hasNextLine()) {
			String line = input.nextLine(); 
			ArrayList <String> words = parser(line ) ;
		}
		
		System.out.println("Success!");
		
		//close scanner
		input.close();
	}
	
	/**
	 *Parses a line of text from a csv file and stores the information in
	 *an ArrayList
	 *
	 * @param line a string of text from csv file
	 * @return an ArrayList of strings of the entries in that line
	 */
	static ArrayList<String> parser(String line){
		ArrayList<String> entries = new ArrayList<String>();
		return entries;
	}

}
