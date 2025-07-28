package de.dragonrex.taskflow.core;

import lombok.*;

import java.time.Duration;

@Builder
@Getter
public class Task {
    private Runnable task;
    @Builder.Default
    private Duration after = Duration.ZERO;
    @Builder.Default
    private Duration every = Duration.ZERO;
    private ExecutionType type;
    private String name;
}
