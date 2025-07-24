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
<dependency>
  <groupId>io.taskflow</groupId>
  <artifactId>taskflow-core</artifactId>
  <version>1.0.0</version>
</dependency>
```
</details>

<details> 
<summary>Gradle</summary>

```Kotlin
implementation("io.taskflow:taskflow-core:1.0.0")
```
</details>

---

### 2. Example Code
#### Delayed Task after 10 Seconds

```java
package test.taskflow;

import de.dragonrex.taskflow.core.ExecutionType;
import de.dragonrex.taskflow.core.ScheduleBuilder;
import de.dragonrex.taskflow.core.TaskScheduler;
import de.dragonrex.taskflow.impl.DefaultTaskSchedular;

import java.time.Duration;

public class TaskTest {
    public static void main(String[] args) {
        TaskScheduler scheduler = new DefaultTaskSchedular();
        
        scheduler.schedule(
                new ScheduleBuilder()
                        .name("TaskTest-001")
                        .after(Duration.ofSeconds(10))
                        .type(ExecutionType.REPEAT)
                        .run(() -> {
                            System.out.println("Hello World!");
                        })
        );
    }
}
```

#### Repeated Task after 10 Seconds

```java
package test.taskflow;

import de.dragonrex.taskflow.core.ExecutionType;
import de.dragonrex.taskflow.core.ScheduleBuilder;
import de.dragonrex.taskflow.core.TaskScheduler;
import de.dragonrex.taskflow.impl.DefaultTaskSchedular;

import java.time.Duration;

public class TaskTest {
    public static void main(String[] args) {
        TaskScheduler scheduler = new DefaultTaskSchedular();
        
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
```
