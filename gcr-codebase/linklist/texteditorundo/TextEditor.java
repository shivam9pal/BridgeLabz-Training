package week3dsa.linkedlist.texteditorundo;

public class TextEditor {
    
    private TextState current;
    private int maxHistorySize;
    private int currentSize;
    
    public TextEditor(int maxHistorySize) {
        this.current = new TextState(""); // Start with empty text
        this.maxHistorySize = maxHistorySize;
        this.currentSize = 1;
    }
    
    // Add new text state
    public void addState(String content) {
        TextState newState = new TextState(content);
        
        // Clear any redo history
        current.next = null;
        
        // Link new state
        newState.prev = current;
        current.next = newState;
        current = newState;
        currentSize++;
        
        // Maintain max history size
        if (currentSize > maxHistorySize) {
            removeOldest();
        }
        
        System.out.println("✓ Text state saved");
    }
    
    // Remove oldest state to maintain size limit
    private void removeOldest() {
        TextState temp = current;
        
        // Go to the beginning
        while (temp.prev != null) {
            temp = temp.prev;
        }
        
        // Remove first node
        if (temp.next != null) {
            temp.next.prev = null;
            currentSize--;
        }
    }
    
    // Undo - revert to previous state
    public void undo() {
        if (current.prev == null) {
            System.out.println("✗ Nothing to undo!");
            return;
        }
        
        current = current.prev;
        System.out.println("✓ Undo successful");
        displayCurrent();
    }
    
    // Redo - go to next state after undo
    public void redo() {
        if (current.next == null) {
            System.out.println("✗ Nothing to redo!");
            return;
        }
        
        current = current.next;
        System.out.println("✓ Redo successful");
        displayCurrent();
    }
    
    // Display current text state
    public void displayCurrent() {
        System.out.println("\n=== Current Text ===");
        if (current.content.isEmpty()) {
            System.out.println("[Empty]");
        } else {
            System.out.println(current.content);
        }
        System.out.println("====================\n");
    }
    
    // Display history statistics
    public void displayHistory() {
        TextState temp = current;
        
        // Go to beginning
        while (temp.prev != null) {
            temp = temp.prev;
        }
        
        System.out.println("\n=== History ===");
        int position = 1;
        
        while (temp != null) {
            String marker = (temp == current) ? " <- CURRENT" : "";
            String preview = temp.content.length() > 50 ? 
                           temp.content.substring(0, 50) + "..." : temp.content;
            
            if (preview.isEmpty()) {
                preview = "[Empty]";
            }
            
            System.out.println(position + ". " + preview + marker);
            temp = temp.next;
            position++;
        }
        System.out.println("===============\n");
    }
    
    // Get current text content
    public String getCurrentContent() {
        return current.content;
    }
}
