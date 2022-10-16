package ceMail;

import edu.princeton.cs.algs4.MaxPQ;

public class DemoHeap {
    public static void main(String [] args) {
        Mail[] allMail = {
                new Mail(DeliveryType.AIR, "YTWEW"),
                new Mail(DeliveryType.GROUND, "ASDFF"),
                new Mail(DeliveryType.AIR, "ASDFG"),
                new Mail(DeliveryType.TWO_DAY, "UIOPY"),
                new Mail(DeliveryType.ONE_DAY, "ASDFG"),
                new Mail(DeliveryType.GROUND, "ZXCVB"),
                new Mail(DeliveryType.GROUND, "AAABB"),
                new Mail(DeliveryType.AIR, "IUYTR"),
                new Mail(DeliveryType.TWO_DAY, "SKDIU"),
                new Mail(DeliveryType.PRIORITY, "PQOWI"),
        };

        MaxPQ<Mail> pq = new MaxPQ<>(allMail);
        for (int i = pq.size(); i > 0; i--) {
            System.out.println(pq.delMax());
        }
    }
}
