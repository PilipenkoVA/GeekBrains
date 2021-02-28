public class Dog extends Animal{

    private static int count = 0;                       // необходимо указать "private static" иначе не будет считаться

    public Dog (String name){
        super(name,500,10);
        count++;
    }
    public static int getCount() {                      // необходимо указать "public static" иначе не будет считаться
        return count;
    }
}
