package commands;

import java.io.Serializable;

public interface Command {
    String getName();
    boolean checkArguments();
}
