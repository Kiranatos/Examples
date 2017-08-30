package junit;

public class TestAssert {    
    public static void main(String[] args) {
        /*
        По умолчанию assert-ы отключены в JVM.
        Чтобы их включить в классах:    java -ea TestAssert
                                        java -enableasserions TestAssert
        Выключить:  java -da TestAssert
                    java -disableasserions TestAssert
        Включить для всего package и подпакетов:    java -ea com.kiranatos...
        Включить для всего package, кроме пакета:   java -ea -da:com.kiranatos.test...
        Включить для проекта в IDE: прописать -ea в NetBeans
        "Выполнить->Установить конфигурацию проекта->Настроить->Выполнение->Параметры VM"
        */
        int x = -10;
        assert x>=0 : "Test"; //Выброс исключения AssertionError со значением
        assert x>=0 : x; //Выброс исключения AssertionError со значением
        assert x>=0; //Выброс исключения AssertionError без сообщения
        AssertionError : assert x>=0 : "Моё сообщение x >= 0";
    }    
}

/*                  http://www.javenue.info/post/19
Тестирование Java кода с помощью JUnit
2006-01-02 Туториалы по программированию

Для демонстрации основных возможностей JUnit 4 Framework, напишем класс MathFunc. 
Этот класс будет иметь два метода - нахождение факториала неотрицательного числа и суммы двух чисел. 
Кроме того, в экземпляре класса будет находится счетчик вызовов методов. */
class MathFunc {
    int calls;

    public int getCalls() { return calls; }

    public long factorial(int number) {
        calls++;
        if (number < 0) throw new IllegalArgumentException();

        long result = 1;
        if (number > 1) {
            for (int i = 1; i <= number; i++)
                result = result * i;
        }
        return result;
    }

    public long plus(int num1, int num2) {
        calls++;
        return num1 + num2;
    }
}
/* Теперь напишем Unit тесты. Для этого создадим класс с некоторым количеством 
тестовых методов. Естественно, класс может содержать и обычные вспомогательные 
методы. Чтобы runner тестов мог определить, кто есть кто, тестовые методы 
необходимо помечать аннтоацией @Test.

У аннотации могут быть проставлены такие параметры:
    expected - указываем какое исключение будет сгенерировано методом (см. пример ниже);
    timeout - через какое время в милисекундах прекратить выполнение теста и засчитать его как неуспешный.

Если вы хотите указать, что определенный тест необхдимо пропустить, 
то пометьте его аннотацией @Ignore. Хотя можно просто удалить аннотацию @Test.

Бывает такое, что для выполнения каждого тестового сценария вам необходим 
некоторый контекст, например, заранее созданные экземпляры классов. А после 
выполнения нужно освободить зарезервированные ресурсы. В этом случае вам 
понадобятся аннтоации @Before и @After. Метод, помеченный @Before будет 
выполняться перед КАЖДЫМ тестовым случаем, а метод, помеченный @After - после 
КАЖДОГО тестового случая.

Если же инициализацию и освобождение ресурсов нужно сделать всего ОДИН раз - 
соответственно до и после всех тестов - то используйте пару аннотаций @BeforeClass и @AfterClass.

А вот и сам тестовый класс с несколькими тестовыми сценариями:

public class MathFuncTest {
    private MathFunc math;

    @Before
    public void init() { math = new MathFunc(); }
    @After
    public void tearDown() { math = null; }

    @Test
    public void calls() {
        assertEquals(0, math.getCalls());

        math.factorial(1);
        assertEquals(1, math.getCalls());

        math.factorial(1);
        assertEquals(2, math.getCalls());
    }

    @Test
    public void factorial() {
        assertTrue(math.factorial(0) == 1);
        assertTrue(math.factorial(1) == 1);
        assertTrue(math.factorial(5) == 120);
    }

    @Test(expected = IllegalArgumentException.class)
    public void factorialNegative() {
        math.factorial(-1);
    }

    @Ignore
    @Test
    public void todo() {
        assertTrue(math.plus(1, 1) == 3);
    }
}

Метод calls тестирует правильность счетчика вызовов. Метод factorial проверяет правильность вычисления факториала для некоторых стандартных значений. Метод factorialNegative проверяет, что для отрицательных значений факотриала будет брошен IllegalArgumentException. Метод todo будет проигнорирован. Попробуйте убрать аннотацию @Ignore, когда будете экспериментировать с кодом.

Метод assertTrue проверяет, является ли результат выражения верным. Некоторые другие методы, которые могут пригодиться:

    assertEquals - ожидаемый результат и полученный результат совпадают;
    assertNull - результатом выражения есть null;
    assertNotNull - результат выражения отличен от null;
    assertSame - ожидаемый и полученный объекты это один и тот же объект.
    fail - метод генерирует исключение AssertionError - добавляем туда, куда не должен дойти ход выполнения программы.

В нашем современном мире IDE умеют находить и просто запускать тесты в проекте. Но что делать, если вы хотите запустить их вручную с помощью программного кода. Для этого можно воспользоваться Runner'ом. Бывают текстовый - junit.textui.TestRunner, графические версии - junit.swingui.TestRunner, junit.awtui.TestRunner.

Но чуть более современный метод - это использование класса JUnitCore. Добавьте следующий метод main в класс MathFuncTest:

    public static void main(String[] args) throws Exception {
        JUnitCore runner = new JUnitCore();
        Result result = runner.run(MathFuncTest.class);
        System.out.println("run tests: " + result.getRunCount());
        System.out.println("failed tests: " + result.getFailureCount());
        System.out.println("ignored tests: " + result.getIgnoreCount());
        System.out.println("success: " + result.wasSuccessful());
    }

И результат выполнения:

    run tests: 3
    failed tests: 0
    ignored tests: 1
    success: true

В более ранних версиях JUnit для написания тестового класса нужно было создать наследника junit.framework.TestCase. Затем необходимо было определить конструктор, принимающий в качестве параметра String - название метода - и передать его родительскому классу. Каждый тестовый метод обязан был начинаться с префикса test. Для инициализации и освобождения ресурсов использовались методы setUp и tearDown. Короче ужас. Ну а сейчас все просто, да.

Вот и все на сегодня. Уверен, JUnit Framework во многом поможет вам. Комментарии и вопросы по поводу статьи приветствуются.

*/
