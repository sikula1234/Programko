import java.io.File;
 
public class Stromecek {
    public static void main(String[] args) {
        printFiles(new File("."), "");
    }
 
    private static void printFiles(File dir, String indent) {
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length - 1; i++) {
        	File f = files[i];
            System.out.printf("%s|-- %s\n", indent, f.getName());
            if (f.isDirectory()) {
                printFiles(f, indent + "|     ");
            }
        }
        File g = files[files.length - 1];
        System.out.printf("%s`-- %s\n", indent, g.getName());
        if (g.isDirectory()) {
            printFiles(g, indent + "      ");
        }
    }
}