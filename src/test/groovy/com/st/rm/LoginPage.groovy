package com.st.rm
import geb.Page

class LoginPage extends Page {

	// This is our verification that we are on the right page
    static at = { title == "User Login" }

	// This is the content for the page
    static content = {
		usernameField 	{  $("input[name=j_username]") }
		passwordField 	{  $("input[id=jUserPword]") }
		loginButton 	{  $("a[id=greenButton]") }
		loginError		{ $( "div", class: "FormGradientBgContent" ).find( "a", text: "Click here to try again." ) }
    }
}
