package KZP_Lab6_Cholaniuk;

import java.util.ArrayList;

public class ToolBox<T extends Tool> {
    private ArrayList<T> tools;

    public ToolBox() {
        tools = new ArrayList<T>();
    }
    public T findMax() {
        if (!tools.isEmpty()) {
            T max = tools.get(0);
            for (int i = 1; i < tools.size(); i++) {
                if (tools.get(i).compareTo(max) > 0)
                    max = tools.get(i);
            }
            return max;
        }
        return null;
    }
    public void addTool(T tool) {
        tools.add(tool);
        System.out.print("Інструмент додано: ");
        tool.print();
    }
    public void deleteTool(int i) {
        tools.remove(i);
    }
}