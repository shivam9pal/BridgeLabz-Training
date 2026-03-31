package week3dsa.linkedlist.texteditorundo;

// Node class for text state
class TextState {
    String content;
    
    TextState next; // For redo
    TextState prev; // For undo
    
    public TextState(String content) {
        this.content = content;
        this.next = null;
        this.prev = null;
    }
}
