package io.textformatter.formatter;

/**
 * Transforms the given text with key and continues with next(inner) formatters.<br>
 * <p>
 * Used for decorator pattern generally.
 */
public abstract class FilterFormatter implements TextFormatter {
    private TextFormatter innerFormatter;

    public FilterFormatter(TextFormatter innerFormatter) {
        this.innerFormatter = innerFormatter;
    }

    /**
     * Returns inner(next) formatter.
     *
     * @return the inner formatter
     */
    public TextFormatter innerFormatter() {
        return this.innerFormatter;
    }
}
