package test.taskflow;

import de.dragonrex.taskflow.core.ExecutionType;
import de.dragonrex.taskflow.core.Task;
import de.dragonrex.taskflow.core.TaskScheduler;
import de.dragonrex.taskflow.impl.DefaultTaskSchedular;

import java.time.Duration;

public class DelayedTaskTest {
    public static void main(String[] args) {
        TaskScheduler scheduler = new DefaultTaskSchedular();

        System.out.println("Starting DelayedTaskTest...");
        scheduler.schedule(
                Task.builder()
                        .name("DelayedTaskTest")
                        .type(ExecutionType.ONCE)
                        .after(Duration.ofSeconds(10))
                        .task(() -> {
                            System.out.println("DelayedTask Finished after 10s!");
                        })
                        .build()
        );
    }
}
