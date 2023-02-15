package io.textformatter.formatter.filter;

import io.textformatter.formatter.FilterFormatter;
import io.textformatter.formatter.TextFormatter;

/**
 * Parse things to value like text length only in the keys.
 */
public class ValueParserFormatter extends FilterFormatter {
    public ValueParserFormatter(TextFormatter innerFormatter) {
        super(innerFormatter);
    }

    @Override
    public String format(String text, String key) {
        try {
            key = len(text,key);
            key = keyText(text, key);
        } catch (Exception e) {
//            System.out.println("continue");
        }
        return innerFormatter().format(text, key);
    }

    String len(String text,String key) {
        return key.replace("{len}", text.length() + "");
    }

    String keyText(String text, String key) {
        while (true) {
            int start = key.indexOf("{");
            int end = key.indexOf("}");
            if (start == -1 || end == -1) {
                break;
            }

            String keyText = key.substring(start, end + 1);
            keyText = keyText.replace("{", "").replace("}", "");

            int from = Integer.parseInt(keyText.split(",")[0]);
            int to = Integer.parseInt(keyText.split(",")[1]);

            int len = text.length();
            if (from < 0) {
                from = len + (from % len) + 1;
            }
            if (to < 0) {
                to = len + (to % len) + 1;
            }

            keyText = text.substring(from - 1, to);
            key = key.substring(0, start) + keyText + key.substring(end + 1, key.length());
        }
        return key;
    }

    @Override
    public String name() {
        return "$";
    }
}
