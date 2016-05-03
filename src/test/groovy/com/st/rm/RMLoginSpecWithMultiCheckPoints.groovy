package com.st.rm
import spock.lang.Unroll;
import geb.spock.GebReportingSpec

class RMLoginSpecWithMultiCheckPoints extends GebReportingSpec {

	@Unroll
    def "[#username] can login to RM appication"(def username, def password) {
		
        when: println "I go to RM Login Page"
		to LoginPage
		
		then: println " I am at Login Page"
		at LoginPage
	
		when: println "I add the values for $username and $password"
		
		usernameField.value username
		passwordField.value password
		
		and: println "Click on Login button"
		
		loginButton.click()
		
		and: println " Wait for Home Page"
		
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