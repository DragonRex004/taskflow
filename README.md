# TaskFlow 🕒
**A lightweight, modular scheduling framework for Java.**

With **TaskFlow**, you can easily and cleanly define and 
manage recurring, delayed, or scheduled tasks in Java projects – ideal 
for applications, microservices, and background tasks.

---

## ✨ Features

- Easy API to use
- Supports **delayed Tasks**, **repeated Tasks**
- recommended jdk: Java 21
- No external Dependency needed

---

## 🚀 Erste Schritte

### 1. Add Dependency

<details>
<summary>Maven</summary>

```xml
<dependencies>
    <!-- Placeholder
    <dependency>
        <groupId>io.taskflow</groupId>
        <artifactId>taskflow-core</artifactId>
        <version>1.0.0</version>
    </dependency>
    -->
</dependencies>
```
</details>

<details> 
<summary>Gradle</summary>

```Kotlin
dependencies {
    // Placeholder
    //implementation("io.taskflow:taskflow-core:1.0.0")
}
```
</details>

---

### 2. Example Code
#### Delayed Task after 10 Seconds

```java
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
```

#### Repeated Task after 10 Seconds

```java
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
```
