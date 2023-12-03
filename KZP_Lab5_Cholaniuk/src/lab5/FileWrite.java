package lab5;

import java.io.*;
import java.util.Scanner;

public class FileWrite {
    public static void writeResultToTxt(String fileName, double number) throws IOException {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            writer.printf("%f ", number);
        }
    }

    public static void writeResultToBin(String fileName, double number) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeDouble(number);
        }
    }

    public static double readResultFromTxt(String fileName) throws IOException {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            return scanner.nextDouble();
        }
    }

    public static double readResultFromBin(String fileName) throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            return dis.readDouble();
        }
    }
}