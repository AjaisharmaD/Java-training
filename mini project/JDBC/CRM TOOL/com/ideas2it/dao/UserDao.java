package com.ideas2it.dao;

import java.util.List;
import java.util.Map;

import com.ideas2it.model.User;

/**
 * <h1> User DAO </h1>
 * <p>
 * This class will get the request and performs the operations
 * like Adding, Viewing, Updating, Deleting the Details of Users
 * by Stores and fetching the data
 * </p> 
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   19-09-2022
 */
public interface UserDao {

    /**
     * <h1> Insert User </h1>
     * <p>
     * Inserts the Details of Users 
     * <p>
     *
     * @param employeeId - ID of an employee
     * @param employee   - employee Details to add 
     * @param password   - password to login
     *
     * @return User  - Details of an User
     */
    public boolean insert(String userId, User user, String password);

    /**
     * <h1> Get Details of users </h1>
     * <p>
     * Fetchs the Details of users  
     * </p>
     *
     * @return Map - Details of users
     */
    public List<User> fetchAll();

    /**
     * <h1> Get Details of User by Id </h1>
     * <p>
     * Fetchs the Details of Users by Id
     * </p>
     * 
     * @param id    - User's Id to search the Details of User
     *
     * @return User - Details of a Single User
     */
    public User fetchById(String id);

    /**
     * <h1> Update Details of User </h1>
     * <p>
     * Updates the Details of Users 
     * </p>
     *
     * @param id    - key to store the Updated Details of User
     * @param User  - updated Details of User
     *
     * @return User - updated Details of User
     */
    public User updateById(String id, User user);

    /**
     * <h1> Delete Details of User </h1>
     * <p>
     * Deletes the Details of User 
     * </p>
     *
     * @param id    - key to Delete the Details of User
     *
     * @return User - Deleted Details of User
     */
    public User deleteById(String id);
}