package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.util.concurrent.Callable;

@Command(name = "getDiff", mixinStandardHelpOptions = true, version = "getDiff 1.0",
        description = "Compares two configuration files and shows a difference.")

public class App implements Callable<Integer> {

    private final Integer errorCase = 111;

    @Parameters(index = "0", description = "path to the first file")
    private String firstFilePath;

    @Parameters(index = "1", description = "path to the second file")
    private String secondFilePath;

    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
    private boolean usageHelpRequested;

    @Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version information and exit.")
    private boolean versionInfoRequested;

    @Option(names = {"-f", "--format"}, defaultValue = "stylish",
            description = "output format [default: stylish]")
    private String format;

    @Override
    public final Integer call() throws Exception {
        try {
            System.out.println(Differ.generate(firstFilePath, secondFilePath, format));
            return 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return errorCase;
        }
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}