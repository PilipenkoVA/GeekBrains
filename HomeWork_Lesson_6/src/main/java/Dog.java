class Dog extends Animal {
    int run;
    int swim;

    public Dog(String name, int run, int swim){
        super("Tigr");
        this.run = run;
        this.swim = swim;
    }

    public void dogInfo (){
        System.out.println("Животное собака: кличка " + name + " , может пробежать: " + run + "м. и проплыть: " + swim + "м.");
    }

}
