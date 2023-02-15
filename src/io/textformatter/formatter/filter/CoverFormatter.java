package io.textformatter.formatter.filter;

import io.textformatter.formatter.FilterFormatter;
import io.textformatter.formatter.TextFormatter;

public class CoverFormatter extends FilterFormatter {
    public CoverFormatter(TextFormatter innerFormatter) {
        super(innerFormatter);
    }

    @Override
    public String format(String text, String key) {
        String newText = "";
        for (int i = 0; i < text.length(); i++) {
            String c = text.charAt(i) + "";

            newText += "||" + c + "||";
        }

        return innerFormatter().format(newText, key);
    }

    @Override
    public String name() {
        return "v";
    }
}
