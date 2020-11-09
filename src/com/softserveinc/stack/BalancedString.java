package com.softserveinc.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedString {
    public static Map<Character, Character> bracePairs = new HashMap<>();

    static {
        bracePairs.put(')', '(');
        bracePairs.put(']', '[');
        bracePairs.put('}', '{');
    }

    public static void main(String[] args) {
        String src = "({()})";
        System.out.println(src + "is balanced: " + checkString(src, new Stack(), 0));
        src = "((([[{{}}]])))";
        System.out.println(src + "is balanced: " + checkString(src, new Stack(), 0));
        src = "({}({}[])())";
        System.out.println(src + "is balanced: " + checkString(src, new Stack(), 0));
        src = "(({)})";
        System.out.println(src + "is balanced: " + checkString(src, new Stack(), 0));
        src = "[{[)}";
        System.out.println(src + "is balanced: " + checkString(src, new Stack(), 0));
        src = "[";
        System.out.println(src + "is balanced: " + checkString(src, new Stack(), 0));
        src = "[[";
        System.out.println(src + "is balanced: " + checkString(src, new Stack(), 0));
        src = "}}";
        System.out.println(src + "is balanced: " + checkString(src, new Stack(), 0));
    }

    private static boolean checkString(String src, Stack stack, int i) {
        if (src.length() % 2 != 0)
            return false;
        if (i == src.length())
            return true;
        while (i < src.length() && !bracePairs.containsKey(src.charAt(i))) {
            stack.push(src.charAt(i));
            i++;
        }

        if (stack.isEmpty())
            return false;

        if (i < src.length() && bracePairs.get(src.charAt(i)).equals(stack.peek())) {
            stack.pop();
            return checkString(src, stack, ++i);

        } else return false;
    }
}
