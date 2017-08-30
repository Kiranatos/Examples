package junit;

//import net.kiranatos.testmaven.Main;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

/* если бы был статический импорт import static org.junit.Assert.*;
то assertEquals - можно было бы писать без названия класса Assert. */


public class MainTest {
    @Test /* <- любой тест, начинается с аннотации "Test"
    
    конвенция названия методов теста, должна иметь вид: "shouldНазвание"    
    */
    public void shouldAdd() {
        Assert.assertEquals(5, Main.add(2,3));  // 2+3 = 5
    }
    
    /*************************************************************************************/
    
    @Test
    public void testAdd() {
        double res = Main.add(3,7);
        if (res != 10 ) Assert.fail();  // тест сфейлился
        Assert.assertTrue( res == 10);  // 
        Assert.assertFalse( res == 10); // 
        Assert.assertNull( res );       // 
        Assert.assertNotNull( res );    //
    }
    
    /*************************************************************************************/
    
    @Ignore  //тест будет проигнорирован
    @Test
    public void testIgnore() { }
    
    /*************************************************************************************/
    
    @Test(expected = ArrayIndexOutOfBoundsException.class) /* тестирование возможного выброса исключения */
    public void shouldThrowException1() {
        Main.get(11);  // сделать так, чтобы выбросило исключение
    }    
    
    /* Второй вариант указания исключения: */    
    @Rule
    public final ExpectedException exp = ExpectedException.none();
    //писать не нужно: @Test(expected = ArrayIndexOutOfBoundsException.class)
    @Test
    public void shouldThrowException2() {
        exp.expect(ArrayIndexOutOfBoundsException.class);
        Main.get(11);  
    }
    
    /*************************************************************************************/
    
    /*Первый способ указания времени, дляконкретного теста:*/
    @Test(timeout = 1000) /* 1000ms = 1s  Если тест работает дольше указанного времени, то тест не пройден */
    public void testN() { while(true) {} }
    
    /*Другой способ указать ограниченное время для всех тестов: */
    @Rule
    public Timeout time = new Timeout(1000);
    
    /*************************************************************************************/
        
    //методы с аннотацией @Before будут выполнятся перед каждым методом с @Test
    @Before
    public void runT1() {}
    //методы с аннотацией @BeforeClass выполятся один раз перед выполнением методом с @Test
    @BeforeClass
    public static void runT2() {}
    /*
    @After - соответсвенно после каждого
    @AfterClass - соответсвенно один раз после всех
    @AfterClass, @BeforeClass - должны быть статические!!!
     */
}
