package week3dsa.linkedlist.texteditorundo;

import java.util.Scanner;

public class TextEditorSystem {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter max history size: ");
        int maxSize = sc.nextInt();
        sc.nextLine();
        
        TextEditor editor = new TextEditor(maxSize);
        
        while (true) {
            System.out.println("\n===== Text Editor (Undo/Redo) =====");
            System.out.println("1. Type/Edit Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display Current Text");
            System.out.println("5. Display History");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.println("Current text: " + editor.getCurrentContent());
                    System.out.print("Enter new text: ");
                    String newText = sc.nextLine();
                    editor.addState(newText);
                    break;
                    
                case 2:
                    editor.undo();
                    break;
                    
                case 3:
                    editor.redo();
                    break;
                    
                case 4:
                    editor.displayCurrent();
                    break;
                    
                case 5:
                    editor.displayHistory();
                    break;
                    
                case 6:
                    System.out.println("Thank you!");
                    sc.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
