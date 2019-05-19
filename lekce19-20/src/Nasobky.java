import java.io.IOException;
import java.io.PrintWriter;
 
public class Nasobky {
    public static void main(String[] args) throws IOException {
        PrintWriter writer = new PrintWriter("nasobky.txt");
        int i = 3;
        while (i < 1000) {
        	for (int j = 1; j <= 10; j++) {
        		if (i <= 1000) {
        			writer.printf("%d, ", i);
        		} else {
        			break;
        		}
        		i += 3;
        	}
        	writer.println();
        }
        writer.println();
        writer.close();
    }
}