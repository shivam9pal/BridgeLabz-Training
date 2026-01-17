package week03.gcrcodebase.binarystrinbuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class ReadFileUsingFileReader {

	public static void main(String[] args) {
		String file="source.txt";
		
		try {
			FileReader fileReader=new FileReader(file);
			BufferedReader br=new BufferedReader(fileReader);
			
			String line;
			
			while((line=br.readLine())!=null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
