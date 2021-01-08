package test;

import action.Action;

public class TestScenarios extends Action {

	
	public void gmailAutomate()
	{
		navigateURL("http://mail.google.com");
		waitDriverForGivenSec(3);
		loginGmail();
		waitDriverForGivenSec(5);
		enterPassword();
		waitDriverForGivenSec(5);
		composeEmail();
		waitDriverForGivenSec(5);
		closeAndQuitDriver();
	}
}
