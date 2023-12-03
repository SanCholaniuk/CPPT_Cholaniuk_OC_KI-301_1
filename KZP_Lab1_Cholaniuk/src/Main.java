import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        int numRows;
        char Arr[][];
        String filler;
        Scanner in = new Scanner(System.in);
        File dataFile = new File("MyFile.txt");
        PrintWriter fout = new PrintWriter(dataFile);

        System.out.print("Введіть розмір квадратної матриці: ");
        numRows = in.nextInt();
        in.nextLine();

        Arr = new char[numRows][numRows];

        System.out.print("Введіть символ-заповнювач: ");
        String fillerStr = in.nextLine();
        exit:

        for(int i = 0; i < numRows; i++)
        {
            for(int j = 0; j < numRows; j++)
            {
                if (fillerStr.length() == 1)
                {

                    if (i >= j && i + j >= numRows - 1)
                    {
                        Arr[i][j] = fillerStr.charAt(j % fillerStr.length());
                    }
                    else
                    {
                        Arr[i][j] = ' ';
                    }
                }
                else if (fillerStr.length() == 0)
                {
                    System.out.print("\nНе введено символ заповнювач");
                    break exit;

                }
                System.out.print(Arr[i][j]);
                fout.print(Arr[i][j]);
            }
            System.out.print("\n");
            fout.print("\n");
        }


        fout.flush();
        fout.close();


    }

}