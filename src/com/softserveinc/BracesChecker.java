package com.softserveinc;

import java.util.*;

public class BracesChecker {
    public static Map<Character, Character> bracePairs = new HashMap<>();
    static {
        bracePairs.put(')', '(');
        bracePairs.put(']', '[');
        bracePairs.put('}', '{');
    }

    public static void main(String[] args) {

        String src = "({()})";
        System.out.println("src = " + src + "\nCheck result: " + check(src));
        src = "((([[{{}}]])))";
        System.out.println("src = " + src + "\nCheck result: " + check(src));
        src = "({}({}[])())";
        System.out.println("src = " + src + "\nCheck result: " + check(src));
        src = "(({)})";
        System.out.println("src = " + src + "\nCheck result: " + check(src));
        src = "[{[)}";
        System.out.println("src = " + src + "\nCheck result: " + check(src));
        src = "}}";
        System.out.println("src = " + src + "\nCheck result: " + check(src));
        src = "[[";
        System.out.println("src = " + src + "\nCheck result: " + check(src));
        src = "(";
        System.out.println("src = " + src + "\nCheck result: " + check(src));
    }

    public static boolean check(String src) {
        if (src.isEmpty())
            return true;
        if (src.length() % 2 != 0)
            return false;
        int endIndex = 1;
        Character next = src.charAt(endIndex);
        while (!bracePairs.containsKey(next) && endIndex < src.length() - 1) {
            endIndex++;
            next = src.charAt(endIndex);
        }
        Character current = src.charAt(endIndex - 1);
        if (current.equals(bracePairs.get(next))) {
            StringBuilder sub = new StringBuilder(src);
            // remove handled pair
            sub.replace(endIndex - 1, endIndex + 1, "");
            return check(sub.toString());
        } else return false;

    }
}
