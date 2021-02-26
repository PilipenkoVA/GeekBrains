public class Person {
    private String fio;
    private String pisition;
    private String email;
    private String tel;
    private int salary;
    private int age;

    Person(String fio, String position, String email, String tel, int salary, int age) {
        this.fio = fio;
        this.pisition = position;
        this.email = email;
        this.tel = tel;
        this.salary = salary;
        if(age >= 18) {                                                             // для проверки возраста сотрудников
            this.age = age;
        } else {
            System.out.println("Сотрудник должен быть старше 18 лет");
        }
    }

    public  int getAge() {
        return age;
    }

    public void isData() {
        System.out.println(fio + " " + pisition + " " +  email + " " + tel + " " + salary + " " + age);
    }
}




