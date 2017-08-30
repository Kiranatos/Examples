package undefined;

///level25-lesson07-home02

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.concurrent.*;

import java.util.concurrent.Callable;


import java.io.IOException;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;


/* Все не так легко, как кажется
1. Почитать в инете про Socket, ThreadPoolExecutor, RunnableFuture, Callable
2. Реализуйте логику метода cancel в классе SocketTask
3. Реализуйте логику метода cancel для локального класса внутри метода newTask в классе SocketTask
*/
public class SocketCallableRunnableFuture extends ThreadPoolExecutor {    
    
    public SocketCallableRunnableFuture(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        if (callable instanceof CancellableTask) {
            return ((CancellableTask<T>) callable).newTask();
        } else {
            return super.newTaskFor(callable);
        }
    }
    
    
    public static void main(String[] args) throws IOException, InterruptedException {

    final String url[] = {"www.ya.ru", "www.rbc.ru", "www.ixbt.com","www.ru", "www.lenta.ru"}; // Откуда качаем
    // Создаем пул задач (может в параллели выполнять 2 задачи)
    ThreadPoolExecutor pool = new SocketCallableRunnableFuture(2, 2, 2L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
    List<Future<String>> lf = new ArrayList<>(); // Список отложенных задач на выполнение (обертка для демонстрации отмены)

    for (int i = 0; i < url.length; i++) {
        final Socket socketF = new Socket(url[i], 80); // Создаем сокет для общения по http
        final String mainSitePage =  url[i];
        lf.add(pool.submit(
            new SocketTask<String>() { // Собственно отложенная задача для закачки
                @Override
                public String call() throws Exception {
                    setSocket(socketF);
                    String res = "";
                    try(DataOutputStream os1  = new DataOutputStream(socketF.getOutputStream());
                        DataInputStream  is1  = new DataInputStream(socketF.getInputStream()))
                        {
                            System.out.println("start loading from " + mainSitePage);
                            os1.writeBytes("GET http://"   + mainSitePage + "/ HTTP/1.1\r\n"); // Http-запрос
                            os1.writeBytes("Host: http://" + mainSitePage + ":80\r\n\r\n");
                            os1.flush(); // Пошлем его на сервер
                            String responseLine;
                            while ((responseLine = is1.readLine()) != null) // Сформируем ответ от сервера
                                res += responseLine;
                        }
                    System.out.print("got info from " + mainSitePage + ",: "); // Информируем, что задача завершилась
                    System.out.println(res);
                    return res;
                }
            }));
    }
    lf.get(3).cancel(true); // Отменим предпоследнюю задачу (можно поставить точку останова в SocketTask для отладки)
    pool.shutdown();        // По завершению всех задач освободим пул
}
}




interface CancellableTask<T> extends Callable<T> {
    void cancel();

    RunnableFuture<T> newTask();
}


abstract class SocketTask<T> implements CancellableTask<T> {
    private Socket socket;

    protected synchronized void setSocket(Socket socket) {
        this.socket = socket;
    }

    public synchronized void cancel() {
        //close all resources here
        try { socket.close(); }
        catch (IOException ignored) { }
    }

    public RunnableFuture<T> newTask() {
        return new FutureTask<T>(this) {
            public boolean cancel(boolean mayInterruptIfRunning) {
                //close all resources here by using proper SocketTask method
                //call super-class method in finally block
                    try { socket.close(); }
                    catch (IOException ignored) { }
                    finally { super.cancel(mayInterruptIfRunning); }
                    return true;
            }
        };
    }
}
