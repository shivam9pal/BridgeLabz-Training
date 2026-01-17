package week03.gcrcodebase.binarystrinbuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class CountWOrd {

	public static void main(String[] args) {
		String file="source.txt";
		String target="java";
		int count=0;
		
		try {
			FileReader fileReader=new FileReader(file);
			BufferedReader br=new BufferedReader(fileReader);
			
			String line;
			
			while((line=br.readLine())!=null) {
				System.out.println(line);
				
				String[] wordStrings=line.split(" ");
				for(String w:wordStrings) {
					if(w.equalsIgnoreCase(target)) {
						count++;
					}
				}
			}
			
			 System.out.println("The word \"" + target + "\" appears " + count + " times.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
