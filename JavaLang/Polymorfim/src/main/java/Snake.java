public class Snake implements Animal {
    public void walk() {
        System.out.println("Crawling");
    }

    public void say() {
        System.out.println("SsSsSsS");
    }

    public void food() {
        System.out.println("Rat");
    }

    public String getAnimalType() {
        return Snake.class.getName();
    }

    public String owner(String name) {
        return name;
    }
}
