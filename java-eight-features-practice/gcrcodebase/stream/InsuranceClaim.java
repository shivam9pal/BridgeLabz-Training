package week06.gcrcodebase.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Claim {
    String type;     // Health, Vehicle, Property
    double amount;

    public Claim(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }
}

class InsuranceClaim {
	public static void main(String[] args) {
		List<Claim> claims = Arrays.asList(
                new Claim("Health", 5000),
                new Claim("Vehicle", 8000),
                new Claim("Health", 7000),
                new Claim("Property", 12000),
                new Claim("Vehicle", 6000),
                new Claim("Health", 9000)
        );
		
		Map<String, Double> averageByType=claims.stream()
												.collect(Collectors.groupingBy(c->c.type,
																					Collectors.averagingDouble(c->c.amount)));
		
		averageByType.forEach((type, avg)->System.out.println(type + " Average Claim: " + avg));
	}
}
