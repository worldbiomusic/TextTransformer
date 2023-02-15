package io.textformatter.formatter.filter;

import io.textformatter.formatter.FilterFormatter;
import io.textformatter.formatter.TextFormatter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShuffleFormatter extends FilterFormatter {
    public ShuffleFormatter(TextFormatter innerFormatter) {
        super(innerFormatter);
    }

    @Override
    public String format(String text, String key) {
        List<String> letters = Arrays.asList(text.split(""));
        Collections.shuffle(letters);
        return innerFormatter().format(String.join("", letters), key);
    }

    @Override
    public String name() {
        return "s";
    }
}
