package KZP_Lab6_Cholaniuk;
public abstract class Tool implements Comparable<Tool> {
    private String name;
    private String material;
    private int weight;
    public Tool(String name, String material, int weight) {
        this.name = name;
        this.material = material;
        this.weight = weight;
    }
    public String getName() {
        return name;
    }
    public String getMaterial() {
        return material;
    }
    public int getWeight() {
        return weight;
    }
    public abstract void print();

    public int compareTo(Tool tool) {
        Integer w = weight;
        return w.compareTo(tool.getWeight());
    }
}