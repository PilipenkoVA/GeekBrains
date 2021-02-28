class Cat extends Animal {

    private static int count = 0;

    public Cat(String name){
        super(name, 200, -1);
        count++;
    }


    public static int getCount(){
        return count;
    }

    @Override                                                            // переопределяем метод "Animal"
    public void swim(int lenght){
        System.out.println(name+" ни куда не поплыл так как не умеет плавать.");
    }
}
