package io.textformatter.formatter;

/**
 * Normal formatter which do nothing with the given text.
 */
public class NormalFormatter implements TextFormatter {
    @Override
    public String format(String text, String key) {
        return text;
    }

    @Override
    public String name() {
        return "n";
    }
}
