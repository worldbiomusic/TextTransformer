package io.textformatter.formatter.filter;

import io.textformatter.formatter.FilterFormatter;
import io.textformatter.formatter.TextFormatter;

public class FirstFormatter extends FilterFormatter {
    public FirstFormatter(TextFormatter innerFormatter) {
        super(innerFormatter);
    }

    @Override
    public String format(String text, String key) {
        String head = extractKeyHead(key);
        text = head + text;
        return innerFormatter().format(text, removeKeyHead(key));
    }

    @Override
    public String name() {
        return "f";
    }
}
