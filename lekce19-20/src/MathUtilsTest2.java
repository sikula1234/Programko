import static org.junit.Assert.*;
 
import org.junit.Test;
 
public class MathUtilsTest2 {
 
    @Test
    public void easy() {
        assertEquals(3, MathUtils.gcd(6,9));
    }
 
    @Test
    public void oneOfTheNumbersIsTheGcd() {
        assertEquals(10, MathUtils.gcd(10, 20));
    }
 
    @Test
    public void havingOne() {
        assertEquals(1, MathUtils.gcd(1, 8));
    }
 
    @Test
    public void oneNegative() {
        assertEquals(9, MathUtils.gcd(-9, 18));
    }
    
    @Test
    public void twoNegatives() {
        assertEquals(9, MathUtils.gcd(-9, -18));
    }
}