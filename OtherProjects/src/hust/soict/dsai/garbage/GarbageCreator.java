package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filename = "C:\\Users\\ADMIN\\Documents\\GitHub\\OOP.DSAI.20202.20194454.PhamVietThanh\\OtherProjects\\src\\hust\\soict\\dsai\\garbage\\notepad.exe";
		byte[] inputBytes = {0};
		long startTime, endTime;

		inputBytes = Files.readAllBytes(Paths.get(filename));
		startTime = System.currentTimeMillis();
		String outputString = "";
		for (byte b: inputBytes) {
			outputString += (char) b;
		}
		endTime = System.currentTimeMillis();
		System.out.println("Runtime of String: " + (endTime - startTime));
	}

}
