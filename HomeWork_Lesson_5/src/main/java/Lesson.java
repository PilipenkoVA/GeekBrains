public class Lesson {


    public static void main(String[] args) {

        Person[] Human = new Person[7]; // Вначале объявляем массив объектов
        Human[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "89215643277", 32000, 30);
        Human[1] = new Person("Ivanov Ivan1", "Engineer1", "ivivan1@mailbox.com", "86354254372", 41000, 24);
        Human[2] = new Person("Ivanov Ivan2", "Engineer2", "ivivan2@mailbox.com", "89835485374", 54000, 52);
        Human[3] = new Person("Ivanov Ivan3", "Manager1", "ivivan3@mailbox.com", "89143262133", 63000, 31);
        Human[4] = new Person("Ivanov Ivan4", "Manager2", "ivivan4@mailbox.com", "89023164299", 65000, 43);
        Human[5] = new Person("Ivanov Ivan5", "Driver1", "Ivanov5@mail.box.com", "87654352362", 34555, 46);
        Human[6] = new Person("Ivanov Ivan6", "Diver2", "Ivanov6@mailbox.com", "89762436273", 32000, 20);

        for(Person item : Human) {
            if(item.getAge() > 40) {
                item.isData();
            }
        }
    }
}
