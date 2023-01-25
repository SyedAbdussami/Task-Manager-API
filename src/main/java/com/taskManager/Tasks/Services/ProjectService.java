package com.taskManager.Tasks.Services;


import com.taskManager.Tasks.Exception.CustomException;
import com.taskManager.Tasks.Models.Project;
import com.taskManager.Tasks.Models.User;
import com.taskManager.Tasks.Repositories.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepo projectRepo;

    @Autowired
    UserService userService;

    public void addProject(Project project){
        List<Long> claimedUsersIds=project.getUserIds();
        for (long userIds:claimedUsersIds) {
            if(!userService.userCreatedVerificationUsingId(userIds)){
                throw new CustomException("User Does not exist","please try creating the user", HttpStatus.BAD_REQUEST);
            }

        }
        projectRepo.save(project);
    }

    public  List<Project> getAllProjects(){
        return (List<Project>) projectRepo.findAll();
    }
    public boolean projectAlreadyExists(Project project){
        String projectName=project.getProjectName();
        if(projectRepo.findProjectByProjectName(projectName)==null){
            return false;
        }
        return projectRepo.findProjectByProjectName(projectName).getProjectName().equals(projectName);
    }
}
