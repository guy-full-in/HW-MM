package ru.kpfu.it;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ayrat on 31.03.2014.
 */
public class Validator {
    public static boolean validArg(String arg){
        Pattern pattern = Pattern.compile("\\-?[0-9]{1,13}(\\.[0-9]*)?");
        Matcher matcher = pattern.matcher(arg);
        if(matcher.matches()){
            return true;
        }
        return false;
    }

    public static String getError(String oper, String arg1, String arg2){
        Pattern pattern = Pattern.compile("(sin|cos|ln|exp|add|sub|mult|div)");
        Matcher matcher = pattern.matcher(oper);
        if (!matcher.matches()) {
            return "Wrong type of operation";
        }
        switch (oper){
            case "sin":
            case "cos":
            case "exp":
            case "ln":
                if (arg1 == null || arg1.equals("")){
                    return oper + " must have arg";
                }
                if (!validArg(arg1)){
                    return "Not valid first arg";
                }
                if (arg2 != null && !arg2.equals("")){
                    return oper + " must have one arg";
                }
                if (oper.equals("ln") && Double.parseDouble(arg1) <= 0){
                    return oper + " must have positive arg";
                }
                break;
            case "add":
            case "mult":
            case "sub":
            case "div":
                if ((arg1 == null || arg1.equals("")) || (arg2 == null || arg2.equals(""))){
                    return oper + " must have two args";
                }
                if (!validArg(arg1)){
                    return "Not valid first arg";
                }
                if (!validArg(arg2)){
                    return "Not valid second arg";
                }
                if (oper.equals("div") && Double.parseDouble(arg2) == 0){
                    return "Second arg of " + oper + " must be not null";
                }
                break;
        }
        return null;
    }

    public static int getNumberOfArgs(String oper){
        switch (oper){
            case "sin":
            case "cos":
            case "exp":
            case "ln":
                return 1;
            case "add":
            case "mult":
            case "sub":
            case "div":
                return 2;
        }
        return 0;
    }
}
