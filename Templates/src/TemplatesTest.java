import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
 
public class TemplatesTest {
    
    @Test
    public void oneLine() {
        assertEquals("Jmeno: Pepa",
        	Templates.replaceVariables("Jmeno: {{ jmeno }}",
        	new HashMap<String, String>(Map.of("jmeno", "Pepa"))));
    }
    
    @Test
    public void twoLines() {
        assertEquals("Jmeno: Pepa \n Rok narozeni: 1968",
        	Templates.replaceVariables("Jmeno: {{ jmeno }} \n Rok narozeni: {{ rok }}",
        	new HashMap<String, String>(Map.of("jmeno", "Pepa", "rok", "1968"))));
    }
    
    @Test
    public void variableAtBeginningOfLine() {
        assertEquals("Pepa papa papaju.",
        	Templates.replaceVariables("{{ jmeno }} papa papaju.",
        	new HashMap<String, String>(Map.of("jmeno", "Pepa"))));
    }
    
    @Test
    public void moreWordsInValue() {
        assertEquals("Jmeno: Pepa Novaku",
        	Templates.replaceVariables("Jmeno: {{ jmeno }}",
        	new HashMap<String, String>(Map.of("jmeno", "Pepa Novaku"))));
    }
    
    @Test
    public void moreWordsInKey() {
        assertEquals("Jmeno: Pepa",
        	Templates.replaceVariables("Jmeno: {{ krestni jmeno }}",
        	new HashMap<String, String>(Map.of("krestni jmeno", "Pepa"))));
    }
    
    @Test
    public void argsToHashMapTest() {
        assertEquals(new HashMap<String, String>(Map.of("ovoce", "cerveny rybiz", "listova zelenina", "spenat")),
        	Templates.argsToHashMap(new String[]{"--var=ovoce=cerveny rybiz", "--var=listova zelenina=spenat",
        	"--var=lets=try=to=break=this"}));
    }
    
}