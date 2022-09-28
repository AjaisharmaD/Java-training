import com.ideas2it.view.CRMView;


/**
 * <h1> CRM Tool <h1>
 * <p>
 * Start the CRM Tool 
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
     * This method will call the CRM Tool's Dashboard to start.
     * </p>
     *
     * @param args - an Unused parameter.
     */
    public static void main(String[] args) {
	CRMView crmView = new CRMView();
        crmView.startCRM();
    }
}