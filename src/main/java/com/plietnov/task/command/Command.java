package com.plietnov.task.command;

public abstract class Command {

    public abstract void execute();

    @Override
    public final String toString() {
        return getClass().getSimpleName();
    }
}
