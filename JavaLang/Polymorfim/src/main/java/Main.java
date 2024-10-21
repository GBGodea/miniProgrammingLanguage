import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Animal dog = new Dog();
        Animal snake = new Snake();
        dog.walk();
        snake.walk();

        dog.food();
        snake.food();

        dog.say();
        snake.say();

        System.out.println(dog.getAnimalType());
        System.out.println(snake.getAnimalType());
        System.out.println(dog.owner(checkOwner(dog)));
        System.out.println(dog.owner(checkOwner(snake)));
    }

    private static String checkOwner(Animal animal) throws Exception {
        Scanner scanner = new Scanner(System.in);
        if(animal.getAnimalType().equals("Dog")) {
            System.out.println("Введите имя хозяина собаки");
            Dog dog = (Dog) animal;
            return dog.owner(scanner.nextLine());
        }

        if(animal.getAnimalType().equals("Snake")) {
            System.out.println("Введите имя хозяина змеи");
            Snake snake = (Snake) animal;
            return snake.owner(scanner.nextLine());
        }
        throw new Exception("We don't know any information about the animal owner");
    }
}
