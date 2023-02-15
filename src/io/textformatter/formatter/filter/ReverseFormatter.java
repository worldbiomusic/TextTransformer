package io.textformatter.formatter.filter;

import io.textformatter.formatter.FilterFormatter;
import io.textformatter.formatter.TextFormatter;

public class ReverseFormatter extends FilterFormatter {
    public ReverseFormatter(TextFormatter innerFormatter) {
        super(innerFormatter);
    }

    @Override
    public String format(String text, String key) {
        text = new StringBuffer(text).reverse().toString();
        return innerFormatter().format(text, key);
    }

    @Override
    public String name() {
        return "v";
    }
}
