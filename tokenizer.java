package dosya;


import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;



public class tokenizer {
      public static void main(String[] args) throws IOException {
    	  
    	  Scanner input=new Scanner(System.in);
    	  System.out.println("Lütfen dosyanıxın adını giriniz");
    	  String name=input.nextLine();
    	  
    	  File dosya=new File(name);
    	  if(!dosya.exists()) {
    		  dosya.createNewFile() ;
    		  
    	  }
    	  
    	  
    	  FileReader fReader=new FileReader(dosya);
    	  BufferedReader bReader=new BufferedReader(fReader);
    	  String satır;
    	  String[] CS;
    	  
			
		while((satır=bReader.readLine())!=null) {
			
			CS=satır.split(" || , || \n");
			for(int i=0;i<CS.length;i++) {
				if(!CS[i].isEmpty() && !CS[i].equals(",")&& !CS[i].equals("\n")&& !CS[i].equals(" ")) {
					System.out.println(CS[i]);
				}
			}
		}
		bReader.close();
      
      }
	
}
