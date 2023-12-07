package KZP_Lab6_Cholaniuk;
public class Screwdriver extends Tool {
    public Screwdriver(String name, String material, int weight) {
        super(name, material, weight);
    }
    @Override
    public void print() {
        System.out.println("Викрутка: " + getName() + ", Матеріал: " + getMaterial() + ", Вага: " + getWeight() + " г");
    }
}