import metier.calcul;
import org.junit.Assert;
import org.junit.Test;

public class CalculTest {
    private metier.calcul calcul ;
    @Test
    public void testSomme(){
        calcul= new calcul();
        double a=5 ,b=9;
        double expected =14 ;
        double res = calcul.somme(a,b);
        Assert.assertTrue(res==expected);
    }
}
