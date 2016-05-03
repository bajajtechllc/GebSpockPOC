package com.st.rm
import spock.lang.Unroll;
import geb.spock.GebReportingSpec

class RMLoginSpec extends GebReportingSpec {

	@Unroll
    def "[#username] can login to RM appication"(def username, def password) {
		
        when: println "I go to RM Login Page"
		to LoginPage
	
		and: println "Login as $username"
		

		usernameField.value username
		passwordField.value password
		
		loginButton.click()
		
		
		try {
			waitFor( 30, 0.5 ) { $(HomePage.globalMenuSelector) }
		} catch (Exception e) {
			e.printStackTrace()
			waitFor( 30, 0.5) { usernameField.present }
		}
		
		
		then: println "At Home Screen"
		at HomePage
		
		where: "Run for multiple user "
		username	| password
		"rmadmin"	| "aaaa1111"
		"radmin"	| "Gr33n11"
		
    }
	
}