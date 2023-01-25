package com.taskManager.Tasks.Repositories;

import com.taskManager.Tasks.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepo extends CrudRepository<User,Long> {

     User findUserByUserName(String userName);

     @Query(value = "select userId from User")
     Set<Long> getAllUserIds();
}
