package Mediator_Design_Pattern;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom implements ChatMediator{
    private final List<ChatUser> users;
    public ChatRoom() {
        this.users = new ArrayList<>();
    }
    @Override
    public void addUser(ChatUser user) {
        users.add(user);
    }

    @Override
    public void sendMessage(String message, ChatUser sender) {
        for(ChatUser user : users) {
            if(user != sender) {
                user.receiveMessage(message, sender);
            }
        }
    }
}
