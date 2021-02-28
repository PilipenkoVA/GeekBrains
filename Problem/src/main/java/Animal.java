public abstract class Animal {

    private static int count = 0;

    private String name;
    private int run_limit;
    private int swim_limit;

    public Animal(String name, int run_limit, int swim_limit) {
        this.name = name;
        this.run_limit = run_limit;
        this.swim_limit = swim_limit;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public void run(int length) {
        if (length > run_limit) {
            System.out.println(name + " пробежал " + run_limit + " метров и прилёг отдохнуть.");
        } else if (length > 0) {
            System.out.println(name + " пробежал " + length + " метров.");
        } else {
            System.out.println(name + " не понимает, сколько метров надо бежать");
        }
    }

    public void swim(int length) {
        if  (length > swim_limit) {
            System.out.println(name + " проплыл " + swim_limit + " метров и устал.");
        } else if (length > 0) {
            System.out.println(name + " проплыл " + length + " метров.");
        } else {
            System.out.println(name + " не понимает, сколько метров надо плыть");
        }
    }

}
