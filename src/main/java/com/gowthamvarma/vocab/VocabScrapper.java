package com.gowthamvarma.vocab;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Set;
import java.util.TreeSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class VocabScrapper {

	public static void main(String[] args) throws Exception {
		System.out.println("Start");

		VocabScrapper vocab = new VocabScrapper();
		
		for (int i = 1; i < 94; i++) {
			System.out.println(i);
			String resp = vocab.sendGet("" + i);
			vocab.parse(resp);
		}
		
		System.out.println("done");
	}
	
	private final String USER_AGENT = "Mozilla/5.0";
	
	// HTTP GET request
	public String sendGet(String catalogue) throws Exception {
		
		String url = "https://www.memrise.com/course/1038938/barrons-3800-gre-words-with-sentences-2/" + catalogue;

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// return result
		return response.toString();

	}
	
	public void parse(String html) throws IOException {
		
		Set<String> set = new TreeSet<String>();
		
		Document doc = Jsoup.parse(html);
		
		Elements content = doc.getElementsByTag("div");
		for (Element element : content) {
			//String movie = element.text();
			//String url = element.attr("div#text");
			try {
				String word = element.getElementsByClass("col_a").get(0).getElementsByClass("text").text();
				set.add(word.split(" ")[0]);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
		StringBuilder out = new StringBuilder();
		
		for (String element : set) {
			out.append(element);
			out.append("\n");
		}
		
	    FileWriter fileWriter = new FileWriter("C:\\Users\\Gowtham\\Desktop\\out.txt", true); //Set true for append mode
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    printWriter.println(out.toString());  //New line
	    printWriter.close();
		
	}

}
