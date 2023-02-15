package io.textformatter.formatter.filter;

import io.textformatter.formatter.FilterFormatter;
import io.textformatter.formatter.TextFormatter;

public class MoveFormatter extends FilterFormatter {
    public MoveFormatter(TextFormatter innerFormatter) {
        super(innerFormatter);
    }

    @Override
    public String format(String text, String key) {
        int diff = Integer.parseInt(extractKeyHead(key));

        if (diff > 0) {
            for (int i = diff; i > 0; i--) {
                text = rightShift(text);
            }
        } else {
            for (int i = diff; i < 0; i++) {
                text = leftShift(text);
            }
        }
        return innerFormatter().format(text, removeKeyHead(key));
    }

    private String rightShift(String s) {
        return s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);
    }

    private String leftShift(String s) {
        return s.substring(1, s.length()) + s.charAt(0);
    }

    @Override
    public String name() {
        return "m";
    }
}
