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
		/*
		//check how many command line arguments
		System.out.printf("There are %d arguments in the command line. \n", args.length);
		
		//Then print all the arguments to the console one per line
		for (int i = 0; i < args.length; i++ ) {
			System.out.println(args[i]);
		}
		*/
		
		//check that file names were provided
		if (args.length < 1) {
			System.err.println("Must provide input filename");
			System.err.printf("Usage: java FileReader inputFile \n\n" );
			System.exit(0);
		}
		
		//assign input file object
		java.io.File file = new java.io.File(args[0]);
		
		System.out.println(" flag 1");
		
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
		
		System.out.println(" flag 2");
		//assign output file object
		String out_name = outFileName(args[0]);
		System.out.println(out_name);
		
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
		System.out.println(" flag 3");
		
		//create scanner object for this in file
		Scanner input = new Scanner(file);
		
		//create writer for out file
		PrintWriter tasks = new PrintWriter(out_name);
		
		
		//parse the lines
		boolean correct;
		Collision c;
		int count = -1;
		CollisionList list = new CollisionList();
		//TODO figure out why doesn't read at all if missing entry in first line
		while (input.hasNextLine()) {
			System.out.println(" flag 4");
			count ++;
			correct = false;
			String line = input.nextLine(); 
			ArrayList <String> words = CollisionList.parser(line);
			//System.out.println(correct);
			correct = CollisionList.longEnough(words);
			//System.out.println(correct);
			if (correct == true && count > 0){
				
				System.out.println("flag 9");
				//printArrayList(words);
				//CollisionList.write(words, tasks);
				//System.out.println(words.get(3));
				c = new Collision(words);
				list.fill(c);
			}
		}
		
		//System.out.println(" flag 5");
		//list.print();
		
		list.setFeature(Collision.ZIP);
		list.sort();
		ZipCodeList zips = new ZipCodeList(list);
		//zips.print();
		zips.setFeature(ZipCodeList.COLL);
		zips.sort();
		//zips.print();
		task1(zips, tasks);
		task2(zips, tasks);
		
		zips.setFeature(Collision.INJ);
		zips.sort();
		task3(zips, tasks);
		//list.print();
		
		//System.out.println(" flag 6");
		
		//tasks.println("tester");
		
		
		System.out.println("I've made a huge mistake");
		
		//close scanner
		input.close();
		tasks.close();
	}
	

	private static void task1(ZipCodeList zips, PrintWriter tasks) {
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
	
	private static void task2(ZipCodeList zips, PrintWriter tasks) {
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

	private static void task3(ZipCodeList zips, PrintWriter tasks){
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
	


	private static String outFileName(String s) {
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
