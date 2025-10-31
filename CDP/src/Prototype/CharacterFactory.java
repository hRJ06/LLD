package Prototype;

public class CharacterFactory {
    private Character prototypeCharacter;

    public CharacterFactory() {
        prototypeCharacter = new Character("DefaultName", 100, 50, 1);
    }

    public Character createCharacterWithNewName(String name) throws CloneNotSupportedException {
        Character clonedCharacter = prototypeCharacter.clone();
        clonedCharacter.setName(name);
        return clonedCharacter;
    }

    public Character createCharacterWithNewLevel(int level) throws CloneNotSupportedException {
        Character clonedCharacter = prototypeCharacter.clone();
        clonedCharacter.setLevel(level);
        return clonedCharacter;
    }

    public Character createCharacterWithNewAttackPower(int attackPower) throws CloneNotSupportedException {
        Character clonedCharacter = prototypeCharacter.clone();
        clonedCharacter.setAttackPower(attackPower);
        return clonedCharacter;
    }

    public Character createCharacterWithNewHealth(int health) throws CloneNotSupportedException {
        Character clonedCharacter = prototypeCharacter.clone();
        clonedCharacter.setHealth(health);
        return clonedCharacter;
    }
}
