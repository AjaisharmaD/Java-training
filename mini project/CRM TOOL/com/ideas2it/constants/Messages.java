package com.ideas2it.constants;

import com.ideas2it.constants.Constants;

/**
 * <h1> Constants </h1>
 * <p>
 * Constants of the CRMTool are declared in here
 * </p>
 * 
 * @author  AJAISHARMA
 * @version 1.0 
 * @since   29-09-2022
 */
public class Messages {
    public final static String DEFAULT_MESSAGE = "\n>>>>> You have entered wrong Choice <<<<<\n"
                                                  + "Please enter any of the " 
                                                  + "number given Below to proceed\n";
    public final static String EXIT_MENU = "\n>>>>> Are you sure want to Exit? <<<<<\n" 
                                               + "Press \" " + Constants.LOGOUT + " \" for Yes\n" 
                                               +"Press \" Any Number \" for No";

    public final static String SUCCESS = "\n>>>>> SUCCESSFULLY DONE <<<<<\n";
    public final static String FAILED = "\n>>>>> FAILED! <<<<<\n";
}