package io.textformatter.cmd.executor;

import io.textformatter.cmd.parser.CommandParser;
import io.textformatter.factory.formatter.TextFormatterFactory;

/**
 * Executes a command with registered {@link CommandParser} and {@link TextFormatterFactory}.
 */
public class CommandExecutor {
    private CommandParser parser;
    private TextFormatterFactory factory;

    public CommandExecutor(CommandParser parser, TextFormatterFactory factory) {
        this.parser = parser;
        this.factory = factory;
    }

    /**
     * Executes a command and return result.
     *
     * @param cmd the command to be executed
     * @return the result transformed by the formatters
     */
    public String execute(String cmd) {
        this.parser.parse(cmd);
        String text = this.parser.text();
        String formatters = this.parser.formatters();
        String keys = this.parser.keys();

        return factory.create(formatters).format(text, keys);
    }

    public CommandParser getParser() {
        return parser;
    }

    public TextFormatterFactory getFactory() {
        return factory;
    }
}
