package com.mycompany.methotels.components;

import org.apache.tapestry5.*;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.ioc.annotations.*;
import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.SymbolConstants;
import com.mycompany.methotels.entities.User;

/**
 * Layout component for pages of application test-project.
 */
@Import(module="bootstrap/collapse")
public class Layout
{
	@Inject
	private ComponentResources resources;
        
        @SessionState
        private User loggedInUser;

	/**
	 * The page title, for the <title> element and the <h1> element.
	 */
	@Property
	@Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
	private String title;

	@Property
	private String pageName;

	@Property
	@Inject
	@Symbol(SymbolConstants.APPLICATION_VERSION)
	private String appVersion;



	public String getClassForPageName()
	{
		return resources.getPageName().equalsIgnoreCase(pageName)
				? "active"
				: null;
	}

	public String[] getPageNames()
	{
		return new String[]{"Index", "About", "Contact", "DodavanjeSoba",
                    "DodavanjeHotela", "DodavanjeKorisnika","Rezervacije",
                    "RegistracijaKorisnika"};
	}

        public boolean getLoggedIn() {
            if (loggedInUser.getUserEmail() != null) {
                return true;
            }
        return false;
        }

        public void onActionFromLogout() {
            loggedInUser = null;
    }
}

