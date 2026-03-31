package week02.scenario.futurelogistics;


public class Utility {

    public GoodsTransport parseDetails(String input) {

        // Format:
        // RTS120A:12/8/21:5:BrickTransport:6:800:40

        String[] parts = input.split(":");

        String transportId = parts[0];
        String date = parts[1];
        int rating = Integer.parseInt(parts[2]);
        String type = parts[3];

        validateTransportId(transportId);

        if (type.equalsIgnoreCase("BrickTransport")) {
            float brickSize = Float.parseFloat(parts[4]);
            int brickQty = Integer.parseInt(parts[5]);
            float brickPrice = Float.parseFloat(parts[6]);

            return new BrickTransport(transportId, date, rating,
                    brickSize, brickQty, brickPrice);
        }

        if (type.equalsIgnoreCase("TimberTransport")) {
            float length = Float.parseFloat(parts[4]);
            float radius = Float.parseFloat(parts[5]);
            String timberType = parts[6];
            float timberPrice = Float.parseFloat(parts[7]);

            return new TimberTransport(transportId, date, rating,
                    length, radius, timberType, timberPrice);
        }

        return null;
    }

    public boolean validateTransportId(String transportId) {

        String pattern = "RTS[0-9]{3}[A-Z]";

        if (!transportId.matches(pattern)) {
            System.out.println("Transport id " + transportId + " is invalid");
            System.out.println("Please provide a valid record");
            throw new RuntimeException(); // terminates flow without System.exit
        }

        return true;
    }

    public String findObjectType(GoodsTransport goodsTransport) {
        if (goodsTransport instanceof TimberTransport) {
            return "TimberTransport";
        }
        if (goodsTransport instanceof BrickTransport) {
            return "BrickTransport";
        }
        return "Unknown";
    }
}

