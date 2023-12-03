package lab5;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {

            System.out.print("Введіть x: ");
            double x = new Scanner(System.in).nextDouble();

            double y = calculateY(x);
            System.out.print("Введіть назву текстового файлу: ");
            String txtFileName = new Scanner(System.in).nextLine();


            System.out.print("Введіть назву бінарного файлу: ");
            String binFileName = new Scanner(System.in).nextLine();

            FileWrite.writeResultToTxt(txtFileName, y);

            FileWrite.writeResultToBin(binFileName, y);

            System.out.println("Результат було успішно записано в файли.");

            double resultFromTxt = FileWrite.readResultFromTxt(txtFileName);
            System.out.println("Результат з текстового файлу: " + resultFromTxt);

            double resultFromBin = FileWrite.readResultFromBin(binFileName);
            System.out.println("Результат з бінарного файлу: " + resultFromBin);

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static double calculateY(double x) {
        try {

            Equations equations = new Equations();
            return equations.calculate(x);
        } catch (CalcException e) {
            e.printStackTrace();
            return Double.NaN;
        }
    }
}