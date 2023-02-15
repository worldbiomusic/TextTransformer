package io.textformatter.factory.cmd;

import io.textformatter.cmd.executor.CommandExecutor;

public interface CommandExecutorFactory {
    CommandExecutor create();
}
