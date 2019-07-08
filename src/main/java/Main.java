import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    // DO NOT MODIFY THIS CLASS!
    public static void main(String[] args) {
        Stream.of(
            // You may add more listeners if you would like once all tests are passing
            new EventListener("apple", "I love macbooks"),
            new EventListener("java", "I could go for some coffee"),
                new EventListener("event", "listener"),
                new EventListener("zipcode", "_     /)---(\\          /~~~\\\n" +
                        "\\\\   (/ . . \\)        /  .. \\\n" +
                        " \\\\__)-\\(*)/         (_,\\  |_)\n" +
                        " \\_       (_         /   \\@/    /^^^\\\n" +
                        " (___/-(____) _     /      \\   / . . \\\n" +
                        "              \\\\   /  `    |   V\\ Y /V\n" +
                        "               \\\\/  \\   | _\\    / - \\\n" +
                        "                \\   /__'|| \\\\_  |    \\\n" +
                        "                 \\_____)|_).\\_).||(__V")


        ).forEach(Thread::start);

        System.out.println("Start typing messages to the console now. Enter \"quit\" to exit the program");
        Stream<String> inStream = Stream.generate(new Scanner(System.in)::nextLine);

        boolean status = inStream.anyMatch(Main::passValue);
    }

    private static boolean passValue(String input) {
        EventTracker.getInstance().push(input);
        return input.equals("quit");
    }

}
