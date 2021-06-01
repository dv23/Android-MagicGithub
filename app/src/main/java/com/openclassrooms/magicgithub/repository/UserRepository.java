package com.openclassrooms.magicgithub.repository;

import com.openclassrooms.magicgithub.api.ApiService;
import com.openclassrooms.magicgithub.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private final ApiService apiService;
    private List<User> listeUsersApi;
    //private List<User> listeUsersRepository;

    public UserRepository(ApiService apiService) {
        this.apiService = apiService;
        listeUsersApi=apiService.getUsers();
    }

    public List<User> getUsers() {
        return listeUsersApi;
    }

    public void generateRandomUser() {
        apiService.generateRandomUser();
        listeUsersApi=apiService.getUsers();
    }

    public void deleteUser(User user) {
        apiService.deleteUser(user);
    }

    /**
     * Récupération du dernier profil
     * @return le dernier objet de la ocllection de profils, donc le plus récent
     */
    public int getLastUser() {
        return apiService.getUsers().size()-1;
        //return apiService.getUsers().size();
    }
}
