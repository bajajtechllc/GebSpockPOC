package com.st.rm
import geb.Page

class HomePage extends Page {

	// This is our verification that we are on the right page
    static at = { title == "Rate Management" }

	// This is the content for the page
    static content = {
    }
}
