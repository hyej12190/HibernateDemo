package com.example.hibernateTest.controller;

import com.example.hibernateTest.entity.User;
import com.example.hibernateTest.entity.UserGroup;
import com.example.hibernateTest.repository.UserGroupRepository;
import com.example.hibernateTest.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    /** 
     * Select all user / Paging
    */
    @RequestMapping(path = "/users", method = { RequestMethod.GET })
    public Page<User> getAllUsersPaging(@RequestParam(value = "page", defaultValue = "0") int page) {
        return userRepository.findAll(PageRequest.of(page, 350));
    }

    /**
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

        user.setId(request.getParameter("id"));
        user.setPwd(request.getParameter("pwd"));   
        user.setUserGroup(userGroup1);

        userRepository.save(user);

        response.sendRedirect("/users");
    }

    /*
    * delete user
    */
    // @RequestMapping(path = "/deleteUser", method = {RequestMethod.GET})
    // public void deleteUser(@RequestParam(value = "id") String id){

    //     userRepository.deleteById(id);
        
    // }
}
