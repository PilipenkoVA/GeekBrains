public class Test {

    public static void main(String[] args) {
        Animal cat1 = new Cat("Матроскин");
        Animal cat2 = new Cat("Васька");
        Animal dog1 = new Dog("Палкан");
        Animal dog2 = new Dog("Шарик");
        Animal dog3 = new Dog("Мухтар");
        Animal dog4 = new Dog("Великан");

        cat1.run(-2);
        cat2.swim(-55);

        dog1.run(600);
        dog2.swim(-69);
        dog3.swim(50);

        System.out.println("Создано " + Animal.getCount() + " животных, из них:");
        System.out.println("собак: " + Dog.getCount() + ",");
        System.out.println("кошек: " + Cat.getCount() + ".");

    }
}
