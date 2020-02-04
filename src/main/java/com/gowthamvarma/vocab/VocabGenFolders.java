package com.gowthamvarma.vocab;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;

public class VocabGenFolders {
	

	static String WIORD_CURR = "$current-word";
	static String WIORD_PREV = "$prev-word";
	static String WIORD_NEXT = "$next-word";
	
	static String WORD_LIST_PATH = "D:\\vocabulary\\html5up-lens\\vocabulary\\words.txt";
	
	static String TEMPLATE_PATH = "D:\\vocabulary\\html5up-lens\\vocabulary\\template.html";
	
	static String OUTPUT_PATH = "D:\\vocabulary\\html5up-lens\\vocabulary\\";
	
	static String INDEX_HTML = "index.html";
	
	static List<String> words = new ArrayList<String>();
	
	public static void main(String[] args) throws Exception {
		System.out.println(":: Start");
		
		// read words file and create an array list
		fileToList();
		
		System.out.println(words.size());
		
		// iterate the array list
		for (int i = 0; i < words.size(); i++) {
			String wordCurr = words.get(i);
			String wordPrev = getPrev(i);
			String wordNext = getNext(i);
			
			/*
			System.out.println("wordCurr :: " + wordCurr );
			System.out.println("wordPrev :: " + wordPrev );
			System.out.println("wordNext :: " + wordNext );
			System.out.println("---");
			*/
			
			String path = OUTPUT_PATH + wordCurr + "\\";
			
			// delete directory for word
			FileUtils.deleteDirectory(new File(path));
			
			// create directory for word
			FileUtils.forceMkdir(new File(path));
			
			// read template line by line and copy to new path
			Map<String, String> map = new HashMap<String, String>();
			
			map.put(WIORD_CURR, wordCurr);
			map.put(WIORD_PREV, wordPrev);
			map.put(WIORD_NEXT, wordNext);
			
			// replace words and copy file
			replaceLines(TEMPLATE_PATH, path + INDEX_HTML, map);
		}

		System.out.println(":: End");
	}
	
	public static void replaceLines(String pathFrom, String pathTo, Map<String, String> map) {
	    try {
	        // input the (modified) file content to the StringBuffer "input"
	        BufferedReader file = new BufferedReader(new FileReader(pathFrom));
	        StringBuffer inputBuffer = new StringBuffer();
	        String line;

	        while ((line = file.readLine()) != null) {
	        	
	            line = line.replace(WIORD_CURR, map.get(WIORD_CURR));
	            line = line.replace(WIORD_PREV, map.get(WIORD_PREV));
	            line = line.replace(WIORD_NEXT, map.get(WIORD_NEXT));
	            		
	            inputBuffer.append(line);
	            inputBuffer.append('\n');
	        }
	        file.close();

	        // write the new string with the replaced line OVER the same file
	        FileOutputStream fileOut = new FileOutputStream(pathTo);
	        fileOut.write(inputBuffer.toString().getBytes());
	        fileOut.close();

	    } catch (Exception e) {
	        System.out.println("Problem reading file.");
	    }
	}

	private static void fileToList() {
		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(WORD_LIST_PATH))) {
			stream.forEach(words::add);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String getNext(int i) {
		if(i == (words.size() - 1) ) {
			i = -1;
		}
		return words.get(i+1);
	}

	private static String getPrev(int i) {
		if(i == 0 ) {
			i = words.size();
		}
		return words.get(i-1);
	}

}
