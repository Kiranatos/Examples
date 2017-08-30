package loggin;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

//FINEST, FINER, FINE, CONFIG, INFO, WARNING, SEVERE, а так же ALL и OFF, включающий и отключающий все уровни соответственно.

public class LogDemo {
    /*важно чтобы во всех Ваших классах переменная логера называлась одинаково.
    можно использовать и пропиывая полный путь к классу "com.dataart.SomeClass", 
    но тот что ниже защищает от сюрпризов при рефакторинге имени/пакета класса.
    */
    private static final Logger LOGGER = Logger.getLogger(LogDemo.class.getName());
    
    public static void main(String[] args) {
        String[] s = {"hhg","ghhg"};
        LOGGER.log(Level.SEVERE, "Start with arguments: {0} {0}", s);
        
        LOGGER.setLevel(Level.CONFIG);
        LOGGER.finest("Some message FINEST");
        LOGGER.fine("Some message FINE");
        LOGGER.config("Some message CONFIG");
        LOGGER.info("Some message INFO");
        LOGGER.warning("Some message WARNING");
        LOGGER.severe("Some message SEVERE");
        
        LOGGER.log(Level.FINE, "Start with arguments: {1}", Arrays.toString(args));
        
        try {
            randomFailingAlgorithm();
        } catch (IllegalStateException e) {
            LOGGER.log(Level.SEVERE, "Exception caught", e); //Если логировать только e.toString(), то потом Вы не сможете понять в какой строке изначально сработало исключение.
            System.exit(2);
        }
        
        /*
	          Иногда вывод лог сообщений требует достаточно больших ресурсов (например
	          дамп какого-то пакета данных и т.п.).
	          В таких случаях стоит проверить выведется ли в лог сообщение для этого уровня
	          логирования
	        */
	        if (LOGGER.isLoggable(Level.FINE)) {
	            LOGGER.fine("Some CPU consuming message: " /*+ prepareCPUConsumingLogMessage()*/);
	        }
    }
    
    private static void randomFailingAlgorithm() {
        double randomNumber = Math.random();
        LOGGER.log(Level.FINE, "Generated Random Number: {0}", randomNumber);
        if (randomNumber < 0.5) {
           // throw new IllegalStateException("Invalid phase of the Moon");
        }
    }    
}
