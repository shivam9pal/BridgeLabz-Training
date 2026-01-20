package week03.scenariobased.browserbuddy;

class Browser {
	
	
	public static void main(String[] args) {

        BrowserManager browser = new BrowserManager();
        Tab tab = browser.getActiveTab();

        tab.visit("google.com");
        tab.visit("openai.com");
        tab.visit("github.com");

        tab.back();
        tab.back();
        tab.forward();
        // Save tab in stack
        browser.closeTab();  
        
        // Restore last closed tab
        browser.restoreTab(); 
        Tab restored = browser.getActiveTab();
        System.out.println("Active Page: " + restored.getCurrentPage());
    }
}
