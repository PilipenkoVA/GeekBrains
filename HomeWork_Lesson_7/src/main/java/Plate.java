public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public boolean decreaseFood(int appetite) {
        if (food - appetite < 0) {
            //4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы)
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

    //6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
    public void addFood(int addFood) {
        this.food += addFood;
    }


}
