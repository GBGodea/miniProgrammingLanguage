package Language;

import java.util.*;

public class Methods {
    Variables variable = new Variables();
    static Map<String, String[]> dictionary = new HashMap<>();

    public void createMethod(String command) {
        int Index = 0;
        int endIndex = command.length();

        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == '@') {
                Index = i + 1;
                break;
            }
        }

        String nameCommand = command.substring(0, Index - 1);
        command = command.substring(Index, endIndex);

        String[] arr;
        if (!command.contains("\n")) {
            arr = command.split("/");
        } else {
            arr = command.split("\n");
        }


        dictionary.put(nameCommand, arr);


//        methods.addAll(Arrays.asList(arr));
    }

    public void executeMethod(String command) throws Exception {
        command = command.replaceAll("exec", "").replaceAll(" ", "");
//        for (int i = 0; i < dictionary.size(); i++) {
//            if(command.equals(dictionary.getKey(i))) {
//                variable.checkType(Arrays.toString(dictionary.get(i)));
//            }
//        }

        for (String key : dictionary.keySet()) {
            if (command.equals(key)) {
                String[] str = dictionary.get(key);
                for (String s : str) {
                    variable.checkType(s);
                }
            }
        }
    }
}
