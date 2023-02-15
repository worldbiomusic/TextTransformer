package io.textformatter.cmd.parser;

/**
 * Parses a command to extract text, formatter and keys.
 */
public interface CommandParser {
    /**
     * Parses a command.
     *
     * @param cmd the command containing text, formatters and keys
     */
    void parse(String cmd);

    /**
     * Gets text.
     *
     * @return the text
     */
    String text();

    /**
     * Gets formatters.
     *
     * @return the formatters
     */
    String formatters();

    /**
     * Gets keys.
     *
     * @return the keys
     */
    String keys();
}
