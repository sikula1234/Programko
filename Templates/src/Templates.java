import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Templates {

	public static void main(String[] args) {
		Map<String, String> variables = new HashMap<String, String>();

		// Scan all arguments and put variable-data pairs into the HashMap
		for (int i = 0; i < args.length; i++) {
			if (args[i].startsWith("--var=")) {
				String varRequestText = args[i].substring(6, args[i].length());
				String varRequest[] = varRequestText.split("=");
				if (varRequest.length == 2) {
					variables.put(varRequest[0], varRequest[1]);
				}
			}
		}

		// Reprint the text line by line
		Scanner input = new java.util.Scanner(System.in);
		while (input.hasNextLine()) {
			String line = input.nextLine();
			String words[] = line.split(" ");

			// Reprint the line word by word
			boolean first = true;
			for (int i = 0; i < words.length; i++) {

				// Add a space in front of the word unless it is the first word on the line
				if (!first) {
					System.out.print(" ");
				} else {
					first = false;
				}

				// Replace "{{ variable name }}" with specific data using the HashMap
				if (words[i].equals("{{")) {
					i++;

					// Read the whole variable name
					String variableKey = words[i];
					i++;
					while (!words[i].equals("}}")) {
						variableKey = variableKey.concat(" " + words[i]);
						i++;
					}

					// Print specific data if available, otherwise print "???"
					if (variables.containsKey(variableKey)) {
						System.out.print(variables.get(variableKey));
					} else {
						System.out.print("???");
					}

				} else {
					// Reprint a word unchanged if it is not a variable name
					System.out.print(words[i]);
				}
				
			}
			System.out.println();

		}

		input.close();

	}
}