package com.ideas2it.crmtool.dao;

import com.ideas2it.crmtool.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

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
 */
public interface UserDao extends JpaRepository<User, Long> {

}
