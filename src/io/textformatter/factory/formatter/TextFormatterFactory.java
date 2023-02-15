package io.textformatter.factory.formatter;

import io.textformatter.formatter.TextFormatter;

public interface TextFormatterFactory {
    TextFormatter create(String formatters);
}
