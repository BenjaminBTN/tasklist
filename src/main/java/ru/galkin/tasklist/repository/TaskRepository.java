package ru.galkin.tasklist.repository;

import ru.galkin.tasklist.domain.task.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    Optional<Task> findById(Long id);
    List<Task> findAllByUserId(Long UserId);
    void assignToUserById(Long taskId, Long userId);
    void update(Task task);
    void create(Task task);
    void delete(Long id);

}
