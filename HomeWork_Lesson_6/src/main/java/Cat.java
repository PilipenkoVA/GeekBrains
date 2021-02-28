class Cat extends Animal {
    int run;

    public Cat(){

    }


    public Cat(String name, int run){
        this.name = name;
        this.run = run;
    }
    public void catInfo (){
        System.out.println("Животное кошка: кличка " + name + ", может пробежать: " + run + "м.");
    }

}
