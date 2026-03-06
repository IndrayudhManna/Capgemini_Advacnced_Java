package aFiles;
import java.io.*;

public class File1 {

	public static void main(String[] args) throws IOException{
		File file = new File("src/aFiles/Test.java");
		System.out.println("File object created");
		
		
		if(file.createNewFile()) {
			System.out.println("File created");
		}else {
			System.out.println("File already exists");
		}
		
		
		FileWriter writer = new FileWriter("src/aFiles/Test.java", true);  //true makes it so that the new text is added, not overridden.
		writer.write("Hello");
		writer.close();
		System.out.println("Writing complete");
		
	}

}

//File - represents a file or folder
//FileWriter - write text to a file
//FileReader - read text from file
//BufferedWriter - fast writing

