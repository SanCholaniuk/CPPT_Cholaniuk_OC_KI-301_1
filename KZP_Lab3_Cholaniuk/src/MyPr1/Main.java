package MyPr1;

import java.io.*;
import java.io.IOException;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
public abstract class Main {
    public ClimbingEquipment climbingEquipment;
    public Position currentPosition;
    public Carabiner rightCarabiner;
    public Carabiner leftCarabiner;
    public PrintWriter fout;
    PrintWriter actionLogWriter;
    public static final String LOG_FILE = "Log.txt";
    static final String ACTION_LOG_FILE = "ActionLog.txt";

    public Main() throws IOException {
        climbingEquipment = new ClimbingEquipment();
        currentPosition = new Position();
        rightCarabiner = new Carabiner();
        leftCarabiner = new Carabiner();
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



    public abstract void setPosition(int xPosition, int yPosition);

    public abstract void clickLeftButton();

    public abstract void clickRightButton();

    public abstract int getRightButtonResource();

    public abstract int getLeftButtonResource();

    public abstract void scrollUp();

    public abstract void scrollDown();

    public abstract void scrollNeutral();


    public abstract ClimbingEquipment.Directions getScrollingDirection();

}


class ClimbingEquipment {
    public void setDownDirection() {
    }

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