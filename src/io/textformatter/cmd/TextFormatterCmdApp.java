package io.textformatter.cmd;

import io.textformatter.cmd.executor.CommandExecutor;
import io.textformatter.cmd.parser.CommandParser;
import io.textformatter.cmd.parser.NormalCommandParser;
import io.textformatter.factory.formatter.BadFormatterFactory;

import java.util.Scanner;

public class TextFormatterCmdApp {
    private CommandExecutor executor;

    public TextFormatterCmdApp() {
        executor = new CommandExecutor(new NormalCommandParser(), new BadFormatterFactory());
    }

    public static void main(String[] args) {
        new TextFormatterCmdApp().run();
    }

    public void run() {
        System.out.println("[ Text Formatter Cmd App ]");
        Scanner sc = new Scanner(System.in);

        String cmd = "";
        while (true) {
            System.out.print("> ");
            cmd = sc.nextLine();
            String head = cmd.split("\\s")[0];

            if (head.equalsIgnoreCase("format")) {
                format(cmd);
            } else if (head.equalsIgnoreCase("exit")) {
                System.out.println("Bye");
                break;
            } else if (head.equalsIgnoreCase("help")) {
                help();
            } else {
                System.out.println("Wrong command. Type help or following commands.");
                help();
            }
        }
    }

    private void format(String cmd) {
        cmd = cmd.substring("format ".length(), cmd.length());
        String result = this.executor.execute(cmd);

        CommandParser parser = this.executor.getParser();
        String text = parser.text();
        String formatters = parser.formatters();
        String keys = parser.keys();

        System.out.println("\n---------------------------------");
        System.out.println("Text: " + text);
        System.out.println("Formatters: " + formatters);
        System.out.println("Keys: " + keys);
        System.out.println("Result: " + result);
        System.out.println("---------------------------------\n");
    }

    private void help() {
        System.out.println("- format <text>/<formatters>/<keys>: transform the text with keys (key delimiter is \":\") (E.g. \"format abcde/m/2\" will return deabc)");
        System.out.println("- exit: exit the program");
    }

}
