package KZP.Lab4.Cholaniuk;

import java.util.*;
import java.io.*;
import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        try {
            out.print("Введіть ім'я файлу: ");
            Scanner in = new Scanner(System.in);
            String fName = in.nextLine();
            PrintWriter fout = new PrintWriter(new File(fName));
            try {
                try {
                    Equations eq = new Equations();
                    out.print("Введіть X: ");
                    double x = in.nextDouble();
                    double result = eq.calculate(x);
                    fout.print(result);
                } finally {
                    fout.flush();
                    fout.close();
                }
            } catch (CalcException ex) {
                out.print(ex.getMessage());
            }
        } catch (FileNotFoundException ex) {
            out.print("Причина виліту: неправильний шлях до файлу");
        }
    }
}