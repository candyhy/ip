package duke.ui;

import duke.duke.Duke;
import duke.tasks.Task;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

public class Ui {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void showWelcomeMessage(Duke bot) {
        pw.printf("Hello from%n%s%n", bot.getLogo());
        pw.println("Hello! I'm Duke");
        pw.println("What can I do for you?");

        for (int i = 0; i < 50; i++) {
            pw.print('\u2500');
        }
        pw.println();
        pw.flush();
    }

    public static void askForUserRequest() {
        pw.println("Anything else?");
        pw.flush();
    }

    public static void showTasksToUser(List<Task> list) {
        for (int i = 0; i < list.size(); i++) {
            pw.printf("%d.%s%n", i + 1, list.get(i));
        }
        pw.flush();
    }

    public static void printEmptyLine() {
        pw.println();
        pw.flush();
    }

    public static void showAddTaskMessage(Task task, List<Task> list) {
        pw.println("Got it. I've added this task:");
        pw.printf(" %s%n", task);
        pw.printf("Now you have %d tasks in the list.%n", list.size());
        pw.flush();
    }

    public static void showRemoveTaskMessage(Task task, List<Task> list) {
        pw.println("Noted. I've removed this task:");
        pw.printf(" %s%n", task);
        pw.printf("Now you have %d tasks in the list.%n", list.size());
        pw.flush();
    }

    public static void showDoneTaskMessage(List<Task> list, int id) {
        pw.println("Nice! I've marked this task as done:");
        pw.printf(" %s%n", list.get(id));
        pw.flush();
    }

    public static void showExitMessage() {
        pw.println("Bye. Hope to see you again soon!");
        pw.flush();
        pw.close();
    }

    public static void print(String message) {
        pw.println(message);
        pw.flush();
    }

    public static String readUserInput() throws IOException {
        return br.readLine();
    }
}
