package week02.scenario.digitalwalletsystem;

public class User {

    private int userId;
    private String userName;
    private String email;
    private String phoneNumber;
    private String accountStatus;
    private String registrationDate;

    public User(int userId, String userName, String email, String phoneNumber) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.accountStatus = "ACTIVE";
        this.registrationDate = new java.time.LocalDate.now().toString();
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String status) {
        this.accountStatus = status;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    @Override
    public String toString() {
        return "User ID: " + userId
                + " | Name: " + userName
                + " | Email: " + email
                + " | Phone: " + phoneNumber
                + " | Status: " + accountStatus
                + " | Registered: " + registrationDate;
    }
}
