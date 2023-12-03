package MyPr1;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MilitaryClimber extends Main implements IntEq {
    private int getCamouflageDurability;
    private double getRopeLength;
    private PrintWriter fout;
    PrintWriter actionLogWriter;
    private static final String LOG_FILE = "Log.txt";
    static final String ACTION_LOG_FILE = "ActionLog.txt";


    public MilitaryClimber(int getCamouflageDurability, double getRopeLength) throws IOException {
        this.getCamouflageDurability = getCamouflageDurability;
        this.getRopeLength = getRopeLength;

        fout = new PrintWriter(new File(LOG_FILE));
        actionLogWriter = new PrintWriter(new FileWriter(ACTION_LOG_FILE, true));
    }
    void logToFile(String message) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = dateFormat.format(new Date());

        String logMessage = "[" + timestamp + "] " + message;

        try (FileWriter writer = new FileWriter(ACTION_LOG_FILE, true)) {
            writer.write(logMessage + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void setPosition(int xPosition, int yPosition) {
        logToFile("Set climber position. X: " + xPosition + ", Y: " + yPosition);
        fout.print("Set climber position. X: " + xPosition + ", Y: " + yPosition + "\n");
        fout.flush();
    }
    @Override
    public void clickLeftButton() {
        leftCarabiner.clickButton();
        logToFile("Clicked left carabiner button. New resource: " + leftCarabiner.getButtonResource());
        fout.print("Clicked left carabiner button. New resource: " + leftCarabiner.getButtonResource() + "\n");
        fout.flush();
    }
    @Override
    public void clickRightButton() {
        rightCarabiner.clickButton();
        logToFile("Clicked right carabiner button. New resource: " + rightCarabiner.getButtonResource());
        fout.print("Clicked right carabiner button. New resource: " + rightCarabiner.getButtonResource() + "\n");
        fout.flush();
    }
    @Override
    public int getRightButtonResource() {
        return -4;
    }
    @Override
    public int getLeftButtonResource() {
        return -4;
    }
    @Override
    public void scrollUp() {
        climbingEquipment.setUpDirection();
        logToFile("Scrolled up. Climbing equipment direction: " + climbingEquipment.getDirection());
        fout.print("Scrolled up. Climbing equipment direction: " + climbingEquipment.getDirection() + "\n");
        fout.flush();
    }
    @Override
    public void scrollDown() {
        climbingEquipment.setDownDirection();
        logToFile("Scrolled down. Climbing equipment direction: " + climbingEquipment.getDirection());
        fout.print("Scrolled down. Climbing equipment direction: " + climbingEquipment.getDirection() + "\n");
        fout.flush();
    }
    @Override
    public void scrollNeutral() {

    }
    @Override
    public ClimbingEquipment.Directions getScrollingDirection() {
        int rightResource = getRightButtonResource();
        int leftResource = getLeftButtonResource();

        if (rightResource == 0 && leftResource == 0) {
            return ClimbingEquipment.Directions.NEUTRAL;
        } else if (rightResource >= 0 && leftResource > 0 || rightResource > 0 || rightResource < 0 && leftResource >= 0) {
            return ClimbingEquipment.Directions.UP;
        } else if (rightResource < 0) {
            return ClimbingEquipment.Directions.DOWN;
        } else {
            return ClimbingEquipment.Directions.NEUTRAL;
        }
    }
    public int getCamouflageDurability() {
        return 3;
    }
    public double getRopeLength() {
        return 41.4;
    }

}
