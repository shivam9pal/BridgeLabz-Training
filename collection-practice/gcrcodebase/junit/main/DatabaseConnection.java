package JUnit_demo.JUnit;

public class DatabaseConnection {
	private boolean connected = false;
	
	public void connect() {
		connected=true;
		System.out.println("Connected Successfully");
	}
	
	public void disconnect() {
		connected=false;
		System.out.println("disconnected Successfully");
	}
	
	public boolean isConnected() {
		return connected;
	}
}
