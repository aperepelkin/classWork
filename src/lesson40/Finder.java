package lesson40;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.io.StringBufferInputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Finder {
	
	static class SearchWorker implements Runnable {

		List<Integer> positions = new ArrayList<>();
		
		private Integer number;
		private String line;
		private String word;
		
		public SearchWorker(Integer number, String line, String word) {
			this.number = number;
			this.line = line;
			this.word = word;
		}

		@Override
		public void run() {
			String[] words = line.split(" ");
			for(int i = 0; i < words.length; i++) {
				if(words[i].equals(word))
					positions.add(i);
			}
		}
		
		public boolean matched() {
			return !positions.isEmpty();
		}
	}
	
	static class SearchWorker2 implements Runnable {
		
		private byte[] buffer;
		private String word;
		Map<Integer, List<Integer>> enters = new HashMap<>();
		
		public SearchWorker2(byte[] buffer, String word) {
			this.buffer = buffer; 
			this.word = word;
		}
		
		@Override
		public void run() {
			StringReader sr = 
					new StringReader(new String(buffer));
			LineNumberReader reader = new LineNumberReader(sr);

			String line = null;
			
			try {
				while((line = reader.readLine()) != null) {
					int number = reader.getLineNumber();
					List<Integer> finds = find(line, word);
					if(finds.size() != 0)
						enters.put(number, finds);
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Путь к файлу");
		String fileName = sc.nextLine();
		System.out.println("Слово");
		String word = sc.nextLine();
		long startTime = System.nanoTime();
		
		FileInputStream fin = new FileInputStream(fileName);
		
		String line = null;
		int size = fin.available();
		int threadSize = size / 4;
		
		List<SearchWorker2> workers = new ArrayList<>();
		for(int i = 0; i < 4; i++) {
			byte[] text = new byte[threadSize];
			fin.read(text);
			SearchWorker2 worker = new SearchWorker2(text, word);
			workers.add(worker);
			new Thread(worker).start();
		}
		
		System.out.println("Duration: " + (System.nanoTime() - startTime));
	}
	
	private static List<Integer> find(String line, String word) {
		List<Integer> positions = new ArrayList<>();
		String[] words = line.split(" ");
		for(int i = 0; i < words.length; i++) {
			if(words[i].equals(word))
				positions.add(i);
		}
		return positions;
	}
}
