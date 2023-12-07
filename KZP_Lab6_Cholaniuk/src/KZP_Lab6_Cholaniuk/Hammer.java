package KZP_Lab6_Cholaniuk;
public class Hammer extends Tool {
    public Hammer(String name, String material, int weight) {
        super(name, material, weight);
    }
    @Override
    public void print() {
        System.out.println("Молоток: " + getName() + ", Матеріал: " + getMaterial() + ", Вага: " + getWeight() + " г");
    }
}
