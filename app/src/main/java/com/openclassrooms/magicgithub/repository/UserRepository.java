package com.openclassrooms.magicgithub.repository;

import android.util.Log;

import com.openclassrooms.magicgithub.api.ApiService;
import com.openclassrooms.magicgithub.api.FakeApiService;
import com.openclassrooms.magicgithub.api.FakeApiServiceGenerator;
import com.openclassrooms.magicgithub.model.User;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class UserRepository {

    private final ApiService apiService; // TODO: A utiliser

    //private List<User> mUserList;
    //List<User> mUserList = new ArrayList<User>(); // -> []

    //private Iterable<User> IterableUser;
    private List<User> listeUsersApi;
    ArrayList<User> arlusers=new ArrayList<User>();
    //Array<User> arrayUsers = new ArrayList();

    //private HashMap<String,User> GitUsers ;
    //Set<User> Hubs = new HashSet<User>();
    //private Vector<User> Vuser;

    private int mNextUserIndex;

    public UserRepository(ApiService apiService) {
    //public UserRepository(List<User> userList) {
        this.apiService = apiService;
        listeUsersApi=apiService.getUsers();
        //IterableUser = apiService.getUsers();
        //this.IterableUser=FakeApiServiceGenerator.FAKE_USERS;
        //Vuser = new Vector<User>();
        //Hubs = new HashSet<User>();
        //System.out.println("UserRepositoy mUserList size :" + mUserList.size());
        mNextUserIndex = 0;
    }

    public List<User> getUsers() {
        // TODO: A modifier
        //arlusers.add(listeUsersApi.get(0));
        arlusers.clear();
        for(User user : listeUsersApi) {  arlusers.add(listeUsersApi.get(mNextUserIndex++)); }
        if (mNextUserIndex == listeUsersApi.size()) {
         mNextUserIndex = 0;
         }
        //iterate through current objects and add them to new list
        System.out.println("UserRepositoy getUsers size arlusers :" +arlusers.size()); // -> 2
        //System.out.println("UserRepositoy array users :" +arlusers); // -> 2
        // faire avec myarray.length()
        return arlusers;

        /**  liste
        System.out.println("UserRepositoy mUserList size avt add :" +mUserList.size()); // -> 2
        //mUserList.add(1,users.get(1)); //-> [7, 12, 5]
        System.out.println("UserRepositoy mUserList size apr add :" +mUserList.size()); // -> 2
        return mUserList;
*/
        //System.out.println(e.getLogin()+" "+e.getId()+" "+e.getAvatarUrl());

        /**
         * Hubs.add(users.get(0));
        System.out.println("UserRepository getUsers Hubs size :" + Hubs.size());
        return new ArrayList<>(Hubs);
        */
    }

    public void generateRandomUser() {
        // TODO: A modifier
        apiService.generateRandomUser();
        //listeUsersApi=apiService.getUsers();
    }

    public void deleteUser(User user) {
        // TODO: A modifier
        //this.apiService.deleteUser(user);
        apiService.deleteUser(user);

        System.out.println("UserRepositoy deleteUser => size listusers :" + listeUsersApi.size());
        //System.out.println("UserRepository deleteUser listUsersApi apr delete :" + listeUsersApi);
        //.remove(user);
        //deleteUser(user)
    }
/**
    public String clear() {
        // TODO: A modifier
        String lesUsers = null;
        //lesUsers = apiService.getUsers();
        System.out.println("clear getUsers repo" + lesUsers.toString());
        return lesUsers;
    }
 */
}
