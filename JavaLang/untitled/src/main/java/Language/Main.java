package Language;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {
        Variables var = new Variables();
        Interpreter interpreter = new Interpreter();
        Methods methods = new Methods();
        Scanner scanner = new Scanner(System.in); // Можно также попробовать ему скормить файл
        String command = scanner.nextLine();

        while (!command.equals("exit")) {
            if (command.contains("=") && !command.contains("+")
                    && !command.contains("-") && !command.contains("exec")
                    && !command.contains("@")) {
                var.checkType(command);
            } else if (command.contains("valOf")) {
                var.checkValue(command);
            } else if (command.contains("+")) {
                var.getValueFromPlus(command).toString();
            } else if (command.contains("-")) {
                var.getValueFromMinus(command);
            } else if (command.equals("execute")) {
                ArrayList<String> commands = interpreter.takeFile();
                for (String line : commands) {
                    if (line.contains("=") && !line.contains("+") && !line.contains("-")) {
                        var.checkType(line);
                    } else if (line.contains("valOf")) {
                        var.checkValue(line);
                    } else if (line.contains("+")) {
                        var.getValueFromPlus(line).toString();
                    } else if (line.contains("-")) {
                        var.getValueFromMinus(command);
                    }
                }
            } else if (command.contains("@")) {
                methods.createMethod(command);
            } else if(command.contains("exec")) {
                methods.executeMethod(command);
            } else {
                throw new Exception("Команда введена неверно!");
            }
            command = scanner.nextLine();
        }
    }
}
