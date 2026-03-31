package week03.scenariobased.browserbuddy;

class Tab {
	private Page current;
	
	
	// Visit a new page
    void visit(String url) {
        Page newPage = new Page(url);

        if (current != null) {
            current.next = null;   
            // Clear forward history
            newPage.prev = current;
            current.next = newPage;
        }
        current = newPage;
        System.out.println("Visited: " + url);
    }
    
    // Back navigation
    void back() {
        if (current == null || current.prev == null) {
            System.out.println("No page to go back.");
            return;
        }
        current = current.prev;
        System.out.println("Back to: " + current.url);
    }
    
    // Forward navigation
    void forward() {
        if (current == null || current.next == null) {
            System.out.println("No page to go forward.");
            return;
        }
        current = current.next;
        System.out.println("Forward to: " + current.url);
    }
    
    String getCurrentPage() {
        return current != null ? current.url : "Empty Tab";
    }
}
