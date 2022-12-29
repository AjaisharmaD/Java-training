package com.ideas2it.crmtool.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.ideas2it.crmtool.entity.User;
import com.ideas2it.crmtool.dao.UserDao;
import com.ideas2it.crmtool.exception.CustomException;
import com.ideas2it.crmtool.constant.Message;
import com.ideas2it.crmtool.service.UserService;
import com.ideas2it.crmtool.logger.CustomLogger;

/**
 * <h1>
 *     User Service Impl
 * </h1>
 * <p>
 *     Implements the UserService Interface
 *     to perform the CRUD operation the User Entity
 *     like Saving, Finding All, Finding, Updating,
 *     Deleting User By ID
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 28-12-2022
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private CustomLogger logger = new CustomLogger(UserServiceImpl.class);

    /**
     * <h1>
     *     User Service Impl Constructor
     * </h1>
     * <p>
     *     Constructor to perform Autowiring in spring boot
     *     which injects the userDao object
     * </p>
     *
     * @param userDao - Reference variable of the UserDao
     */
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User create(User user) {
        logger.info("Inside the User Service Create Method");
        return userDao.save(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> getAll() throws CustomException {
        logger.info("Inside the User Service Get All Method");
        List<User> userList = userDao.findAll();

        if (userList.isEmpty()) {
            throw new CustomException(Message.NO_USER_FOUND);
        }
        return userList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getById(Long id) throws CustomException{
        logger.info("Inside the User Service Get By Id Method");
        return userDao.findById(id).orElseThrow(() ->
                new CustomException(Message.USER_NOT_FOUND));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean deleteById(Long id) {
        logger.info("Inside the User Service Delete By Id Method");
        boolean isDeleted = false;
        userDao.deleteById(id);

        if (userDao.findById(id).isPresent()) {
            isDeleted = true;
        }
        return isDeleted;
    }

    /**
     * <h1>
     * Get Users By name
     * </h1>
     * <p>
     * Gets the List of Users by sending the name as the Parameter
     * to the JPA repository
     * where it will create a Query for finding the users by name
     * </p>
     *
     * @param name - Name of the User to find
     * @return List<User> - List of User who have the name
     */
    @Override
    public List<User> getUsersByName(String name) throws CustomException {
        logger.info("Inside the User Service GetUser By Name");
        List<User> userList = userDao.getUsersByName(name);

        if(userList.isEmpty()) {
            throw new CustomException(Message.USER_NOT_FOUND);
        }
        return userList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User updateById(User user, Long id) throws CustomException {
        logger.info("Inside the User Service Update By Id Method");
        User oldUser = getById(id);

        if (Objects.nonNull(user.getName()) && !"".equals(user.getName())) {
            oldUser.setName(user.getName());
        }

        if (Objects.nonNull(user.getName()) && !"".equals(user.getEmail())) {
            oldUser.setEmail(user.getEmail());
        }

        return userDao.save(oldUser);
    }
}
