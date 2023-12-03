package lab2;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.io.*;
import java.io.IOException;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Main {
    private ClimbingEquipment climbingEquipment;
    private Position currentPosition;
    private Carabiner rightCarabiner;
    private Carabiner leftCarabiner;
    private PrintWriter fout;
    private PrintWriter actionLogWriter;

    // Файл для "Log.txt"
    private static final String LOG_FILE = "Log.txt";

    // Файл для "ActionLog.txt"
    private static final String ACTION_LOG_FILE = "ActionLog.txt";

    public Main() throws IOException {
        climbingEquipment = new ClimbingEquipment();
        currentPosition = new Position();
        rightCarabiner = new Carabiner();
        leftCarabiner = new Carabiner();
        fout = new PrintWriter(new File(LOG_FILE));
        actionLogWriter = new PrintWriter(new FileWriter(ACTION_LOG_FILE, true));
    }

    private void logToFile(String message) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = dateFormat.format(new Date());

        String logMessage = "[" + timestamp + "] " + message;

        try (FileWriter writer = new FileWriter(ACTION_LOG_FILE, true)) {
            writer.write(logMessage + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setPosition(int xPosition, int yPosition) {
        currentPosition.setXPosition(xPosition);
        currentPosition.setYPosition(yPosition);
        logToFile("Set climber position. X: " + xPosition + ", Y: " + yPosition);
        fout.print("Set climber position. X: " + xPosition + ", Y: " + yPosition + "\n");
        fout.flush();
    }

    public void clickLeftButton() {
        leftCarabiner.clickButton();
        logToFile("Clicked left carabiner button. New resource: " + leftCarabiner.getButtonResource());
        fout.print("Clicked left carabiner button. New resource: " + leftCarabiner.getButtonResource() + "\n");
        fout.flush();
    }

    public void clickRightButton() {
        rightCarabiner.clickButton();
        logToFile("Clicked right carabiner button. New resource: " + rightCarabiner.getButtonResource());
        fout.print("Clicked right carabiner button. New resource: " + rightCarabiner.getButtonResource() + "\n");
        fout.flush();
    }

    public int getRightButtonResource() {
        logToFile("Requested right carabiner button resource: " + rightCarabiner.getButtonResource());
        return rightCarabiner.getButtonResource();
    }

    public int getLeftButtonResource() {
        logToFile("Requested left carabiner button resource: " + leftCarabiner.getButtonResource());
        return leftCarabiner.getButtonResource();
    }

    public void scrollUp() {
        climbingEquipment.setUpDirection();
        logToFile("Scrolled up. Climbing equipment direction: " + climbingEquipment.getDirection());
        fout.print("Scrolled up. Climbing equipment direction: " + climbingEquipment.getDirection() + "\n");
        fout.flush();
    }

    public void scrollDown() {
        climbingEquipment.setDownDirection();
        logToFile("Scrolled down. Climbing equipment direction: " + climbingEquipment.getDirection());
        fout.print("Scrolled down. Climbing equipment direction: " + climbingEquipment.getDirection() + "\n");
        fout.flush();
    }

    public void resetScroller() {
        climbingEquipment.resetScroller();
        logToFile("Reset climber scroller. Climbing equipment direction: " + climbingEquipment.getDirection());
        fout.print("Reset climber scroller. Climbing equipment direction: " + climbingEquipment.getDirection() + "\n");
        fout.flush();
    }

    public ClimbingEquipment.Directions getScrollingDirection() {
        logToFile("Requested climbing equipment scrolling direction: " + climbingEquipment.getDirection());
        return climbingEquipment.getDirection();
    }

    public void dispose() {
        fout.close();
        actionLogWriter.close();
    }
}

class ClimbingEquipment {
    enum Directions {NEUTRAL, UP, DOWN};
    private Directions direction;

    public ClimbingEquipment() {
        direction = Directions.NEUTRAL;
    }

    public void setUpDirection() {
        direction = Directions.UP;
    }

    public void setNeutralDirection() {
        direction = Directions.NEUTRAL;
    }

    public void setDownDirection() {
        direction = Directions.DOWN;
    }

    public void resetScroller() {
        setNeutralDirection();
    }

    public Directions getDirection() {
        return direction;
    }
}

class Position {
    private int x, y;

    public Position() {
        x = 0;
        y = 0;
    }

    public int getXPosition() {
        return x;
    }

    public int getYPosition() {
        return y;
    }

    public void getXPosition(Position obj) {
        obj.x = x;
        obj.y = y;
    }

    public void setXPosition(int xPos) {
        x = xPos;
    }

    public void setYPosition(int yPos) {
        y = yPos;
    }
}

class Carabiner {
    private int btnResource;

    public Carabiner() {
        btnResource = 10;
    }

    public void clickButton() {
        btnResource = btnResource - 1;
    }

    public int getButtonResource() {
        return btnResource;
    }

}