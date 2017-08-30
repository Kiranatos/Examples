package pattern.command.ex1_youtube;

/**
 * Шаблон:Команда (Command)
 * 
 * Canal:       Eugene Suleimanov
 *                  https://www.youtube.com/channel/UCj7PgzcJ5yZfspMzxUUYcIA
 * PlayList:    Шаблоны проектирования на языке Java
 *                  https://www.youtube.com/playlist?list=PLlsMRoVt5sTPgGbinwOVnaF1mxNeLAD7P
 * Video:       Шаблоны Java. Command (Команда).
 *                  https://www.youtube.com/watch?v=T3oXyVYmkyY&index=19&list=PLlsMRoVt5sTPgGbinwOVnaF1mxNeLAD7P
 * 
 * Для чего используется:
 *      Чтобы задать параметры клиентов для обработки определённых запросов, создание очереди
 * из этих запросов или их контроля и поддержки отмены операций.
 * 
 * Пример использования:
 *      - параметризация объектов выполняемым действием;
 *      - определять запрос, ставить его в очередь или выполнять его в разное время
 */
public class CommandAppEx2 {
    public static void main(String[] args) {
        Database database = new Database();
        Developer developer = new Developer (
                new InsertCommand(database),
                new UpdateCommand(database),
                new SelectCommand(database),
                new DeleteCommand(database)
        );
        developer.insertRecord();
        developer.selectRecord();
        developer.updateRecord();
        developer.deleteRecord();
    }    
}

interface Command2{ void execute(); }

// Reciver - получатель, приемник
class Database{
    void insert() { System.out.println("Inserting in database"); }
    void update() { System.out.println("Updating in database"); }
    void select() { System.out.println("Selecting in database"); }
    void delete() { System.out.println("Deleting in database"); }
}

// ----------------------------------------------
class DeleteCommand implements Command2 {
    Database database;
    public DeleteCommand(Database database) { this.database = database; }    
    public void execute() { database.delete(); }
}
class InsertCommand implements Command2 {        
    Database database;
    public InsertCommand(Database database) { this.database = database; }    
    public void execute() { database.insert(); }
}
class SelectCommand implements Command2 {        
    Database database;
    public SelectCommand(Database database) { this.database = database; }    
    public void execute() { database.select(); }
}
class UpdateCommand implements Command2 {        
    Database database;
    public UpdateCommand(Database database) { this.database = database; }    
    public void execute() { database.update(); }
}

// Invoker (invoke - вызывать)
class Developer {
    private Command2 insert;
    private Command2 update;
    private Command2 select;
    private Command2 delete;

    public Developer(Command2 insert, Command2 update, Command2 select, Command2 delete) {
        this.insert = insert;
        this.update = update;
        this.select = select;
        this.delete = delete;
    }

    void insertRecord(){ insert.execute(); }
    void updateRecord(){ update.execute(); }
    void selectRecord(){ select.execute(); }
    void deleteRecord(){ delete.execute(); }
}