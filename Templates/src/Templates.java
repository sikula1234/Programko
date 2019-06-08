import java.util.Scanner;
import java.util.Map;
import java.io.PrintWriter;
import java.util.HashMap;

public class Templates {

	public static void main(String[] args) {
		Map<String, String> variables = new HashMap<String, String>();

		// Scan all arguments and put variable-value pairs into the HashMap
		for (int i = 0; i < args.length; i++) {
			if (args[i].startsWith("--var=")) {
				String varRequestText = args[i].substring(6, args[i].length());
				String varRequest[] = varRequestText.split("=");
				if (varRequest.length == 2) {
					variables.put(varRequest[0], varRequest[1]);
				}
			}
		}
		
		// Get the template file from standard input
		Scanner tplInput = new java.util.Scanner(System.in);
		
		// Redirect the writer to standard output
		PrintWriter output = new PrintWriter(System.out, true);
		
		// Reprint the template, replacing variables
		fillTemplate(tplInput, variables, output);
		
		tplInput.close();
	}

	public static void fillTemplate(Scanner tplInput, Map<String, String> variables, PrintWriter output) {

		// Reprint the text from the template scanner line by line
		while (tplInput.hasNextLine()) {
			String line = tplInput.nextLine();
			String words[] = line.split(" ");

			// Reprint the line word by word
			boolean first = true;
			for (int i = 0; i < words.length; i++) {

				// Add a space in front of the word unless it is the first word on the line
				if (!first) {
					output.print(" ");
				} else {
					first = false;
				}

				// Replace "{{ variable name }}" with specific value using the HashMap
				if (words[i].equals("{{")) {
					i++;

					// Read the whole variable name
					String variableKey = words[i];
					i++;
					while (!words[i].equals("}}")) {
						variableKey = variableKey.concat(" " + words[i]);
						i++;
					}

					// Print specific value if available, otherwise print "???"
					if (variables.containsKey(variableKey)) {
						output.print(variables.get(variableKey));
					} else {
						output.print("???");
					}

				} else {
					// Reprint a word unchanged if it is not a variable name
					output.print(words[i]);
				}

			}
			output.println();
		}

	}

}