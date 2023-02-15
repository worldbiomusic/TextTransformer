package io.textformatter.formatter;

/**
 * Formatter interface which transform the given text with key.<br>
 * <p>
 * In general, decorator pattern is used to build several formatters at once.
 *
 * @see {@link FilterFormatter}
 */
public interface TextFormatter {
    public static final String DELIMITER = ":";

    /**
     * Transforms the text with the given key.
     *
     * @param text the text
     * @param key  the key
     * @return the result transformed by this formatter with given key.
     */
    String format(String text, String key);

    /**
     * Gets name.
     *
     * @return the name
     */
    String name();

    /**
     * Removes key head. <br>
     * E.g. "a:b:c" -> "b:c"
     *
     * @param key the key which needs to remove a head
     * @return key without head
     */
    default String removeKeyHead(String key) {
        if (!key.contains(DELIMITER)) {
            return "";
        }
        String keyHead = extractKeyHead(key);
        return key.substring(keyHead.length() + 1);
    }

    /**
     * Extracts a key head(first key) from the key.
     *
     * @param key the key needed to extract from
     * @return key head from the key
     */
    default String extractKeyHead(String key) {
        return key.split(DELIMITER)[0];
    }
}
