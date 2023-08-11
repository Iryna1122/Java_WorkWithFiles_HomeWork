import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

//  Користувач з клавіатури вводить шлях до файлу. Програма повинна знайти довжину самого довгого рядка.
//  Після роботи програми на екран відображається отримане число і сам рядок.

        String filePath = getInput("Enter path: ");

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {


        String longestLine ="";
        int maxLen = 0;

        String line;

        while((line = reader.readLine())!=null)
        {
            int currentLen = line.length();

            if(currentLen>maxLen)
            {
                maxLen=currentLen;
                longestLine = line;
            }
        }
            System.out.println("Longest line length: " + maxLen);
            System.out.println("Longest line: " + longestLine);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String getInput(String message)
    {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
