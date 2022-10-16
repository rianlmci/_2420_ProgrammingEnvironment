package ceMail;

import java.util.Random;

public class Mail implements Comparable <Mail>{
    private DeliveryType type;
    private String mailCode;
    private Random rand = new Random();

    public Mail(DeliveryType type, String mailCode){
        this.type = type;
        this.mailCode = mailCode;
    }

    public Mail(){

    }

    /**
     * Creates a random code that consists of 5 random upper-case letters
     * @return
     */
    private String randomMailCode(){

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            sb.append((char)('A') + rand.nextInt(26));
        }
        return sb.toString();
    }

    private DeliveryType randomType(){
        return DeliveryType.GROUND; //TODO
    }

    @Override
    public String toString() {
        //TODO
        return mailCode + "(" + type + ")";
    }

    @Override
    public int compareTo(Mail otherMail) {
        return this.type.compareTo(otherMail.type);
    }
}
