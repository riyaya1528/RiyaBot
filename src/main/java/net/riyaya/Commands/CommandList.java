package net.riyaya.Commands;

import java.util.ArrayList;

public class CommandList {
    private ArrayList<Command> commandArrayList;

    public void addCommand(Command command) {
        commandArrayList.add(command);
    }

    public ArrayList<Command> getCommandList() {
        return commandArrayList;
    }
}
