package pattern.observer.ex4_spy;

public class Message {
    private String message;

    public Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
