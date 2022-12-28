package com.ideas2it.crmtool.controller;

import com.ideas2it.crmtool.entity.User;
import com.ideas2it.crmtool.message.Message;
import com.ideas2it.crmtool.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <h1>
 *     User Controller
 * </h1>
 * <p>
 *     Contains the method to manipulate the User
 *     by getting the Inputs from the Client and
 *     passes the parameters to the Repository layer
 *     to Create, GetAll, get, Update, Delete User
 *     By Id via Service Layer
 * </p>
 * @author AJAISHARMA
 * @version 1.0
 * @since 28-12-2022
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    /**
     * <h1>
     *     User Controller Constructor
     * </h1>
     * <p>
     *     Constructor to perform a Autowiring in spring boot
     *     which creates a Service object for the User Service
     * </p>
     *
     * @param userService - Reference variable of the UserService
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * <h1>
     *     Create User
     * </h1>
     * <p>
     *   used gets the User Entity,
     *   and Passes it to the Repository Layer
     *   Via Service layer
     *   to insert the User Entity's values
     * </p>
     * @param user - User Entity given by the client
     * @return  ResponseEntity<User> - User Entity and HttpStatus Code
     */
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
    }

    /**
     * <h1>
     *     Get All Users
     * </h1>
     * <p>
     *     Gets the List of Users
     *     from the Repository
     *     by sending a request to the repository Layer
     *     via Service layer
     * </p>
     * @return  ResponseEntity<User> - User Entity and HttpStatus Code
     */
    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    /**
     * <h1>
     *     Get By Id
     * </h1>
     * <p>
     *     Gets the User by Id from the Repository Layer
     *     By Passing the Id as a Parameter
     *     via Service Layer
     * </p>
     * @param id - ID of the user given by the Client
     * @return  ResponseEntity<User> - User Entity and HttpStatus Code
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.getById(id), HttpStatus.FOUND);
    }

    /**
     * <h1>
     *     Delete By Id
     * </h1>
     * <p>
     *     Deletes the User By Id
     *     By passing the Id to the Repository Layer
     *     via Service Layer
     * </p>
     * @param id - ID of the User given by the Client
     * @return ResponseEntity<User> - User Entity and HttpStatus Code
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        String message = Message.FAILED_TO_DELETE;

        if (userService.deleteById(id)) {
            message = Message.DELETED_SUCCESSFULLY;
        }
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    /**
     * <h1>
     *     Update
     * </h1>
     * <p>
     *     Updates the User Entity
     *     by passing the User and Id of the particular User
     *     to the Repository Layer
     *     via Service layer
     * </p>
     * @param user - User Entity which contains the Updated values
     * @param id - ID of the User given by the Client
     * @return ResponseEntity<User> - User Entity and HttpStatus Code
     */
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable("id") Long id){
        return new ResponseEntity<>(userService.update(user, id), HttpStatus.OK);
    }
}
