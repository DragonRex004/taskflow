package de.dragonrex.taskflow.core;

public interface TaskScheduler {
    void schedule(Task task);
    void shutdown();
}
