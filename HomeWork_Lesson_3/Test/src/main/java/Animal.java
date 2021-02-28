public class Animal {

    private  String name;                               // необходимо указывать "private" иначе будет проблема
    private  int run_leght;                             // необходимо указывать "private" иначе будет проблема
    private  int swim_light;                            // необходимо указывать "private" иначе будет проблема

    private static int count = 0;                        // необходимо указать "private static" иначе не будет считаться

    public Animal(String name, int run_leght, int swim_light){
        this.name = name;
        this.run_leght = run_leght;
        this.swim_light = swim_light;
        count++;

    }
    public String getName(){                             // если не прописать данный метод, мы не сможем вставить имя животного
                                                         // в метод который переопределяем в другом классе
        return name;
    }

    public static int getCount() {                       // необходимо указать "public static" иначе не будет считаться
        return count;
    }
    public void run(int lenght){                         // не забыть указать метод "public void" и новую переменную "int lenght"
        if(lenght>run_leght&&lenght>0){                  // также не забыть указать "&& lenght > 0" т.к. значение парраметра ввода должно быть корректным
            System.out.println(name+" пробежал "+run_leght+"м. и решил отдохнуть, так как нет сил, а бежать осталось "+(lenght-run_leght)+"м.");
        }else if (lenght<run_leght&&lenght>0){
            System.out.println(name+" пробежал всю дистанцию = "+lenght+"м.");
        }else {
            System.out.println("Вы указали, не верное значение дистанции, для животного --> "+name);
        }
    }
    public void swim(int lenght){                        // не забыть указать метод "public void" и новую переменную "int lenght"(вводимое растояние)
        if(lenght>swim_light&&lenght>0){
            System.out.println(name+" проплыл "+swim_light+"м. и решил отдохнуть, так как нет сил, а плыть еще "+(lenght-swim_light)+"м.");
        }else if (lenght<swim_light&&lenght>0){
            System.out.println(name+" проплыл всю дистанцию = "+lenght+"м.");
        }else {
            System.out.println("Вы указали, не верное значение дистанции, для животного --> "+name);
        }
    }
}
