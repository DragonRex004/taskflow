package test.taskflow;

import de.dragonrex.taskflow.core.ExecutionType;
import de.dragonrex.taskflow.core.ScheduleBuilder;
import de.dragonrex.taskflow.core.TaskScheduler;
import de.dragonrex.taskflow.impl.DefaultTaskSchedular;

import java.time.Duration;

public class TaskTest {
    public static void main(String[] args) {
        TaskScheduler scheduler = new DefaultTaskSchedular();

        System.out.println("Starting TaskScheduler...");
        scheduler.schedule(
                new ScheduleBuilder()
                        .name("TaskTest-001")
                        .every(Duration.ofSeconds(10))
                        .type(ExecutionType.REPEAT)
                        .run(() -> {
                            System.out.println("Hello World!");
                        })
        );
    }
}
