package KZP_Lab6_Cholaniuk;
public class Wrench extends Tool {
    public Wrench(String name, String material, int weight) {
        super(name, material, weight);
    }
    @Override
    public void print() {
        System.out.println("Розвідний ключ: " + getName() + ", Матеріал: " + getMaterial() + ", Вага: " + getWeight() + " г");
    }
}