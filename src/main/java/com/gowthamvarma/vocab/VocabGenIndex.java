package com.gowthamvarma.vocab;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class VocabGenIndex {
	
	static String WORD_LIST_PATH = "D:\\vocabulary\\html5up-lens\\vocabulary\\words.txt";
	
	static String TEMPLATE_PATH = "D:\\vocabulary\\html5up-lens\\vocabulary\\index-template.html";
	
	static String OUTPUT_PATH = "D:\\vocabulary\\html5up-lens\\vocabulary\\index.html";
	
	static List<String> words = new ArrayList<String>();
	
	static List<String> words_a  = new ArrayList<String>();
	static List<String> words_b  = new ArrayList<String>();
	static List<String> words_c  = new ArrayList<String>();
	static List<String> words_d  = new ArrayList<String>();
	static List<String> words_e  = new ArrayList<String>();
	static List<String> words_f  = new ArrayList<String>();
	static List<String> words_g  = new ArrayList<String>();
	static List<String> words_h  = new ArrayList<String>();
	static List<String> words_i  = new ArrayList<String>();
	static List<String> words_j  = new ArrayList<String>();
	static List<String> words_k  = new ArrayList<String>();
	static List<String> words_l  = new ArrayList<String>();
	static List<String> words_m  = new ArrayList<String>();
	static List<String> words_n  = new ArrayList<String>();
	static List<String> words_o  = new ArrayList<String>();
	static List<String> words_p  = new ArrayList<String>();
	static List<String> words_q  = new ArrayList<String>();
	static List<String> words_r  = new ArrayList<String>();
	static List<String> words_s  = new ArrayList<String>();
	static List<String> words_t  = new ArrayList<String>();
	static List<String> words_u  = new ArrayList<String>();
	static List<String> words_v  = new ArrayList<String>();
	static List<String> words_w  = new ArrayList<String>();
	static List<String> words_x  = new ArrayList<String>();
	static List<String> words_y  = new ArrayList<String>();
	static List<String> words_z  = new ArrayList<String>();
	
	static Map<String,String> jsArrayMap = new HashMap<String, String>();
	
	public static void main(String[] args) throws Exception {
		System.out.println(":: Start");
		
		// read words file and create an array list
		fileToList();
		
		System.out.println(words.size());
		
		for (String word : words) {
			if (word.startsWith("a")) {
				words_a.add(word);
			} else if (word.startsWith("b")) {
				words_b.add(word);
			} else if (word.startsWith("c")) {
				words_c.add(word);
			} else if (word.startsWith("d")) {
				words_d.add(word);
			} else if (word.startsWith("e")) {
				words_e.add(word);
			} else if (word.startsWith("f")) {
				words_f.add(word);
			} else if (word.startsWith("g")) {
				words_g.add(word);
			} else if (word.startsWith("h")) {
				words_h.add(word);
			} else if (word.startsWith("i")) {
				words_i.add(word);
			} else if (word.startsWith("j")) {
				words_j.add(word);
			} else if (word.startsWith("k")) {
				words_k.add(word);
			} else if (word.startsWith("l")) {
				words_l.add(word);
			} else if (word.startsWith("m")) {
				words_m.add(word);
			} else if (word.startsWith("n")) {
				words_n.add(word);
			} else if (word.startsWith("o")) {
				words_o.add(word);
			} else if (word.startsWith("p")) {
				words_p.add(word);
			} else if (word.startsWith("q")) {
				words_q.add(word);
			} else if (word.startsWith("r")) {
				words_r.add(word);
			} else if (word.startsWith("s")) {
				words_s.add(word);
			} else if (word.startsWith("t")) {
				words_t.add(word);
			} else if (word.startsWith("u")) {
				words_u.add(word);
			} else if (word.startsWith("v")) {
				words_v.add(word);
			} else if (word.startsWith("w")) {
				words_w.add(word);
			} else if (word.startsWith("x")) {
				words_x.add(word);
			} else if (word.startsWith("y")) {
				words_y.add(word);
			} else if (word.startsWith("z")) {
				words_z.add(word);
			}
		}
		
		jsArrayMap.put("replace_list_a" , createJsonArray(words_a));
		jsArrayMap.put("replace_list_b" , createJsonArray(words_b));
		jsArrayMap.put("replace_list_c" , createJsonArray(words_c));
		jsArrayMap.put("replace_list_d" , createJsonArray(words_d));
		jsArrayMap.put("replace_list_e" , createJsonArray(words_e));
		jsArrayMap.put("replace_list_f" , createJsonArray(words_f));
		jsArrayMap.put("replace_list_g" , createJsonArray(words_g));
		jsArrayMap.put("replace_list_h" , createJsonArray(words_h));
		jsArrayMap.put("replace_list_i" , createJsonArray(words_i));
		jsArrayMap.put("replace_list_j" , createJsonArray(words_j));
		jsArrayMap.put("replace_list_k" , createJsonArray(words_k));
		jsArrayMap.put("replace_list_l" , createJsonArray(words_l));
		jsArrayMap.put("replace_list_m" , createJsonArray(words_m));
		jsArrayMap.put("replace_list_n" , createJsonArray(words_n));
		jsArrayMap.put("replace_list_o" , createJsonArray(words_o));
		jsArrayMap.put("replace_list_p" , createJsonArray(words_p));
		jsArrayMap.put("replace_list_q" , createJsonArray(words_q));
		jsArrayMap.put("replace_list_r" , createJsonArray(words_r));
		jsArrayMap.put("replace_list_s" , createJsonArray(words_s));
		jsArrayMap.put("replace_list_t" , createJsonArray(words_t));
		jsArrayMap.put("replace_list_u" , createJsonArray(words_u));
		jsArrayMap.put("replace_list_v" , createJsonArray(words_v));
		jsArrayMap.put("replace_list_w" , createJsonArray(words_w));
		jsArrayMap.put("replace_list_x" , createJsonArray(words_x));
		jsArrayMap.put("replace_list_y" , createJsonArray(words_y));
		jsArrayMap.put("replace_list_z" , createJsonArray(words_z));
		
		System.out.println("jsArrayMap size :: " + jsArrayMap.size());
  
		// replace words and copy file
		replaceLines(TEMPLATE_PATH, OUTPUT_PATH, jsArrayMap);

		System.out.println(":: End");
	}
	
	private static String createJsonArray(List<String> wordsList) {
		StringBuilder sb = new StringBuilder("[ '");
		sb.append(String.join("' , '", wordsList));
		sb.append("' ];");
		System.out.println(sb.toString());
		return sb.toString();
	}

	public static void replaceLines(String pathFrom, String pathTo, Map<String, String> map) {
	    try {
	        // input the (modified) file content to the StringBuffer "input"
	        BufferedReader file = new BufferedReader(new FileReader(pathFrom));
	        StringBuffer inputBuffer = new StringBuffer();
	        String line;

	        while ((line = file.readLine()) != null) {
	        	
	        	Set<String> keys = map.keySet();
	        	
	        	for (String key : keys) {
	        		line = line.replace(key, map.get(key));
				}
	        	
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

}
