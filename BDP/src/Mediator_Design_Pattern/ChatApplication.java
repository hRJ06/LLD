package Mediator_Design_Pattern;

public class ChatApplication {
    public static void main(String[] args) {
        ChatRoom room = new ChatRoom();
        ChatUser hindol = new ChatUser("Hindol Roy", room);
        ChatUser john = new ChatUser("John Doe", room);
        room.addUser(hindol);
        room.addUser(john);
        hindol.sendMessage("Hi! Hindol here.");
    }
}
