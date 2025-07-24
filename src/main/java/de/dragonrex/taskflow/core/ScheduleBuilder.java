package de.dragonrex.taskflow.core;

import java.time.Duration;

public class ScheduleBuilder {
    private Task task;

    public ScheduleBuilder() {
        this.task = new Task();
    }

    public ScheduleBuilder after(Duration duration) {
        this.task.setInitialDelay(duration);
        return this;
    }
    public ScheduleBuilder every(Duration duration) {
        this.task.setInterval(duration);
        return this;
    }
    public ScheduleBuilder type(ExecutionType type) {
        this.task.setType(type);
        return this;
    }
    public ScheduleBuilder name(String name) {
        this.task.setName(name);
        return this;
    }
    public ScheduleBuilder run(Runnable task) {
        this.task.setTask(task);
        return this;
    }

    public Task task() {
        return this.task;
    }
}
