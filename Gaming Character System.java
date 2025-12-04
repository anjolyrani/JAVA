
interface CharacterActions {
    void attack();
    void defend();
    void gainExperience(int points);
}

abstract class GameCharacter implements CharacterActions {
    protected String name;
    protected int level;
    protected int experience;

    GameCharacter(String name, int level, int experience) {
        this.name = name;
        this.level = level;
        this.experience = experience;
    }

    void showStats() {
        System.out.println("Name: " + name + " | Level: " + level + " | Experience: " + experience);
    }

    public abstract void attack();
    public abstract void defend();
}

class Warrior extends GameCharacter {

    Warrior(String name, int level, int experience) {
        super(name, level, experience);
    }

    public void firstAttack() {
        System.out.println(name + " attacks fiercely with a sword!");
        gainExperience(40);
    }

    public void secondAttack() {
        System.out.println(name + " attacks fiercely with a sword!");
        gainExperience(60);
    }

    public void defend() {
        System.out.println(name + " defends with a shield!");
    }

    public void gainExperience(int points) {
        experience += points;
        System.out.println("Experience gained: " + points);
        level = 1 + (experience / 100);
        experience = experience % 100;
        System.out.println("Level up! " + name + " reached Level " + level);
    }

    public void attack() {}
}
class GameSystem {
    public static void main(String[] args) {

        Warrior w = new Warrior("Aragon", 1, 0);

        System.out.println("Character Created: Aragon");
        System.out.println("Level: 1 | Experience: 0");

        w.firstAttack();
        w.defend();
        w.secondAttack();

        System.out.println("Final Stats:");
        w.showStats();
    }
}
