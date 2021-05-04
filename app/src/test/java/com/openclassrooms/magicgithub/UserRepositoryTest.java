package com.openclassrooms.magicgithub;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.openclassrooms.magicgithub.api.FakeApiService;
import com.openclassrooms.magicgithub.api.FakeApiServiceGenerator;
import com.openclassrooms.magicgithub.di.Injection;
import com.openclassrooms.magicgithub.model.User;
import com.openclassrooms.magicgithub.repository.UserRepository;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.util.List;
import java.util.stream.Collectors;

import static com.openclassrooms.magicgithub.api.FakeApiServiceGenerator.FAKE_USERS;
import static com.openclassrooms.magicgithub.api.FakeApiServiceGenerator.FAKE_USERS_RANDOM;
import static org.junit.Assert.*;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;


/**
 * Unit test, which will execute on a JVM.
 * Testing UserRepository.
 */
@RunWith(JUnit4.class)
public class UserRepositoryTest {
    
    private UserRepository userRepository;
    
    @Before
    public void setup() {
        userRepository = Injection.createUserRepository();
    }
    // procédure à exécuter avant l'ensemble des tests,
    @BeforeClass
    public static void testPreCondition() throws Exception{
        //assertNotNull(userRepository);
        // procedure a executer avant l'ensemble des test;
        //assertNotNull(userRepository.getUsers());
    }

    @Test
    public void getUsersWithSuccess() {
        List<User> usersActual = userRepository.getUsers();
        //List<User> usersActual = FakeApiService.getUsers();
        System.out.println("Test getUsersWithSuccess usersActual :" + userRepository.getUsers());
        //System.out.println("Test getUsersWithSuccess usersActual 0 :" + userRepository.getUsers().get(0).getId());
        /* Log.d("users repo","" + usersActual); */
        List<User> usersExpected = FAKE_USERS;
        //Log.d("repository","test trace debug");
        //Log.e("repository","fake trace debug");
        System.out.println("Test getUsersWithSuccess fake_users get :" + FAKE_USERS);
        //System.out.println("Test getUsersWithSuccess fake_users get 0:" + FAKE_USERS.get(0).getId());
        assertThat(usersActual, containsInAnyOrder(usersExpected.toArray()));
        /*assertThat(usersActual, containsInAnyOrder(usersExpected.listIterator()));*/
    }

    @Test
    public void generateRandomUserWithSuccess() {
        userRepository.getUsers().clear();
        userRepository.generateRandomUser();

        //System.out.println("Test size ..." + userRepository.getUsers().size());
        /**
         * User user = userRepository.getUsers().get(0);
         * */
        User user = userRepository.getUsers().get(0);

        //User user = FAKE_USERS.get(0);
        //System.out.println("FAKE users array ... 0 size " +FAKE_USERS.size());
        System.out.println(" user array ... 0  " + user.toString() );
        System.out.println(" user id  " + user.getId());
        //System.out.println(" user id  length" +user.getId().length());
        //int user = userRepository.getUsers().size();

        assertEquals(1, userRepository.getUsers().size());
        System.out.println("test FAKE_USERS_RANDOM ..." + FAKE_USERS_RANDOM);
        //assertEquals(1, userRepository.getUsers().get(1));
        System.out.println("generateRandomUserWithSuccess test user.getAvatarUrl ..." + user.getAvatarUrl());
        System.out.println("generateRandomUserWithSuccess test FAKE_SUER stream ..." + FAKE_USERS_RANDOM.stream().map(User::getAvatarUrl).collect(Collectors.toList()));
        assertFalse(FAKE_USERS_RANDOM.stream().map(User::getAvatarUrl).collect(Collectors.toList()).contains(user.getAvatarUrl()));
        //assertTrue(FAKE_USERS_RANDOM.stream().map(User::getId).collect(Collectors.toList()).contains(user.getId()));
        //assertTrue(FAKE_USERS_RANDOM.stream().map(User::getId).collect(Collectors.toList()).contains(user.getId()));
        //assertTrue(FAKE_USERS_RANDOM.stream().map(User::getLogin).collect(Collectors.toList()).contains(user.getLogin()));
        //assertFalse(FAKE_USERS.stream().map(User::getAvatarUrl).collect(Collectors.toList()).contains(user.getAvatarUrl()));
        //assertFalse(FAKE_USERS.stream().map(User::getId).collect(Collectors.toList()).contains(user.getId()));
        //assertFalse(FAKE_USERS.stream().map(User::getLogin).collect(Collectors.toList()).contains(user.getLogin()));
    }

    @Test
    public void deleteUserWithSuccess() {
        User userToDelete = userRepository.getUsers().get(0);
        userRepository.deleteUser(userToDelete);
        System.out.println("Test deleteUsersWithSuccess usersActual :" + userRepository.getUsers());
        assertFalse(userRepository.getUsers().contains(userToDelete));
    }
}