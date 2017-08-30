package pattern.observer.ex4_spy;

/**
 * Завдання без перевірки - Шпигуни
 * 
 * Антикорупційне агентство дізналося про таємний З'їзд корупціонерів.
 * В ході з'їзду планується обговорити розширення лав корупціонерів,
 * способи відмивання коштів та нові джерела надходження хабарів.
 * 
 * Змоделюйте систему що дозволить агентству “підіслати” десять шпигунів на з'їзд.
 * Як тільки будуть озвучені дані по кожному з трьох пунктів порядку денного
 * (розширення лав, способи відмивання та джерела надходження) шпигуни повинні
 * сповістити агентство з вказанням отриманих даних.
 * 
 * Для вирішення задачі створіть класи Агентства, З'їзду та Шпигуна. 
 * З'їзд повинен мати можливість зареєструвати шпигуна та повідомити йому
 * інформацію. Шпигун повинен повідомити Агентство. Передбачте можливість
 * викриття шпигуна, в цьому випадку він не зможе отримувати та передавати інформацію.
 * 
 * Використовуйте шаблон проектування Спостерігач. Передбачте додатковий
 * клас Повідомлення за допомогою якого буде йти передача даних.
 * 
 * https://edx.prometheus.org.ua * 
 * автор Ігор Деркач: Основи програмування на Java
 * (Тиждень 5 Завдання для самостійної перевірки)
 */

public class StartGame {
    
    public static void main(String[] args) {
        
        Congress firstCongress = new Congress();
        
        CorruptionOrganization badPeople = new CorruptionOrganization(firstCongress);
        badPeople.start();        
        
        Agency agency = new Agency(firstCongress);
        agency.start();
        
        firstCongress.startLecture(new Message("розширення лав"));
        firstCongress.startLecture(new Message("способи відмивання"));
        firstCongress.startLecture(new Message("джерела надходження"));        
    }
    
}