package polymorphism;

public class GameCharacter {
    protected String characterName;

    public GameCharacter(String characterName) {
        this.characterName = characterName;
    }

    public void performAttack() {
        System.out.println(characterName + " attacks");
    }

    public String getCharacterName() {
        return characterName;
    }
}

class Warrior extends GameCharacter {
    public Warrior(String characterName) {
        super(characterName);
    }

    public void performAttack() {
        System.out.println(characterName + " attacks with a sword");
    }
}

class Mage extends GameCharacter {
    public Mage(String characterName) {
        super(characterName);
    }

    public void performAttack() {
        System.out.println(characterName + " attacks with magic");
    }
}

class Archer extends GameCharacter {
    public Archer(String characterName) {
        super(characterName);
    }

    public void performAttack() {
        System.out.println(characterName + " attacks with arrows");
    }
}

class GameBattle {
    public static void startBattle(GameCharacter[] characters) {
        int warriorCount = 0;
        int mageCount = 0;
        int archerCount = 0;

        System.out.println("Battle Started:");

        for (GameCharacter character : characters) {
            character.performAttack();

            if (character instanceof Warrior) {
                warriorCount++;
            } else if (character instanceof Mage) {
                mageCount++;
            } else if (character instanceof Archer) {
                archerCount++;
            }
        }

        System.out.println();
        System.out.println("Warriors participated: " + warriorCount);
        System.out.println("Mages participated: " + mageCount);
        System.out.println("Archers participated: " + archerCount);
    }
}

class GameCharacterMain {
    public static void main(String[] args) {
        GameCharacter[] characters = {
            new Warrior("Arjun"),
            new Archer("Kabir"),
            new Mage("Meera")
        };

        GameBattle.startBattle(characters);
    }
}
