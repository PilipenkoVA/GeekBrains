
public class Cat {

    private String name;
    private int appetite;
    private boolean full;                          // "boolean default = false" - поэтому Кот при создании "голодный"

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public String getName() {

        return name;
    }

    public int getAppetite() {

        return appetite;
    }

    public void eat(Plate plate) {

        full = plate.eatFood(appetite);
    }

    public void info() {

        System.out.println(name + " " + (full ? " - наелся." : " - остался голоден так как ему не хватило еды."));
    }


}
