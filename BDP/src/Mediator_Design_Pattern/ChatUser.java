package Mediator_Design_Pattern;

public class ChatUser {
    private final String name;
    private final ChatMediator mediator;

    public ChatUser(String name, ChatMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public void sendMessage(String message) {
        System.out.println(name + " sending msg - " + message);
        mediator.sendMessage(message, this);

    }

    public void receiveMessage(String message, ChatUser sender) {
        System.out.println(name + " received msg - " + message + " from " + sender.name);
    }
}
