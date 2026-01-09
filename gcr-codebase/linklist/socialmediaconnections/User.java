package week3dsa.linkedlist.socialmediaconnections;

import java.util.ArrayList;
import java.util.List;

// Node class representing a user
class User {
    int userId;
    String name;
    int age;
    List<Integer> friendIds; // List of friend user IDs
    
    User next;
    
    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
    
    @Override
    public String toString() {
        return String.format("ID: %d | Name: %s | Age: %d | Friends: %d", 
                            userId, name, age, friendIds.size());
    }
}
