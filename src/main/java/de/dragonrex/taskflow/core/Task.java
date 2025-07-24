package de.dragonrex.taskflow.core;

import java.time.Duration;

public class Task {
    private Runnable task = () -> {};
    private Duration initialDelay = Duration.ZERO;
    private Duration interval = Duration.ofSeconds(5);
    private ExecutionType type = ExecutionType.ONCE;
    private String name = "taskFlow-1";

    public Task() {}

    public void setTask(Runnable task) {
        this.task = task;
    }

    public Runnable getTask() {
        return task;
    }

    public void setInitialDelay(Duration initialDelay) {
        this.initialDelay = initialDelay;
    }

    public Duration getInitialDelay() {
        return initialDelay;
    }

    public void setInterval(Duration interval) {
        this.interval = interval;
    }

    public Duration getInterval() {
        return interval;
    }

    public void setType(ExecutionType type) {
        this.type = type;
    }

    public ExecutionType getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
