package week08.scenariobased.onlineauctionsystem;

import java.util.Objects;

class User {
	private String name;
	private String id;
	
	public User () {
	}
	public User(String name, String userId) {
		this.name=name;
		this.id=userId;
	}
	
	public String getName() {
		return name;
	}
	
	public String getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setId() {
		this.id=id;	
	}
	
	@Override
	public boolean equals(Object o) {
		if(this==o) return true;
		if(!(o instanceof User)) return false;
		User user=(User) o;
		return Objects.equals(id, user.id);
	}
	
	public int hashcode() {
		return Objects.hash(id);
	}
	
}
