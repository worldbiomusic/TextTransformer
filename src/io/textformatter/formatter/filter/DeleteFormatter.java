package io.textformatter.formatter.filter;

import io.textformatter.formatter.FilterFormatter;
import io.textformatter.formatter.TextFormatter;

public class DeleteFormatter extends FilterFormatter {
    public DeleteFormatter(TextFormatter innerFormatter) {
        super(innerFormatter);
    }

    @Override
    public String format(String text, String key) {
        // key format: <start>,<end> (remove 1 to 3 letters)
        String deleteKey = extractKeyHead(key);
        int start = Integer.parseInt(deleteKey.split(",")[0]);
        int end = Integer.parseInt(deleteKey.split(",")[1]);

        int len = text.length();
        if (start < 0) {
            start = len + (start % len) + 1;
        }
        if (end < 0) {
            end = len + (end % len) + 1;
        }

        // abcde
        text = new StringBuffer(text).delete(start - 1, end).toString();
        return innerFormatter().format(text, removeKeyHead(key));
    }

    @Override
    public String name() {
        return "d";
    }
}
