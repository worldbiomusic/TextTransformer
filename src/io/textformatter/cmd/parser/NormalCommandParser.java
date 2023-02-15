package io.textformatter.cmd.parser;

/**
 * A normal parser which parses command with "/" delimiter.
 * <p>
 * Input format: [text] / [formatters] / [keys]
 */
public class NormalCommandParser implements CommandParser {
    private String text;
    private String formatters;
    private String keys;

    public NormalCommandParser() {
        this.text = this.formatters = this.keys = "";
    }

    @Override
    public void parse(String cmd) {
        String delimiter = "/";
        String[] cmds = cmd.split(delimiter);
        this.text = cmds[0];
        this.formatters = cmds[1];
        this.keys = cmds.length == 2 ? "" : cmds[2];
    }

    @Override
    public String text() {
        return text;
    }

    @Override
    public String formatters() {
        return formatters;
    }

    @Override
    public String keys() {
        return keys;
    }
}
