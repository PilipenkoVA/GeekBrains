class Cat extends Animal {

    private static int count = 0;                                        // для счетчика животных

    public Cat(String name){                                            // метод определяющий характеристики животного
        super(name, 200, -1);
        count++;
    }

    public void catInfo (){                                             // информация с характеристиками животного
        System.out.println("Животное кошка: " + name + ", может пробежать: " + run_limit + "м., не умеет плавать");
    }

    public static int getCount(){
        return count;
    }

    @Override                                                            // переопределяем метод "Animal"
    public void swim(int lenght){
        System.out.println(name+" ни куда не поплыл так как не умеет плавать.");
    }
}
