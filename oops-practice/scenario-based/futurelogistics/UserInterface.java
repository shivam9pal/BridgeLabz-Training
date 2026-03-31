package week02.scenario.futurelogistics;

import java.util.Scanner;

public class UserInterface {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Utility util = new Utility();

        try {
            System.out.println("Enter the Goods Transport details");
            String input = sc.nextLine();

            GoodsTransport gt = util.parseDetails(input);

            String type = util.findObjectType(gt);

            System.out.println("Transporter id : " + gt.getTransportId());
            System.out.println("Date of transport : " + gt.getTransportDate());
            System.out.println("Rating of the transport : " + gt.getTransportRating());

            if (type.equals("BrickTransport")) {
                BrickTransport bt = (BrickTransport) gt;

                System.out.println("Quantity of bricks : " + bt.getBrickQuantity());
                System.out.println("Brick price : " + bt.getBrickPrice());
                System.out.println("Vehicle for transport : " + bt.vehicleSelection());
                System.out.println("Total charge : " + bt.totalCharge());

            } else if (type.equals("TimberTransport")) {
                TimberTransport tt = (TimberTransport) gt;

                System.out.println("Vehicle for transport : " + tt.vehicleSelection());
                System.out.println("Total charge : " + tt.totalCharge());
            }

        } catch (RuntimeException e) {
            // Flow ends naturally as per requirement
        } finally {
            sc.close();
        }
    }
}
