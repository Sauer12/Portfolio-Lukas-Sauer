package sk.lukassauer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private static String tasks = """
            Infrastructure, Security, High, In Progress
            Infrastructure, Loggings, Medium
            Data Design, Encryption Policy, High
            Data Access, Set Up Users, Low
            """;

    private static String lukasTasks = """
            Infrastructure, Security, High, In Progress
            Data Design, Write Views, Medium, In Progress
            Data Access, Set Up Users, Low, In Progress
            """;

    private static String karolTasks = """
            Infrastructure, Loggings, Medium, In Progress
            Data Design, Encryption Policy, High
            Data Access, Set Up Users, Low
            """;

    private static String zuzkaTasks = """
            Infrastructure, Loggings, Medium
            Data Design, Databases, High, In Progress
            Data Access, Set Up Users, Low, In Progress
            """;

    public static Set<Task> getTasks(String owner){
        Set<Task> taskList = new HashSet<>();
        String user = ("lukas,karol,zuzka".contains(owner.toLowerCase())) ? owner : null;

        String selectedList = switch (owner.toLowerCase()){
            case "lukas" -> lukasTasks;
            case "karol" -> karolTasks;
            case "zuzka" -> zuzkaTasks;
            default -> tasks;
        };

        for(String taskData : selectedList.split("\n")){
            String[] data = taskData.split(",");
            Arrays.asList(data).replaceAll(String::trim);

            Status status = (data.length <= 3 ? Status.IN_QUEUE :
                    Status.valueOf(data[3].toUpperCase()
                            .replace(" ", "_")));

            Priority priority = Priority.valueOf(data[2].toUpperCase());
            taskList.add(new Task(data[0], data[1], user, priority, status));
        }

        return taskList;
    }
}
