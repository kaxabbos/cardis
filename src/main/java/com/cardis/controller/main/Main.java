package com.cardis.controller.main;

import com.cardis.model.Users;
import com.cardis.repo.CarDescriptionRepo;
import com.cardis.repo.CarsRepo;
import com.cardis.repo.CommentsRepo;
import com.cardis.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;

public class Main {

    @Autowired
    protected UsersRepo usersRepo;
    @Autowired
    protected CarsRepo carsRepo;
    @Autowired
    protected CarDescriptionRepo carDescriptionRepo;
    @Autowired
    protected CommentsRepo commentsRepo;
    @Value("${upload.img}")
    protected String uploadImg;

    protected String DateNow() {
        return LocalDateTime.now().toString().substring(0, 10);
    }

    protected Users getUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if ((!(auth instanceof AnonymousAuthenticationToken)) && auth != null) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            return usersRepo.findByUsername(userDetail.getUsername());
        }
        return null;
    }

    protected String getRole() {
        Users users = getUser();
        if (users == null) return "NOT";
        return users.getRole().toString();
    }
}