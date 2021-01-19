import java.io.*;

public class Duke {
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    String logo;
    Tasklist list;
    public Duke(){
        this.logo =
                " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        this.list = new Tasklist();

    }

    public void greet() {
        pw.printf("Hello from%n%s%n", logo);
        pw.println("Hello! I'm Duke");
        pw.println("What can I do for you?");
        pw.flush();
    }

    public void addTask(String message, String type, String date) {
        Task task = null;
        switch (type) {
            case "todo":
                task = new Todo(message);
                break;
            case "deadline":
                task = new Deadline(message, date);
                break;
            case "event":
                task = new Event(message, date);
                break;
        }

        list.addItem(task);
        pw.println("Got it. I've added this task:");
        pw.printf(" %s%n", task);
        pw.printf("Now you have %d tasks in the list.%n", list.lst.size());
        pw.flush();
    }

    public void removeTask(String id) {
        int n = Integer.parseInt(id) - 1;
        pw.println("Noted. I've removed this task:");
        pw.printf(" %s%n", list.lst.get(n));
        pw.printf("Now you have %d tasks in the list.%n", list.lst.size());
        pw.flush();
        list.removeItem(n);
    }

    public void exit() {
        pw.println("Bye. Hope to see you again soon!");
        pw.flush();
    }
}
