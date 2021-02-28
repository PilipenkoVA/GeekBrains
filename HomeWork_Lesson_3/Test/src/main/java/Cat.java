public class Cat extends Animal {                       // наследование от класса "Animal"

    private static int count = 0;                       // необходимо указать "private static" иначе не будет считаться

    public Cat (String name){
        super(name, 200,-1);         // значение "swim_light = -1" так как кошка не умеет плавать
        count++;
    }
    public static int getCount() {                     // необходимо указать "public static" иначе не будет считаться
        return count;
    }
    @Override
    public void swim(int lenght){                      // когда преопределяем метод незабываем прописывать "super.getName()" ниже, а не "name"
        System.out.println(super.getName()+" никуда не поплыл так как не умеет плавать.");
    }
}
