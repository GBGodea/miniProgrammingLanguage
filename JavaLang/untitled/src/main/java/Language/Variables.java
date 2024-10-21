package Language;

import javax.management.BadBinaryOpValueExpException;
import java.util.*;

public class Variables {
    Integer nums;
    String str;
    Boolean bool;
    String[] arr;
    static Map<String, Object> dictionary = new HashMap<String, Object>();

    void checkType(String command) throws Exception {
        command = command.replaceAll(" ", "").replaceAll("]", "").replaceAll("\\[", "");
        String[] splited = command.split("=");

        try {
            String result = splited[1];
            if(result.equals("true") || result.equals("false")) {
                bool = Boolean.parseBoolean(result);
                dictionary.put(splited[0], result);
            } else if(result.matches("^[a-zA-Z]*$") && !result.contains("[") && !result.contains("]")) {
                str = result;
                dictionary.put(splited[0], result);
            } else if(result.matches("-?\\d+(.\\d+)?")) {
                nums = Integer.parseInt(result);
                dictionary.put(splited[0], nums);
            } else if(result.contains("[") && result.contains("]")) {
                result = result.replace('[', '\u0000').replace(']', '\u0000').trim();
                String[] splitForArr = result.split(",");
                arr = new String[splitForArr.length];
                System.arraycopy(splitForArr, 0, arr, 0, splitForArr.length);
                dictionary.put(splited[0], result);
            }
        } catch (IndexOutOfBoundsException out) {
            throw new Exception("You must enter the values after the = sign");
        }
    }

    void checkValue(String command) {
        int startIndex = 0;
        int endIndex = 0;
        for(int i = 0; i < command.length(); i++) {
            if(command.charAt(i) == '(') {
                startIndex = i + 1;
            } else if(command.charAt(i) == ')') {
                endIndex = i;
                break;
            }
        }
        command = command.substring(startIndex, endIndex);
        System.out.println(dictionary.get(command));
    }

    Object getValueFromPlus(String command) {
        command = command.replaceAll("=", "+").replaceAll(" ", "");
        String[] values = command.split("[+]");

        Object resultVariable = null;
        String firstVariable = dictionary.get(values[1]).toString();
        String secondVariable = dictionary.get(values[2]).toString();

        if(dictionary.get(values[1]).getClass().equals(String.class) || dictionary.get(values[2]).getClass().equals(String.class)) {
            resultVariable = firstVariable + secondVariable;
        } else {
            resultVariable = Integer.parseInt(firstVariable) + Integer.parseInt(secondVariable);
        }

        dictionary.put(values[0], resultVariable);
        return resultVariable;
    }

    Integer getValueFromMinus(String command) throws Exception {
        command = command.replaceAll("=", "-").replaceAll(" ", "");
        String[] values = command.split("-");

        Integer resultVariable = null;

        try {
            Integer firstVariable = (Integer) dictionary.get(values[1]);
            Integer secondVariable = (Integer) dictionary.get(values[2]);
            resultVariable = firstVariable - secondVariable;
        } catch(Exception e) {
            throw new Exception(e.getMessage(), e);
        }

        dictionary.put(values[0], resultVariable);
        return resultVariable;
    }

}
