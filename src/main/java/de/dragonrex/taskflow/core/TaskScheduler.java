package de.dragonrex.taskflow.core;

public interface TaskScheduler {
    void schedule(ScheduleBuilder builder);
    void shutdown();
}
