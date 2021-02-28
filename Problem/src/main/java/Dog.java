public class Dog extends Animal {

    private static int count = 0;

    public Dog (String name) {
        super(name, 500, 10);
        count++;
    }

    public static int getCount() {
        return count;
    }
}
