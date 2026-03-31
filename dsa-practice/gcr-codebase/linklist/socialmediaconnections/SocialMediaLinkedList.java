package week3dsa.linkedlist.socialmediaconnections;

import java.util.ArrayList;
import java.util.List;

public class SocialMediaLinkedList {
    
    private User head;
    
    public SocialMediaLinkedList() {
        this.head = null;
    }
    
    // Add user
    public void addUser(int userId, String name, int age) {
        // Check if user already exists
        if (findUser(userId) != null) {
            System.out.println("✗ User ID already exists!");
            return;
        }
        
        User newUser = new User(userId, name, age);
        
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
        System.out.println("✓ Added user: " + name);
    }
    
    // Helper to find user by ID
    private User findUser(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    
    // Add friend connection
    public void addFriendConnection(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);
        
        if (user1 == null || user2 == null) {
            System.out.println("✗ One or both users not found!");
            return;
        }
        
        if (user1.friendIds.contains(userId2)) {
            System.out.println("✗ Already friends!");
            return;
        }
        
        user1.friendIds.add(userId2);
        user2.friendIds.add(userId1);
        System.out.println("✓ Friend connection added between " + user1.name + " and " + user2.name);
    }
    
    // Remove friend connection
    public void removeFriendConnection(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);
        
        if (user1 == null || user2 == null) {
            System.out.println("✗ One or both users not found!");
            return;
        }
        
        user1.friendIds.remove(Integer.valueOf(userId2));
        user2.friendIds.remove(Integer.valueOf(userId1));
        System.out.println("✓ Friend connection removed");
    }
    
    // Find mutual friends
    public void findMutualFriends(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);
        
        if (user1 == null || user2 == null) {
            System.out.println("✗ One or both users not found!");
            return;
        }
        
        List<Integer> mutualFriends = new ArrayList<>();
        
        for (int friendId : user1.friendIds) {
            if (user2.friendIds.contains(friendId)) {
                mutualFriends.add(friendId);
            }
        }
        
        System.out.println("\nMutual friends between " + user1.name + " and " + user2.name + ":");
        if (mutualFriends.isEmpty()) {
            System.out.println("  No mutual friends");
        } else {
            for (int friendId : mutualFriends) {
                User friend = findUser(friendId);
                System.out.println("  " + friend.name + " (ID: " + friendId + ")");
            }
        }
    }
    
    // Display all friends of a user
    public void displayFriends(int userId) {
        User user = findUser(userId);
        
        if (user == null) {
            System.out.println("✗ User not found!");
            return;
        }
        
        System.out.println("\nFriends of " + user.name + ":");
        if (user.friendIds.isEmpty()) {
            System.out.println("  No friends yet");
        } else {
            for (int friendId : user.friendIds) {
                User friend = findUser(friendId);
                if (friend != null) {
                    System.out.println("  " + friend.name + " (ID: " + friendId + ")");
                }
            }
        }
    }
    
    // Search user by name
    public void searchByName(String name) {
        if (head == null) {
            System.out.println("✗ No users in the system!");
            return;
        }
        
        User temp = head;
        boolean found = false;
        System.out.println("\nUsers matching '" + name + "':");
        
        while (temp != null) {
            if (temp.name.toLowerCase().contains(name.toLowerCase())) {
                System.out.println("  " + temp);
                found = true;
            }
            temp = temp.next;
        }
        
        if (!found) {
            System.out.println("  No users found");
        }
    }
    
    // Search user by ID
    public void searchById(int userId) {
        User user = findUser(userId);
        
        if (user != null) {
            System.out.println("✓ User found: " + user);
        } else {
            System.out.println("✗ User not found with ID: " + userId);
        }
    }
    
    // Count friends for a user
    public void countFriends(int userId) {
        User user = findUser(userId);
        
        if (user == null) {
            System.out.println("✗ User not found!");
            return;
        }
        
        System.out.println(user.name + " has " + user.friendIds.size() + " friend(s)");
    }
    
    // Display all users
    public void displayAllUsers() {
        if (head == null) {
            System.out.println("✗ No users in the system.");
            return;
        }
        
        System.out.println("\n=== All Users ===");
        User temp = head;
        int position = 1;
        
        while (temp != null) {
            System.out.println(position + ". " + temp);
            temp = temp.next;
            position++;
        }
        System.out.println("=================\n");
    }
}
