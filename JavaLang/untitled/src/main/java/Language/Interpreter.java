package Language;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Interpreter {
    public ArrayList<String> takeFile() throws FileNotFoundException {
        Scanner path = new Scanner(System.in);
        File file = new File(path.nextLine());
        Scanner scanner = new Scanner(file);
        ArrayList<String> lines = new ArrayList<String>();

        if(file.exists()) {
            while(scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        }

        return lines;
    }
}
