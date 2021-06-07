package com.openclassrooms.magicgithub.repository;

import com.openclassrooms.magicgithub.api.ApiService;
import com.openclassrooms.magicgithub.model.User;

import java.util.List;

public class UserRepository {
    private final ApiService RepositoryService;

    public UserRepository(ApiService apiService) {
        this.RepositoryService = apiService;
    }

    public List<User> getUsers() {
        return RepositoryService.getUsers();
    }

    public void generateRandomUser() {
        //apiService.generateRandomUser();
        RepositoryService.generateRandomUser();
        RepositoryService.getUsers();
    }

    public void deleteUser(User user) {
        RepositoryService.deleteUser(user);
    }
}
