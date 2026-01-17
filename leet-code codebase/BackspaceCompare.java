package week03.gcrcodebase.leetcode;

import java.util.*;

class BackspaceCompare {

    static String build(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!st.isEmpty()) st.pop();
            } else {
                st.push(c);
            }
        }
        return st.toString();
    }

    static boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ad#c";
        System.out.println(backspaceCompare(s, t)); 
    }
}

