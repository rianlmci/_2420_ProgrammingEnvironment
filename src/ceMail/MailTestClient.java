package ceMail;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;

public class MailTestClient {

	public static void main(String[] args) {
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
		
		StdOut.println("Original array allMail:");
		for (Mail m : allMail) {
			StdOut.println(m);
		}
		StdOut.println();
		
		StdOut.println("Sorted array allMail:");
		Arrays.sort(allMail);
		for (Mail m : allMail) {
			StdOut.println(m);
		}
		StdOut.println();
	}

}
