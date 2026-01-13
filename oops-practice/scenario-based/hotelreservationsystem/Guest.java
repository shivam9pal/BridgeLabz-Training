package week02.scenario.hotelreservationsystem;

class Guest {
    private final String id;
    private String name;
    private String phone;

    public Guest(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public String getId() { return id; }
    public String getName() { return name; }
}
