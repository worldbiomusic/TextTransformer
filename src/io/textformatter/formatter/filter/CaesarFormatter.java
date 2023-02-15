package io.textformatter.formatter.filter;

import io.textformatter.formatter.FilterFormatter;
import io.textformatter.formatter.TextFormatter;
import io.textformatter.util.Utils;;

public class CaesarFormatter extends FilterFormatter {
    public CaesarFormatter(TextFormatter innerFormatter) {
        super(innerFormatter);
    }

    @Override
    public String format(String text, String key) {
        int diff = Integer.parseInt(extractKeyHead(key));
        String newText = "";

        for (int i = 0; i < text.length(); i++) {
            String c = text.charAt(i) + "";
            if (Utils.isAlphabet(c)) {
                newText += moveLetter(c, diff);
            } else if (Utils.isNumeric(c)) {
                int n = Integer.parseInt(c);
                newText += moveNumber(n, diff);
            } else {
                newText += c;
            }
        }

        return innerFormatter().format(newText, removeKeyHead(key));
    }

    String moveLetter(String text, int diff) {
        if (diff < 0) {
            diff = 26 - Math.abs(diff % 26);
        }

        int c = text.charAt(0);
        int base = 0;
        if ('a' <= c && c <= 'z') {
            base = 'a';
        } else if ('A' <= c && c <= 'Z') {
            base = 'A';
        } else {
            return text;
        }

        c -= base;
        c = (c + diff) % 26;
        c += base;

        return (char) c + "";
    }

    /*
    n= 5
    diff=-11
    diff=
     */
    /*
    only one number
     */
    int moveNumber(int n, int diff) {
        if (diff < 0) {
            diff = 10 - Math.abs(diff % 10);
        }

        return (n + diff) % 10;
    }

    @Override
    public String name() {
        return "c";
    }

    public static void main(String[] args) {
        System.out.println("a: " + (int) 'a');
        String s = "eqogdufk";
        String newS = "";
        for (int i = 0; i < 1; i++) {
            int c = s.charAt(i);
            int newC = (c - 'a' + i) % 26 + 'a';
            System.out.print((char) newC);
        }
    }
}
