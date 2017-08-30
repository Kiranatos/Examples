package loggin;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class LogApp {
	public static void main(String[] args) {
            Logger.getGlobal().info("Test");
            Logger.getGlobal().setLevel(Level.OFF);
            
		Logger logger = Logger.getLogger(LogApp.class.getName());
		
		// Создаём handler, который будет записывать лог
		// в файл "LogApp". Символ "%t" указывает на то, что файл 
		// будет располагаться в папке с системными временными файлами.
		try {                    
                    FileHandler fh = new FileHandler("%tLogApp");                        
                    //C:\Documents and Settings\Kiranatos\Local Settings\Temp
                    logger.addHandler(fh);
                    
                    // Добавляем ещё файл "LogApp.htm".
                    HtmlFormatter htmlformatter = new HtmlFormatter();
                    FileHandler htmlfile = new FileHandler("%tLogApp.htm");
                    // Устанавливаем html форматирование с помощью класса HtmlFormatter.
                    htmlfile.setFormatter(htmlformatter);
                    logger.addHandler(htmlfile);
			
		} catch (SecurityException e) {
			logger.log(Level.SEVERE, "Не удалось создать файл лога из-за политики безопасности.", e);
		} catch (IOException e) {
			logger.log(Level.SEVERE,"Не удалось создать файл лога из-за ошибки ввода-вывода.",e);
		}
		
		logger.log(Level.INFO, "Запись лога с уровнем INFO (информационная)");
		logger.log(Level.WARNING,"Запись лога с уровнем WARNING (Предупреждение)");
		logger.log(Level.SEVERE, "Запись лога с уровнем SEVERE (серъёзная ошибка)");
	}
}





class HtmlFormatter extends Formatter {	
	public HtmlFormatter() {}
        
	//Возвращаем заголовочную часть HTML файла.	 
	@Override
	public String getHead(Handler h) {
            //Записываем заголовок HTML файла, мета информацию и начало таблицы.
            return "<html><head><title>AppLog</title>" +
                    "<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\">" +
                    "</head><body>" + "<table border=1>" +
                    "<tr bgcolor=CYAN><td>date</td><td>level</td><td>class</td><td>method</td>" +
                    "<td>message</td><td>thrown message</td><td>stacktrace</td></tr>";
        }
        //Возвращаем хвост (конец) HTML файла.        
	@Override
	public String getTail(Handler h) {
		//Записываем окончание таблицы и конец HTML файла.		 
		return "</table></body></html>";
	}
	
	//Форматируем одно сообщение в строку таблицы.	 
	@Override
	public String format(LogRecord record) {
		StringBuilder result=new StringBuilder();
		Date d = new Date();
		Level level = record.getLevel();
		
		/**
		 * Ошибки будут выделены красным цветом, 
		 * предупреждения - серым,
		 * информационные сообщения - белым.
		 */
		if (level==Level.SEVERE) { result.append("<tr bgColor=Tomato><td>"); } 
                else if (level==Level.WARNING) { result.append("<tr bgColor=GRAY><td>"); } 
                else { result.append("<tr bgColor=WHITE><td>");	}
                
		result.append("\n");		
		result.append(d);
		result.append("</td><td>");
		result.append(record.getLevel().toString());
		result.append("</td><td>");
		result.append(record.getSourceClassName());
		result.append("</td><td>");
		result.append(record.getSourceMethodName());
		result.append("</td><td>");
		result.append(record.getMessage());
		result.append("</td><td>");
		
		Throwable thrown = record.getThrown();
		
		if (thrown!=null) {
                    // Если было передано исключение, то выводим полный стек вызовов.
                    result.append(record.getThrown().getMessage());
                    result.append("</td><td>");
                    
                    StringWriter sw = new StringWriter();
                    PrintWriter pw = new PrintWriter(sw);
                    record.getThrown().printStackTrace(pw);
                    String stackTrace = sw.toString();
                    result.append(stackTrace);
                    result.append("</td>");
		} else {
                    // Просто пустые ячейки.
                    result.append("</td><td>null");
                    result.append("</td>");
		}
		
		// Конец строки
		result.append("</tr>\n");
		return result.toString();
	}
}