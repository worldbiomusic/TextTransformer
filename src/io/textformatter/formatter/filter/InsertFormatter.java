package io.textformatter.formatter.filter;

import io.textformatter.formatter.FilterFormatter;
import io.textformatter.formatter.TextFormatter;

public class InsertFormatter extends FilterFormatter {
    public InsertFormatter(TextFormatter innerFormatter) {
        super(innerFormatter);
    }

    @Override
    public String format(String text, String key) {
        // key format: <index>,<letter>
        final String insertionDelimiter = ",";
        String insertionLetters = extractKeyHead(key);
        int index = Integer.parseInt(insertionLetters.split(insertionDelimiter)[0]);
        String letter = insertionLetters.split(insertionDelimiter)[1];

        text = new StringBuffer(text).insert(index, letter).toString();
//        text = text.substring(0, index) + letter + text.substring(index);
        return innerFormatter().format(text, removeKeyHead(key));
    }

    @Override
    public String name() {
        return "i";
    }
}
