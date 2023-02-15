package io.textformatter.formatter.filter;


import io.textformatter.formatter.FilterFormatter;
import io.textformatter.formatter.TextFormatter;

public class StupidFormatter extends FilterFormatter {

    public StupidFormatter(TextFormatter innerFormatter) {
        super(innerFormatter);
    }

    @Override
    public String format(String text, String key) {
        String newText = "";
        for (int i = 0; i < text.length(); i++) {
            String c = text.charAt(i) + "";
            double r = Math.random();

            if (r < 0.5) {
                newText += c.toUpperCase();
            } else {
                newText += c.toLowerCase();
            }
        }

        return innerFormatter().format(newText, key);
    }

    @Override
    public String name() {
        return "u";
    }
}
