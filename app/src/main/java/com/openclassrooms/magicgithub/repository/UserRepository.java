package com.openclassrooms.magicgithub.repository;

import android.util.Log;

import com.openclassrooms.magicgithub.api.ApiService;
import com.openclassrooms.magicgithub.api.FakeApiService;
import com.openclassrooms.magicgithub.api.FakeApiServiceGenerator;
import com.openclassrooms.magicgithub.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserRepository {

    private final ApiService apiService; // TODO: A utiliser

    private List<User> mUserList;
    // List<User> users;
    private List<User> users;
    //public List<User> UsersList() { return users; };
    private int mNextUserIndex;
    //users=getUsers();
    //users=this.apiService.getUsers();

    public UserRepository(ApiService apiService) {
    //public UserRepository(List<User> userList) {
        this.apiService = apiService;
        users=FakeApiServiceGenerator.FAKE_USERS;
        //users=apiService.getUsers();
        //super(apiService);
        //mUserList= (List<User>) apiService.getUsers();
        mUserList = apiService.getUsers();
        System.out.println("UserRepositoy mUserList size :" + mUserList.size());
        mNextUserIndex = 0;
    }

    public List<User> getUsers() {
        // TODO: A modifier
        mUserList.clear();
        //List<User> mUserList = new ArrayList<User>(apiService.getUsers());
        System.out.println("getUsers repo mNextUserIndex:" + mNextUserIndex);
        System.out.println("getUsers repo mUserList size avt +:" + mUserList.size());
        if (mNextUserIndex == mUserList.size()) {
            mNextUserIndex = 0;
        }
        System.out.println("repository getUsers() ");
        //for(User q : UsersList()) {  users.get(mNextUserIndex++); }
        //List<User> list = UsersList();

        for (int i=0; i<users.size(); i++)
        {  //users.get(mNextUserIndex++);
        //users.add(getUsers().get(i));
        //users.add(mUserList.get(i));
        mUserList.add(users.get(i));
        //mUserList.set(mNextUserIndex,users.get(i));
        }
        // ok mUserList.add(users.get(mNextUserIndex++));
        //mUserList.set(mNextUserIndex++,users.get(mNextUserIndex));
        //System.out.println("getUsers repo + users.get(mNextUserIndex) :" + users.get(mNextUserIndex).getId());
        //mUserList.add(users.get(mNextUserIndex));
        System.out.println("getUsers repo mUserList size :" + mUserList.size());
        return mUserList;

        //return new ArrayList<>(users.get(mNextUserIndex));

        //return (List<User>) mUserList.get(mNextUserIndex++);

        //return null;
    }

    public void generateRandomUser() {
        // TODO: A modifier
        this.apiService.generateRandomUser();
    }

    public void deleteUser(User user) {
        // TODO: A modifier
        //this.apiService.deleteUser(user);
        //.remove(user);
        //deleteUser(user);
        //mUserList.remove(apiService.deleteUser(););
        //this.deleteUser(user);
        //mUserList.remove(user);
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
