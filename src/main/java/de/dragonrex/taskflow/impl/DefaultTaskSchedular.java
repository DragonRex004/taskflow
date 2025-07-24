package de.dragonrex.taskflow.impl;

import de.dragonrex.taskflow.core.ScheduleBuilder;
import de.dragonrex.taskflow.core.TaskScheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DefaultTaskSchedular implements TaskScheduler {
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    @Override
    public void schedule(ScheduleBuilder builder) {
        switch (builder.task().getType()) {
            case ONCE: {
                this.executor.schedule(() -> {
                            builder.task().getTask().run();
                            this.shutdown();
                        },
                        builder.task().getInitialDelay().getSeconds(),
                        TimeUnit.SECONDS
                );
            }
            case REPEAT: {
                this.executor.scheduleWithFixedDelay(
                        builder.task().getTask(),
                        builder.task().getInitialDelay().toSeconds(),
                        builder.task().getInterval().getSeconds(),
                        TimeUnit.SECONDS
                );
            }
        }
    }

    @Override
    public void shutdown() {
        this.executor.shutdown();
    }
}
