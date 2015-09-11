import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class opens the csv file 
 * 
 * @author kathrynsutton
 *
 */
public class FileReader {
	public static void main(String[] args) throws Exception {
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
		
		//create scanner object for this file
		Scanner input = new Scanner(file);
		
		
		System.out.println("Success!");
		
		//close scanner
		input.close();

	}

}
