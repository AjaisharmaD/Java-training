import com.ideas2it.view.CRMView;

/**
 * <h1> CRM Tool <h1>
 * <p>
 * Initial point of the CRM Tool and 
 * Calls the CRM View page which contains 
 * the dashboard for the login
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0 
 * @since   24-08-2022
 */
public class CRMTool {

    /**
     * <h1> Main Method <h1>
     * <p>
     * A main method used to call the start CRM method
     * by creating a object for CRM View Class
     * </p>
     *
     * @param args - an Unused parameter.
     */
    public static void main(String[] args) {
	CRMView crmView = new CRMView();
        crmView.startCRM();
    }
}