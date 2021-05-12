package com.openclassrooms.magicgithub.repository;

import com.openclassrooms.magicgithub.api.ApiService;
import com.openclassrooms.magicgithub.api.FakeApiService;
import com.openclassrooms.magicgithub.api.FakeApiServiceGenerator;
import com.openclassrooms.magicgithub.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    // TODO: A Done
    private final ApiService apiService;
    private int mNextUserIndex;
    //List<User> mUserList = new ArrayList<User>(); // -> []
    private List<User> listeUsersApi;
    private List<User> listeUsersRepository;
    //ArrayList<User> arlusers=new ArrayList<User>();
    ArrayList<User> arraylistUsers=new ArrayList<User>();
    //private Iterable<User> IterableUser;
    //Set<User> Hubs = new HashSet<User>();
    //private Vector<User> Vuser;

    public UserRepository(ApiService apiService) {
        this.apiService = apiService;
        listeUsersApi=apiService.getUsers();
        //System.out.println("UserRepositoy hydrate listeUserApisize :" + listeUsersApi.size());
        listeUsersRepository=FakeApiServiceGenerator.FAKE_USERS;
        //listeUsersApi.add(FakeApiServiceGenerator.FAKE_USERS_RANDOM.containsAll(User));
        //arraylistUsers.add(FakeApiServiceGenerator.FAKE_USERS.containsAll());
        //Vuser = new Vector<User>();
        //Hubs = new HashSet<User>();
        //System.out.println("UserRepositoy mUserList size :" + mUserList.size());
        mNextUserIndex = 0;
    }

    public List<User> getUsers() {
        // TODO: modifie
        //System.out.println("UserRepository :: getUsers + index :" +mNextUserIndex); // -> 2
        //arraylistUsers.clear();  //ko pour InstrumentedTess
        listeUsersRepository=listeUsersApi;
        //arlusers.set(1, listeUsersApi.get(1));
        //mNextUserIndex = 0;
        return listeUsersRepository;

        /** Si index = taille listUserAPI
         if (mNextUserIndex == listeUsersApi.size()) {
         System.out.println("mNextUserIndex UserRepository get users if index = size :" +mNextUserIndex); // -> 2
         mNextUserIndex = 0;
         }*/

            //System.out.println("UserRepositoy:: getUsers listUserApi avt +:" +listeUsersApi);
        //arlusers.set(1, FakeApiServiceGenerator.FAKE_USERS.get(1));

        /**
        for(User user : listeUsersApi) {
            arraylistUsers.add(listeUsersApi.get(mNextUserIndex++));
            //listeUsersRepository.add(listeUsersApi.get(mNextUserIndex++));

            //System.out.println("UserRepository getUsers random  :" +user.getLogin());
        }
        //System.out.println(e.getLogin()+" "+e.getId()+" "+e.getAvatarUrl());
        /**
         * Hubs.add(users.get(0));
        System.out.println("UserRepository getUsers Hubs size :" + Hubs.size());
        return new ArrayList<>(Hubs);
        */
    }

    public void generateRandomUser() {
        // TODO: Done
        //listeUsersApi.clear();
        apiService.generateRandomUser();
        listeUsersApi=apiService.getUsers();
/**
        int lastUserIndex =apiService.getUsers().lastIndexOf(getLastProfil());
        System.out.println("UserRepository generateRandomUser + last add :" +apiService.getUsers().listIterator(lastUserIndex));
 */
        //listeRandomUsers = new List<User>();
        //int lastUserIndex =apiService.getUsers().lastIndexOf(getLastProfil());
        //List<Integer> lastRandomUser = null;
        // 11 5 2020 listeUsersApi.add(apiService.getUsers().get(getLastUser()));
        //System.out.println("UserRepository ::generateRandomUser + size listUserApi :" +listeUsersApi.size()); // ->
    }

    public void deleteUser(User user) {
        // TO DO DONE
        //this.apiService.deleteUser(user);
        //listeUsersApi.clear();
        apiService.deleteUser(user);
        //apiService.deleteUser();
        //System.out.println("UserRepositoy deleteUser => size apres delete :" +apiService.getUsers().size());
        //listeUsersApi=apiService.getUsers();
        //System.out.println("UserRepositoy deleteUser => liste UsersApi apres delete :" +listeUsersApi);

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
