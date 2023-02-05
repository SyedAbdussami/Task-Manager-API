package com.taskManager.Tasks.DTOs;

import com.taskManager.Tasks.Models.User;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
public class ProjectDTO {

    private UUID projectId;

    private String projectName;

    private String projectDescription;

    private String projectCreatedDate;

    private List<UUID> userIds;

    private List<User> users;
}
