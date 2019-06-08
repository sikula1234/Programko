import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CsvTemplates {
	public static void main(String[] args) throws IOException {
		String tplFileName = "template.tpl";
		Scanner tplInput = null;
		Scanner csvInput = null;
		Map<String, String> variables = new HashMap<String, String>();
		String outputFileNameRequest = "templater-out-%05d.txt";
		PrintWriter outputWriter = null;

		// Scan all arguments
		for (int i = 0; i < args.length; i++) {
			// Remember the template file name
			if (args[i].startsWith("--template=")) {
				tplFileName = args[i].substring(11, args[i].length());
			}
			// Assign the requested CSV file to the "csvInput" scanner
			if (args[i].startsWith("--csv=")) {
				String csvFileName = args[i].substring(6, args[i].length());
				csvInput = new java.util.Scanner(new FileReader(csvFileName));
			}
			// Remember how output files should be named
			if (args[i].startsWith("--out=")) {
				outputFileNameRequest = args[i].substring(6, args[i].length());
			}
		}
		
		// If no CSV file was specified in arguments, take it from standard input
		if (csvInput == null) {
			csvInput = new java.util.Scanner(System.in);
		}
		
		// Save the variable keys from the first line of the CSV file
		String line = csvInput.nextLine();
		String keys[] = line.split(",");
		
		// For every line in the CSV file, read the varibale values,
		// fill the template accordingly and save as a new file
		int iterationNumber = 0;
		while (csvInput.hasNextLine()) {
			iterationNumber++;
			
			// Save the new variable values
			line = csvInput.nextLine();
			String values[] = line.split(",");
			
			// Put variable-value pairs into the HashMap
			for(int i = 0; i < keys.length; i++) {
				variables.put(keys[i], values[i]);
			}
			
			// Initialize or restart (if not first iteration) the template scanner
			tplInput = new java.util.Scanner(new FileReader(tplFileName));
			
			// Name the file accordingly and initialize the writer
			String outputFileName = String.format(outputFileNameRequest, iterationNumber);
			outputWriter = new PrintWriter(outputFileName);
			
			// Reprint the template, replacing variables
			Templates.fillTemplate(tplInput, variables, outputWriter);
			
			outputWriter.close();
		}
		
		tplInput.close();
		csvInput.close();

	}
}
