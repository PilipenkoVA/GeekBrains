 class Animal {

    String name;
    int run_limit;
    int swim_limit;

    private static int count = 0;

    public Animal(String name, int run_limit, int swim_limit){
        this.name = name;
        this.run_limit = run_limit;
        this.swim_limit = swim_limit;
        count++;

    }

    public String getName(){

        return name;
    }

    public static int getCount(){

        return count;
    }

     public void run(int lenght){
         if (lenght>run_limit&&lenght>0){
             System.out.println(name+" пробежал " +run_limit+"м. и решил отдохнуть, потому как ему необходимо пробежать = "+lenght+"м.");
         }else  if (lenght<=run_limit&&lenght>0) {
             System.out.println(name + " пробежал всю дистанцию = " + lenght+"м.");
         }else {
             System.out.println("Для животного --> "+name+", вы не правильно определили дистанцию.");
         }
     }

     public void swim(int lenght){
         if (lenght>swim_limit&&lenght>0){
             System.out.println(name+" проплыл " +swim_limit+"м. и решил отдохнуть, потому как ему необходимо проплыть = "+lenght+"м.");
         }else  if (lenght<=swim_limit&&lenght>0) {
             System.out.println(name + " проплыл всю дистанцию = " + lenght+"м.");
         }else {
             System.out.println("Для животного --> "+name+", вы не правильно определили дистанцию.");
         }
     }
}
