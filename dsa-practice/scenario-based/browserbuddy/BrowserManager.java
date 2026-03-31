package week03.scenariobased.browserbuddy;

import java.util.Stack;

class BrowserManager {
	private Tab activeTab = new Tab();
    private Stack<Tab> closedTabs = new Stack<>();
    
    Tab getActiveTab() {
        return activeTab;
    }
    
    // Close current tab
    void closeTab() {
        closedTabs.push(activeTab);
        activeTab = new Tab();
        System.out.println("Tab closed.");
    }
    
    // Restore last closed tab
    void restoreTab() {
        if (closedTabs.isEmpty()) {
            System.out.println("No closed tabs to restore.");
            return;
        }
        activeTab = closedTabs.pop();
        System.out.println("Tab restored. Current page: " + activeTab.getCurrentPage());
    }
}
