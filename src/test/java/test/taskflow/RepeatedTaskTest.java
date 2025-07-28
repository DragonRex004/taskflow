package test.taskflow;

import de.dragonrex.taskflow.core.ExecutionType;
import de.dragonrex.taskflow.core.Task;
import de.dragonrex.taskflow.core.TaskScheduler;
import de.dragonrex.taskflow.impl.DefaultTaskSchedular;

import java.time.Duration;

public class RepeatedTaskTest {
    public static void main(String[] args) {
        TaskScheduler scheduler = new DefaultTaskSchedular();

        System.out.println("Starting RepeatedTaskTest...");
        scheduler.schedule(
                Task.builder()
                        .name("RepeatedTaskTest")
                        .type(ExecutionType.REPEAT)
                        .every(Duration.ofSeconds(10))
                        .task(() -> {
                            System.out.println("RepeatedTask Finished every 10s!");
                        })
                        .build()
        );
    }
}
