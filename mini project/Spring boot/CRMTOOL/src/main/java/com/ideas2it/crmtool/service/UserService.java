package com.ideas2it.crmtool.service;

import com.ideas2it.crmtool.entity.User;

import java.util.List;

/**
 * <h1>
 *     User Service Interface
 * </h1>
 * <p>
 *    Contains the method to manipulate
 *    and passes the returned values from the repository layer
 *    to the Controller layer,
 *    So the Controller Layer will Returns the Responses to Client
 * </p>
 */
public interface UserService {
    /**
     * <h1>
     *     Create
     * </h1>
     * <p>
     *     Calls the save insert the User Entity
     *     which is present in JPA Repository
     *     and returns the inserted User Entity
     * </p>
     * @param user - User Entity Which is sent as parameter to the Save
     * @return User - Inserted User Entity
     */
    User create(User user);

    /**
     * <h1>
     *     Update
     * </h1>
     * <p>
     *     Calls the Repository's FindById
     *     to check whether the User is present in the Repository
     *     By the Id of the User and Updates the User values
     *     By passing the Updated User Entity to
     * </p>
     * @param user - Updated User Entity
     * @param id - Id of the User to get User
     * @return User - User Entity which is Updated
     */
    User update(User user, Long id);

    /**
     * <h1>
     *     Get All
     * </h1>
     * <p>
     *     Calls the FindAll of the JPA Repository
     *     to get the List of users
     *     and pass them to Controller to return response to the client
     * </p>
     * @return List<User> - List of User present in the CRM Tool
     */
    List<User> getAll();

    /**
     * <h1>
     *     Get By Id
     * </h1>
     * <p>
     *     Calls the FindById of the JPA Repository
     *     to get the user by Passing the Id as Parameter
     *     and passes the User Entity to Controller
     *     to return response to the Client
     * </p>
     * @param id - Id of the user to get the User Entity
     * @return User - User Entity
     */
    User getById(Long id);

    /**
     * <h1>
     *     Delete  By Id
     * </h1>
     * <p>
     *     Calls the DeleteById of the JPA Repository
     *     to delete the User Entity
     *     by passing the Id
     * </p>
     * @param id - Id of the User to Delete
     */
    boolean deleteById(Long id);
}
