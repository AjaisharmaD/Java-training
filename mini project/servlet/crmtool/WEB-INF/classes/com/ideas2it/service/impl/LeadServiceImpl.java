package com.ideas2it.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ideas2it.model.Lead;
import com.ideas2it.service.LeadService;
import com.ideas2it.dao.LeadDao;
import com.ideas2it.dao.impl.LeadDaoImpl;
import com.ideas2it.constants.Constants;
import com.ideas2it.constants.Messages;
import com.ideas2it.exception.CustomException;
import com.ideas2it.logger.CustomLogger;

/**
 * <h1> Lead Service </h1>
 * <p>
 * This class will get the Request and process the operatioin to be done
 * like adding, Viewing, Updating, Deleting 
 * the Details of Leads
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   16-09-2022
 */
public class LeadServiceImpl implements LeadService {
    private LeadDao leadDao;
    private CustomLogger logger;
    
    public LeadServiceImpl() {
        this.leadDao = new LeadDaoImpl(); 
        this.logger = new CustomLogger(LeadService.class);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean create(Lead lead) {
       boolean status = true;       

       if (leadDao.insert(lead) <= 0) {
           status = false;
       } 
       return status;
    } 

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Lead> getAll(int id) throws CustomException {   
         List<Lead> listOfLead = leadDao.fetchAll(id);
         List<Lead> leads = new ArrayList<>();

         if (!listOfLead.isEmpty()) {
            for (Lead lead : listOfLead) {
                if (lead.getUserId() == id) {
                    leads.add(lead);
                }
            }
            
        } else {
            throw new CustomException(Messages.LEAD_NOT_FOUND);
        }
        return leads;    
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Lead getById(int id, int userId) throws CustomException {
        Lead lead = leadDao.fetchById(id);

        if (null != lead) {
            if (lead.getUserId() == userId) {
                return lead;
            }
        } else {
            throw new CustomException(Messages.LEAD_NOT_FOUND);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean updateById(Lead lead) {
        return (leadDao.updateById(lead) <=0) ? false : true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isDeletedById(int id) {
        return (leadDao.deleteById(id) <= 0) ? false : true;
    }
}