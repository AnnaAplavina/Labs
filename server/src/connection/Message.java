package connection;
import commands.*;

import dragons.Dragon;

import java.io.Serializable;
import java.util.ArrayList;

public class Message implements Serializable {
    private String message;
    private Command command;

    public Message(Command command){
        this.command = command;
    }

    public Message(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }

    public Command getCommand(){
        return command;
    }
}
