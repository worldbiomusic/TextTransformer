package io.textformatter.formatter.filter;

import io.textformatter.formatter.FilterFormatter;
import io.textformatter.formatter.TextFormatter;

public class ReplaceFormatter extends FilterFormatter {
    public ReplaceFormatter(TextFormatter innerFormatter) {
        super(innerFormatter);
    }

    @Override
    public String format(String text, String key) {
        String replaceKey = extractKeyHead(key);
        String[] keys = replaceKey.split(">");
        if (keys.length != 0) {
            String oldString = keys[0];
            String newString = (keys.length == 2) ? keys[1] : "";
            text = text.replace(oldString, newString);
        }
        return innerFormatter().format(text, removeKeyHead(key));
    }

    @Override
    public String name() {
        return "r";
    }

    public static void main(String[] args) {
        // 1> = 1 (1)
        // >1 = 2 (,1)
        String s = ">a";
        System.out.println(s.split(">").length);
        System.out.println("1" + s.split(">")[0]);
        System.out.println("2" + s.split(">")[1]);
    }
}
