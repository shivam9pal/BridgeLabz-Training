package week02.scenario.studentcourseregistration;

public abstract class Person {

    protected int personId;
    protected String name;
    protected String email;
    protected String phone;

    public Person(int personId, String name, String email, String phone) {
        this.personId = personId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public int getPersonId() {
        return personId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public abstract String getRole();

    @Override
    public String toString() {
        return "ID: " + personId
                + " | Name: " + name
                + " | Email: " + email
                + " | Phone: " + phone
                + " | Role: " + getRole();
    }
}
