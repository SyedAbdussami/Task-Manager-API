package com.taskManager.Tasks.Controllers;


import com.taskManager.Tasks.Exception.CustomException;
import com.taskManager.Tasks.Models.Project;
import com.taskManager.Tasks.Services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;


    @GetMapping
    private ResponseEntity<?> getProjects(){
        List<Project> projectList=projectService.getAllProjects();
        System.out.println("GET Req for All Projects received");
        if(projectList.isEmpty()){
            return new ResponseEntity<>("No projects created yet",HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(projectList, HttpStatus.ACCEPTED);
    }

    @PostMapping
    private ResponseEntity<?> addProject(@RequestBody Project project){

        if(projectService.projectAlreadyExists(project)){
            throw new CustomException("Project Already Exists","Please Contact the admin",HttpStatus.BAD_REQUEST);
        }
        projectService.addProject(project);
        System.out.println("new project added successfully");
        return new ResponseEntity<>("Project "+project.getProjectName()+" Added Successfully",HttpStatus.ACCEPTED);
    }


}
