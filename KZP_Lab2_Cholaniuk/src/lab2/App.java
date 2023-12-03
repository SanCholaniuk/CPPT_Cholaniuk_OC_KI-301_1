package lab2;

import java.io.IOException;

class App {
    public static void main(String[] args) throws IOException {
        ClimbingEquipment.Directions dir = null;
        Main climber = new Main();
        climber.clickLeftButton();
        System.out.print(climber.getLeftButtonResource() + "\n");
        climber.clickRightButton();
        System.out.print(climber.getRightButtonResource() + "\n");
        climber.setPosition(5, 3);
        climber.scrollDown();
        climber.scrollUp();
        dir = climber.getScrollingDirection();
        if (dir == ClimbingEquipment.Directions.DOWN)
            System.out.print("Down" + "\n");
        else if (dir == ClimbingEquipment.Directions.UP)
            System.out.print("Up" + "\n");
        else
            System.out.print("Neutral" + "\n");
        climber.dispose();
    }
}