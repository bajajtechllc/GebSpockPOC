package com.st.rm

import geb.spock.GebReportingSpec;
import spock.lang.Unroll;

class RMLoginErrorSpec extends GebReportingSpec {
	
	@Unroll
	def "[#username] can not login to RM appication"(def username, def password) {
		
		when: println "I go to RM Login Page"
	    //browser.go "http://qa02-rm.qat.skytouch.io/RMT"
		to LoginPage
	
		and: println "Login as $username"
		

		usernameField.value username
		passwordField.value password
		
		loginButton.click()
		
		try {
			waitFor( 30, 0.5) { loginError.present }
		} catch (Exception e) {
			e.printStackTrace()
		}
		
		
		then: println "At Login Screen"
		at LoginPage
		
		where: "Run for multiple user "
		username	| password
		"admin" 	| "aaaa"
		"choice"	| "1234"
		
	}
}
