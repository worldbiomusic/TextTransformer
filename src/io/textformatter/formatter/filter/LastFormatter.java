package io.textformatter.formatter.filter;

import io.textformatter.formatter.FilterFormatter;
import io.textformatter.formatter.TextFormatter;

public class LastFormatter extends FilterFormatter {
    public LastFormatter(TextFormatter innerFormatter) {
        super(innerFormatter);
    }

    @Override
    public String format(String text, String key) {
        String last = extractKeyHead(key);
        text += last;
        return innerFormatter().format(text, removeKeyHead(key));
    }

    @Override
    public String name() {
        return "l";
    }
}
