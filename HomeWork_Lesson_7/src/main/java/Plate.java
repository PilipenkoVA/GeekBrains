public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public boolean eatFood(int appetite) {             // Метод уменьшающий количество еды в тарелке
        if (food - appetite < 0) {                     // Если коту мало еды в тарелке, он ее не трогает.
            return false;
        }
        else {
            food -= appetite;
            return true;
        }
    }
    public void inInfo() {

        System.out.println("В тарелку насыпали " + food + " грамм. корма.\nПосле чего решили покормить котов:");
    }

    public void offInfo() {

        System.out.println("\nВ тарелке осталось " + food + " грамм. корма.");
    }


    public void addFood(int addFood) {               // Метод, с помощью которого можно добавлять в тарелку еду

        this.food += addFood;
    }


}
