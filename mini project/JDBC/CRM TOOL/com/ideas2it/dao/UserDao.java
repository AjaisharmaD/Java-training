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
     * @param user     - user object to update
     *
     * @return boolean - status of the user
     */
    public boolean insert(User user);

    /**
     * <h1> Get Details of users </h1>
     * <p>
     * Fetchs the Details of users  
     * </p>
     *
     * @return List - list of User details
     */
    public List<User> fetchAll();

    /**
     * <h1> Get Details of User by Id </h1>
     * <p>
     * Fetchs the Details of Users by Id
     * </p>
     * 
     * @param id    - User's Id to search the Detail
     *
     * @return User - Details of a Single User
     */
    public User fetchById(int id);

    /**
     * <h1> Update Details of User </h1>
     * <p>
     * Updates the Details of Users 
     * </p>
     *
     * @param id          - User id to update the Detail
     * @param columnName  - name of the Column to update the Value
     * @param columnValue - value to be updated in Column
     *
     * @return int  - count of rows affected
     */
    public int updateById(int id, String columnName, String columnValue);

    /**
     * <h1> Delete Details of User </h1>
     * <p>
     * Deletes the Details of User 
     * </p>
     *
     * @param id    - id to delete the user
     *
     * @return int  - count of rows affected
     */
    public int deleteById(int id);
}