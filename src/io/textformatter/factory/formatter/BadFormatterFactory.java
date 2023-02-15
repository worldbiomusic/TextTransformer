package io.textformatter.factory.formatter;

import io.textformatter.formatter.NormalFormatter;
import io.textformatter.formatter.TextFormatter;
import io.textformatter.formatter.filter.*;

public class BadFormatterFactory implements TextFormatterFactory {
    @Override
    public TextFormatter create(String formatters) {
        TextFormatter f = new NormalFormatter();

        for (int i = formatters.length() - 1; i >= 0; i--) {
            String name = formatters.charAt(i) + "";

            switch (name) {
                case "?":
                    f = new RandomFormatter(f);
                    break;
                case "x":
                    f = new XORFormatter(f);
                    break;
                case "c":
                    f = new CaesarFormatter(f);
                    break;
                case "u":
                    f = new StupidFormatter(f);
                    break;
                case "h":
                    f = new HashFormatter(f);
                    break;
                case "i":
                    f = new InsertFormatter(f);
                    break;
                case "r":
                    f = new ReplaceFormatter(f);
                    break;
                case "m":
                    f = new MoveFormatter(f);
                    break;
                case "v":
                    f = new ReverseFormatter(f);
                    break;
                case "f":
                    f = new FirstFormatter(f);
                    break;
                case "l":
                    f = new LastFormatter(f);
                    break;
                case "j":
                    f = new JoinFormatter(f);
                    break;
                case "t":
                    f = new TimesFormatter(f);
                    break;
                case "d":
                    f = new DeleteFormatter(f);
                    break;
                case "s":
                    f = new ShuffleFormatter(f);
                    break;
                case "$":
                    f = new ValueParserFormatter(f);
                    break;
                case "e":
                    f = new ExpressionFormatter(f);
                    break;
            }
        }

        return f;
    }
}
