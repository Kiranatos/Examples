package undefined;

public class Test implements Thread.UncaughtExceptionHandler
{
    @Override
    public void uncaughtException(Thread t, Throwable e)
    {
        System.out.println(t.getName());
        String stars = t.getName().replaceAll(".", "*");
        System.out.println(stars);
        String newMessage = e.getMessage().replace(t.getName(), stars);
        System.out.println(e.getMessage());
        System.out.println(t.getName());
        e = new Exception(newMessage, e);
        System.out.println(e.getMessage());
        t.setName(stars);
    }

    public static void main(String args[])
    {
        Test test = new Test();
        Thread myThread = new Thread("thread-02");
        test.uncaughtException(myThread, new Exception("Blah " + myThread.getName() + " blah-blah-blah", new NullPointerException()));
    }
}
