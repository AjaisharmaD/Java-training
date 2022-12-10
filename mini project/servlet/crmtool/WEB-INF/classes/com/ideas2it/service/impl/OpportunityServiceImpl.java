package com.ideas2it.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ideas2it.model.Opportunity;
import com.ideas2it.service.OpportunityService;
import com.ideas2it.dao.OpportunityDao;
import com.ideas2it.dao.impl.OpportunityDaoImpl;
import com.ideas2it.constants.Constants;
import com.ideas2it.constants.Messages;
import com.ideas2it.exception.CustomException;

/**
 * <h1> Opportunity Service Impl </h1>
 * <p>
 * Gets the Request and process the operatioin to be done
 * like adding, Viewing, Updating
 * the Details of Opportunity
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   03-10-2022
 */
public class  OpportunityServiceImpl implements OpportunityService {
    private OpportunityDao opportunityDao;

    public OpportunityServiceImpl() {
        this.opportunityDao = new OpportunityDaoImpl();   
    }

    /**
     * {@inherit}
     */
    public boolean create(Opportunity opportunity) {
       boolean status = true; 

       if (opportunityDao.insert(opportunity) <= 0) {
           status = false;
       }
       return status;
    } 

    /**
     * {@inherit}
     */
    public List<Opportunity> getAll() throws CustomException {
        List<Opportunity> opportunities = opportunityDao.fetchAll();  

        if (null != opportunities) {
            return opportunities;
        } else {
            throw new CustomException(Messages.OPPORTUNITY_NOT_FOUND);
        }
    }

    /**
     * {@inherit}
     */
    public Opportunity getById(int id) throws CustomException {
        Opportunity opportunity = opportunityDao.fetchById(id);

        if (null != opportunity) {
            return opportunity;
        } else {
            throw new CustomException(Messages.OPPORTUNITY_NOT_FOUND);
        }
    }

    /**
     * {@inherit}
     */
    public boolean updateById(int id, String columnName, String columnValue) {
        return (opportunityDao.updateById(id, columnName, columnValue) <= 0) ? false : true;
    }

    /**
     * {@inherit}
     */
    public boolean isDeletedById(int id) {
        return (opportunityDao.deleteById(id) <= 0) ? false : true;
    }
}