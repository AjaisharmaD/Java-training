package com.ideas2it.crmtool.service;

import com.ideas2it.crmtool.dao.UserDao;
import com.ideas2it.crmtool.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h1>
 *     User Service Impl
 * </h1>
 * <p>
 *     Implements the UserService Interface
 *     to perform the CRUD operation the User Entity
 *     like Saving, Finding All, Finding, Updating,
 *     Deleting User By Id
 * </p>
 * @author AJAISHARMA
 * @version 1.0
 * @since 28-12-2022
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    /**
     * <h1>
     *     User Service Impl Constructor
     * </h1>
     * <p>
     *
     * </p>
     * @param userDao
     */
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User create(User user) {
        return userDao.save(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getById(Long id) {
        return userDao.findById(id).get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean deleteById(Long id) {
        boolean isDeleted = false;
        userDao.deleteById(id);

        if (null !=userDao.findById(id).get()) {
            isDeleted = true;
        }
        return isDeleted;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User update(User user, Long id) {
        User usr = userDao.findById(id).get();

        usr.setEmail(user.getEmail());
        usr.setName(user.getName());

        return userDao.save(usr);
    }
}
