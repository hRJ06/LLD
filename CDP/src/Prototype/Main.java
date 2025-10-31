package Prototype;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        CharacterFactory factory = new CharacterFactory();
        Character character1 = factory.createCharacterWithNewName("Hindol Roy");
        Character character2 = factory.createCharacterWithNewLevel(5);
        Character character3 = factory.createCharacterWithNewAttackPower(60);
        Character character4 = factory.createCharacterWithNewHealth(50);
    }
}
