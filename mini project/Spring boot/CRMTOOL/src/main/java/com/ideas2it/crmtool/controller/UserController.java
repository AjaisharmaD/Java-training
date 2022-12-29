package com.ideas2it.crmtool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.crmtool.entity.User;
import com.ideas2it.crmtool.service.UserService;
import com.ideas2it.crmtool.constant.Message;
import com.ideas2it.crmtool.exception.CustomException;
import com.ideas2it.crmtool.logger.CustomLogger;

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
    CustomLogger logger = new CustomLogger(UserController .class);

    /**
     * <h1>
     * User Controller Constructor
     * </h1>
     * <p>
     * Constructor to perform a Autowiring in spring boot
     * which Injects the userService Object
     * to call the userService
     * </p>
     *
     * @param userService  - Reference variable of the UserService
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
     *
     * @param user - User Entity given by the client
     *
     * @return  ResponseEntity<User> - User Entity and HttpStatus Code
     */
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        logger.info("Inside Create Method");
        return new ResponseEntity<>(userService.create(user),
                                         HttpStatus.CREATED);
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
     *
     * @return  ResponseEntity<User> - User Entity and HttpStatus Code
     */
    @GetMapping
    public ResponseEntity<Object> getAll() {
        logger.info("Inside Get All Method");

        try {
            logger.info("Calling the user Service to get All the user");
            return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
        } catch (CustomException customException) {
            logger.error(customException.getMessage());
            return new ResponseEntity<>(Message.NO_USER_FOUND, HttpStatus.NOT_FOUND);
        }
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
     *
     * @param id - ID of the user given by the Client
     *
     * @return  ResponseEntity<User> - User Entity and HttpStatus Code
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") Long id) {
        logger.info("Inside the Get By Id");

        try {
            logger.info("Calling the User Service to Get User By Id");
            return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
        } catch (CustomException customException) {
            logger.error(customException.getMessage());
            return new ResponseEntity<>(Message.USER_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
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
     *
     * @param id - ID of the User given by the Client
     *
     * @return ResponseEntity<User> - User Entity and HttpStatus Code
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        logger.info("Inside the Delete By Id");
        String message = Message.FAILED_TO_DELETE;

        if (userService.deleteById(id)) {
            message = Message.DELETED_SUCCESSFULLY;
        }
        logger.info("Returns the Response for Delete Method");
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
     *
     * @param user - User Entity which contains the Updated values
     * @param id - ID of the User given by the Client
     *
     * @return ResponseEntity<User> - User Entity and HttpStatus Code
     */
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateById(@RequestBody User user,
                                         @PathVariable("id") Long id){
        logger.info("Inside the Update By Id");

        try {
            logger.info("Calling the Update by Id method in user Service");
            return new ResponseEntity<>(userService.updateById(user, id), HttpStatus.OK);
        } catch (CustomException customException) {
            logger.error(customException.getMessage());
            return new ResponseEntity<>(Message.FAILED_TO_UPDATE, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * <h1>
     * Get Users By name
     * </h1>
     * <p>
     * Gets the List of Users by sending the name as the Parameter
     * to the repository
     * where it will create a Query for finding the users by name
     * via Service Layer
     * </p>
     *
     * @param name - Name of the User to find
     * @return ResponseEntity<User> - User Entity and HttpStatus Code
     */
    @GetMapping("/getByName/{name}")
    public ResponseEntity<Object> getUsersByName(@PathVariable("name") String name) {
        logger.info("Inside the Get Users By name");

        try {
            logger.info("Calling the get User By name");
            return new ResponseEntity<>(userService.getUsersByName(name), HttpStatus.OK);
        } catch (CustomException customException) {
            logger.error(customException.getMessage());
            return new ResponseEntity<>(Message.USER_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }
}
