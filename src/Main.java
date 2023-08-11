import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        System.out.println("Task1");

       String filePath1 = getUserInput("Enter first file path: ");
       String filePath2 = getUserInput("Enter second file path: ");


       List<String>lines1 = readLinesFromFile(filePath1);
       List<String>lines2 = readLinesFromFile(filePath1);

       List<String> differentLines1 = new ArrayList<>();
       List<String> differentLines2 = new ArrayList<>();

       for(int i = 0; i < Math.min(lines1.size(),lines2.size());i++)
       {
            if(!lines1.get(i).equals(lines2.get(i))){
                differentLines1.add(lines1.get(i));
                differentLines2.add(lines2.get(i));

            }
       }

        System.out.println("Non-matching lines from the first file:");
       for (String line : differentLines1)
       {
           System.out.println(line);
       }
        System.out.println("Non-matching lines from the second file:");
        for (String line : differentLines2)
        {
            System.out.println(line);
        }

    }

    private static String getUserInput(String message)
    {
        System.out.print(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static List<String>readLinesFromFile(String filePath )
    {
        List<String> lines = new ArrayList<>();

        try(BufferedReader reader  = new BufferedReader(new FileReader(filePath))) {

            String line;
            while((line=reader.readLine())!=null)
            {
                lines.add(line);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }
}