package com.example.hibernateTest.controller;

import com.example.hibernateTest.entity.User;
import com.example.hibernateTest.entity.UserGroup;
import com.example.hibernateTest.entity.UserMapping;
import com.example.hibernateTest.repository.UserGroupRepository;
import com.example.hibernateTest.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class MainController {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public UserGroupRepository userGroupRepository;

    // select All
    @RequestMapping(path = "/users", method = { RequestMethod.GET })
    public List<UserMapping> getAllUsers() {
        // return userRepository.findAll(PageRequest.of(1,10));
        return userRepository.findAllBy();
    }


    // @RequestMapping(path = "/users", method = { RequestMethod.GET })
    // public Page<User> getAllUsers() {
    //     return userRepository.findAll(new PageRequest(1,20));
    // }


    /**
     * getUserGroupList 
     * Main Page UserGroup List
     */
    @RequestMapping(path = "/userGroup", method = { RequestMethod.GET })
    public List<UserGroup> getUserGroupList() {
        return userGroupRepository.findAll();
    }

    /**
     * Add New User
     */
    @RequestMapping(path = "/users", method = { RequestMethod.POST })
    public void addUsers(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = new User();

        String groupCD = request.getParameter("group");

        Optional<UserGroup> userGroup = userGroupRepository.findById(groupCD);
        UserGroup userGroup1 = userGroup.get();

        user.setID(request.getParameter("id"));
        user.setPWD(request.getParameter("pwd"));
        
        user.setUserGroup(userGroup1);

        userRepository.save(user);

        response.sendRedirect("/users");
    }

    /*
    * delete user
    */
    // @RequestMapping(path = "/deleteUser", method = {RequestMethod.GET})
    // public void deleteUser(User user){
    //     return userRepository.delete(user);
    // }

}
