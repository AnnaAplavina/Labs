package commands;

public interface Command {
    String getName();
    boolean checkArguments();
}
