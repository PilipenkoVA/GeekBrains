public class Main {

    public static void main(String[] args) {

        Animal cat1 = new Cat("Murzik_1");
        Animal cat2 = new Cat("Murzik_2");
        Animal dog3 = new Dog("Bobik_3");
        Animal dog4 = new Dog("Bobik_4");
        Animal dog5 = new Dog("Bobik_5");

        System.out.println("Было создано "+Animal.getCount()+" ед., животных");
        System.out.println("Собак "+Dog.getCount()+" шт.");
        System.out.println("Кошек "+Cat.getCount()+" шт.\n");                      // дописал символ "\n" для перехода текста на другую строку в терминале

        System.out.println("Для начала всех отправили бегать");

        cat1.run(500);                                                      // задаем растояние необходимое пробежать для каждого
        cat2.run(100);
        dog3.run(600);
        dog4.run(200);
        dog5.run(-3);

        System.out.println("\nА теперь животных отправили плавать");

        cat1.swim(12);                                                      // задаем растояние необходимое проплыть для каждого
        cat2.swim(2);
        dog3.swim(-2);
        dog4.swim(9);
        dog5.swim(17);

    }

}
