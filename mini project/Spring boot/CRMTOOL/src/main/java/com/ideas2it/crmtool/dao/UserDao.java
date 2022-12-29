package com.ideas2it.crmtool.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ideas2it.crmtool.entity.User;

import java.util.List;

/**
 * <h1>
 *     User Dao
 * </h1>
 * <p>
 *     Repository Layer of the user which extends the JPA repository
 *     and helps the Service layer to perform manipulation
 *     of the User Entity like Save, Update,
 *     FindById, FindAll, DeleteById
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 28-12-2022
 */
public interface UserDao extends JpaRepository<User, Long> {
    /**
     * <h1>
     *     Get Users By name
     * </h1>
     * <p>
     *     Gets the List of Users by sending the name as the Parameter
     *     to the JPA repository
     *     where it will create a Query for finding the users by name
     * </p>
     * @param name - Name of the User to find
     * @return List<User> - List of User who have the name
     */
    List<User> getUsersByName(String name);
}
