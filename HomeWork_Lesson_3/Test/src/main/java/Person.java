public class Person {

    private String isFIO;
    private String phone;
    private String email;
    private int age;

    void Person(String isFIO, String phone, String email, int age){
        this.isFIO = isFIO;
        this.phone = phone;
        this.email = email;
        if (this.age > 18){
            this.age = age;
        }else {
            System.out.println("Возраст должен быть более 18 лет");
        }


    }
}
