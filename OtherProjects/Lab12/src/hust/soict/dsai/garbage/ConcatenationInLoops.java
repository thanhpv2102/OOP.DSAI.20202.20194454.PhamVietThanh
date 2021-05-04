package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConcatenationInLoops {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		GarbageCreator string = new GarbageCreator();
		NoGarbage stringBuilder =  new  NoGarbage();
		
		//random arguments to call main method of 2 classes
		String[] arguments = new String[] {"123"};
		string.main(arguments);
		
		
		//PLEASE CHANGE THE FILENAME BELOW AND THE FILENAME IN 2 CLASSES TO YOUR DIRECTORY, THE FILE NOTEPAD.EXE IS ALREADY INCLUDED IN THE PROJECT
		String filename = "C:\\Users\\ADMIN\\Documents\\GitHub\\OOP.DSAI.20202.20194454.PhamVietThanh\\OtherProjects\\src\\hust\\soict\\dsai\\garbage\\notepad.exe";
		byte[] inputBytes = {0};
		long startTime, endTime;
		
		inputBytes = Files.readAllBytes(Paths.get(filename));
		startTime = System.currentTimeMillis();
		StringBuffer outputStringBuffer = new StringBuffer();
		for (byte b: inputBytes) {
			outputStringBuffer.append((char) b);
		}
		endTime = System.currentTimeMillis();
		System.out.println("Runtime of StringBuffer: " + (endTime - startTime));
		
		stringBuilder.main(arguments);
	}

}
