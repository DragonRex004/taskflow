package de.dragonrex.taskflow.impl;

import de.dragonrex.taskflow.core.Task;
import de.dragonrex.taskflow.core.TaskScheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DefaultTaskSchedular implements TaskScheduler {
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    @Override
    public void schedule(Task task) {
        switch (task.getType()) {
            case ONCE ->this.executor.schedule(() -> {
                            task.getTask().run();
                            this.shutdown();
                        },
                        task.getAfter().getSeconds(),
                        TimeUnit.SECONDS
            );
            case REPEAT -> this.executor.scheduleWithFixedDelay(
                    task.getTask(),
                    task.getAfter().toSeconds(),
                    task.getEvery().getSeconds(),
                    TimeUnit.SECONDS
            );
        }
    }

    @Override
    public void shutdown() {
        this.executor.shutdown();
    }
}
