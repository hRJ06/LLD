package Mediator_Design_Pattern;

public interface ChatMediator {
    void addUser(ChatUser user);
    void sendMessage(String message, ChatUser sender);
}
