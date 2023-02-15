package io.textformatter.formatter.filter;

import io.textformatter.formatter.FilterFormatter;
import io.textformatter.formatter.TextFormatter;

public class RandomFormatter extends FilterFormatter {
    public RandomFormatter(TextFormatter innerFormatter) {
        super(innerFormatter);
    }

    @Override
    public String format(String text, String key) {
        String newText = "";
        for (int i = 0; i < text.length(); i++) {
            String c = "" + text.charAt(i);

            if (c.isBlank()) {
                // blank
                newText += " ";
            } else if (c.matches("-?\\d+")) {
                // number
                newText += -9 + (int) (Math.random() * 20);
            } else {
                // alphabet
                newText += randomLetter();
            }
        }

        return innerFormatter().format(newText, key);
    }

    @Override
    public String name() {
        return "?";
    }

    String randomLetter() {
        double d = Math.random();
        int r = (int) (Math.random() * 26);
        if (d < 0.5) {
            return "" + (char) ('a' + r);
        } else {
            return "" + (char) ('A' + r);
        }
    }

}
