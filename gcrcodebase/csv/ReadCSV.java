package week05.gcrcodebase.csv;

import java.io.BufferedReader;
import java.io.FileReader;

class ReadCSV {
	public static void main(String[] args) {
		String filePath="src\\student.csv";
		String line;
		
		try (BufferedReader br=new BufferedReader(new FileReader(filePath))){
			
			br.readLine();
			System.out.println("Students Records: \n");
			
			while((line=br.readLine())!=null) {
				String[] data = line.split(",");
				System.out.println("ID    : " + data[0]);
                System.out.println("Name  : " + data[1]);
                System.out.println("Age   : " + data[2]);
                System.out.println("Marks : " + data[3]);
                System.out.println("..........................");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
