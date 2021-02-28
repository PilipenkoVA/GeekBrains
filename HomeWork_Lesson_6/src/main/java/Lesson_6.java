public class Lesson_6 {
//1. Создать классы Собака и Кот с наследованием от класса Животное.+++++

//2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
// Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');

//3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
//4. * Добавить подсчет созданных котов, собак и животных.


    public static void main (String[] args) {
        Animal cat1 = new Cat("Murzik_1");
        Animal cat2 = new Cat("Murzik_2");
        Animal cat3 = new Cat("Murzik_3");
        Animal dog4 = new Dog("Barsik_4");
        Animal dog5 = new Dog("Barsik_5");
        Animal dog6 = new Dog("Barsik_6");
        Animal dog7 = new Dog("Barsik_7");
        Animal dog8 = new Dog("Barsik_8");

        cat1.run(300);
        cat2.run(150);
        cat3.swim(10);

        dog4.run(700);
        dog5.run(450);
        dog6.swim(15);
        dog7.swim(10);
        dog8.swim(-1);

        System.out.println("\nБыло создано: "+Animal.getCount()+" животных.");
        System.out.println("Кошек: "+Cat.getCount()+" шт.");
        System.out.println("Собак: "+Dog.getCount()+" шт.");


    }

}
