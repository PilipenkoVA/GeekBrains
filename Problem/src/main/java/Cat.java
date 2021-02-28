public class Cat extends Animal {

    private static int count = 0;

    public Cat (String name) {
        super(name, 200, -1);
        count++;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public void swim(int length) {
        System.out.println(super.getName() + " не умеет плавать!");
    }
}
