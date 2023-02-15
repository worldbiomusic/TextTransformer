package io.textformatter.formatter.filter;

import io.textformatter.formatter.FilterFormatter;
import io.textformatter.formatter.TextFormatter;

public class JoinFormatter extends FilterFormatter {
    public JoinFormatter(TextFormatter innerFormatter) {
        super(innerFormatter);
    }

    @Override
    public String format(String text, String key) {
        String letter = extractKeyHead(key);

        StringBuffer newText = new StringBuffer(text);
        for (int i = text.length() - 1; i > 0; i--) {
            newText.insert(i, letter);
        }
        return innerFormatter().format(newText.toString(), removeKeyHead(key));
    }

    @Override
    public String name() {
        return "j";
    }
}
