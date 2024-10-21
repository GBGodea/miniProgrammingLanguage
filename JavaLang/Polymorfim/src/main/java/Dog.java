public class Dog implements Animal {
    public void walk() {
        System.out.println("Walking");
    }

    public void say() {
        System.out.println("Gav");
    }

    public void food() {
        System.out.println("Meat");
    }

    public String getAnimalType() {
        return Dog.class.getName();
    }

    public String owner(String name) {
        return name;
    }
}