package KZP_Lab6_Cholaniuk;

public class Main {
    public static void main(String[] args) {
        ToolBox<? super Tool> toolBox = new ToolBox<Tool>();
        toolBox.addTool(new Hammer("Молоток", "Метал", 500));
        toolBox.addTool(new Screwdriver("Викрутка", "Пластик", 150));
        toolBox.addTool(new Wrench("Розвідний ключ", "Сталь", 300));
        Tool maxTool = toolBox.findMax();
        System.out.print("Найкращий інструмент у наборі інструментів: \n");
        maxTool.print();
    }
}