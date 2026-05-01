package models;

public class TransactionRequest {

    public int amount_in_cents;
    public String currency;
    public String customer_email;
    public PaymentMethod payment_method;

    public static class PaymentMethod {
        public String type;
    }
}