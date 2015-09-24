import java.io.FileNotFoundException;

import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class opens the csv file and parses the lines, 
 * 
 * @author kathrynsutton
 *
 */

public class CollisionInfo {
	public static final int ENTRIES = 21;
	public static void main(String[] args) throws FileNotFoundException {
		CollisionInfo CI = new CollisionInfo();
		/*
		//check how many command line arguments
		System.out.printf("There are %d arguments in the command line. \n", args.length);
		
		//Then print all the arguments to the console one per line
		for (int i = 0; i < args.length; i++ ) {
			System.out.println(args[i]);
		}
		*/
		
		//check that file names were provided
		CI.checkArgs(args);
		
		java.io.File file = CI.readFile(args);
		
		//System.out.println(" flag 2");
		//assign output file object
		String out_name = CI.outFileName(args[0]);
		//System.out.println(out_name);
		
		/*
		java.io.File file2 = new java.io.File(out_name);
		
		//check that file exists
		if (!file2.exists()){
			System.err.println("output file does not exist");
			System.exit(0);
		}
		
		//check that file can be read
		if (!file2.canWrite()) {
			System.err.printf("Cannot write to file %s\n.", file2.getAbsolutePath());
			System.exit(0);
		}
		*/
		//System.out.println(" flag 3");
		
		//create scanner object for this in file
		Scanner input = new Scanner(file);
		
		//create writer for out file
		//TODO make sure there won't be exceptions here
		PrintWriter tasks = new PrintWriter(out_name);
	
		//parse the lines
		CollisionList CL = new CollisionList();
		CL = CL.generateList(input);
		ZipCodeList ZCL = new ZipCodeList(CL);
		ZCL.runTasks();
		//System.out.println(" flag 5");
		//list.print();
		

		//list.print();
		
		//System.out.println(" flag 6");
		
		//tasks.println("tester");
		
		
		System.out.println("I've made a huge mistake");
		
		//close scanner
		input.close();
		tasks.close();
	}


	/**
	 * checks that an input file was provided
	 * @param args the input to the program
	 */
	private void checkArgs(String[] args) {
		if (args.length < 1) {
			System.err.println("Must provide input filename");
			System.err.printf("Usage: java FileReader inputFile \n\n" );
			System.exit(0);
		}
	}


	/**
	 * checks that the input file exists and can be read
	 * @param args the input arguments
	 * @return the input file
	 */
	private java.io.File readFile(String[] args) {
		//assign input file object
		java.io.File file = new java.io.File(args[0]);
		
		//System.out.println(" flag 1");
		
		//check that file exists
		if (!file.exists()){
			System.err.println("input file does not exist");
			System.exit(0);
		}
		
		//check that file can be read
		if (!file.canRead()) {
			System.err.printf("Cannot read from file %s\n.", file.getAbsolutePath());
			System.exit(0);
		}
		return file;
	}
	
	/**
	 * generates an output file name from the input file
	 * @param the input file name as a string
	 * @return the output file name as a string
	 */
	private String outFileName(String s) {
		String outFile= null;
		if (s.contains(".") == true){
			int dot = s.lastIndexOf(".", s.length());
			//if name has .csv or other extension
			if (dot < s.length()-1){
				outFile = s.substring(0,dot) + ".out";
			}
			if (dot == s.length()-1){
				outFile = s + "out";
			}
		} else {
			outFile = s + ".out";
		}
		
		return outFile;
	}
	
	
	

}
