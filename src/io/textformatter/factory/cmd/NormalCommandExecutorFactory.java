package io.textformatter.factory.cmd;

import io.textformatter.cmd.executor.CommandExecutor;
import io.textformatter.cmd.parser.NormalCommandParser;
import io.textformatter.factory.formatter.BadFormatterFactory;

public class NormalCommandExecutorFactory implements CommandExecutorFactory {
    @Override
    public CommandExecutor create() {
        return new CommandExecutor(new NormalCommandParser(), new BadFormatterFactory());
    }
}
