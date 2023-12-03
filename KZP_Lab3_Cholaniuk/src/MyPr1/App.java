package MyPr1;

import java.io.IOException;


public class App {
    public static void main(String[] args) throws IOException {
        MilitaryClimber climber = null;

            ClimbingEquipment.Directions dir = null;
            climber = new MilitaryClimber(0, 0.0);
            climber.clickLeftButton();
            System.out.print("Вісь x: " + climber.getLeftButtonResource() + "\n");
            climber.clickRightButton();
            System.out.print("Вісь y: " + climber.getRightButtonResource() + "\n");
            climber.setPosition(0, 0);
            climber.scrollDown();
            climber.scrollNeutral();
            climber.scrollUp();
            dir = climber.getScrollingDirection();
            if (dir == ClimbingEquipment.Directions.DOWN)
                System.out.print("Down" + "\n");
            else if (dir == ClimbingEquipment.Directions.UP)
                System.out.print("Up" + "\n");
            else
                System.out.print("Neutral" + "\n");
            System.out.println("Залишок маскувальних сіток: " + climber.getCamouflageDurability() + " одиниць ");
            System.out.println("Залишок мотузки: " + climber.getRopeLength() + " м ");

    }
}