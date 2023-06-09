package ru.galkin.tasklist.web.dto.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import ru.galkin.tasklist.domain.task.Status;
import ru.galkin.tasklist.web.dto.validation.OnCreate;
import ru.galkin.tasklist.web.dto.validation.OnUpdate;

import java.time.LocalDateTime;

@Data
public class TaskDto {

    @NotNull(message = "ID must be not null.", groups = OnUpdate.class)
    private Long id;


    @NotNull(message = "Title must be not null.", groups = {OnUpdate.class, OnCreate.class})
    @Length(max = 255, message = "Title length must be smaller than 255 symbols.", groups = {OnUpdate.class, OnCreate.class})
    private String title;

    @Length(max = 255, message = "Description length must be smaller than 255 symbols.", groups = {OnUpdate.class, OnCreate.class})
    private String description;


    private Status status;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime expirationDate;
}
