interface CouponValidator {

    void validateCoupon(String code);

    static boolean isLengthValid(String code) {
        return code.length() >= 5 && code.length() <= 10;
    }
}

public class ShoppingCart implements CouponValidator {

    public void validateCoupon(String code) {
        if (CouponValidator.isLengthValid(code)) {
            System.out.println(code + " : Valid Coupon");
        } else {
            System.out.println(code + " : Invalid Coupon");
        }
    }

    public static void main(String[] args) {
        String[] coupons = {
            "SAVE10",
            "AB12",
            "WELCOME",
            "BIGDISCOUNT",
            "OFF50"
        };

        ShoppingCart cart = new ShoppingCart();

        for (String coupon : coupons) {
            cart.validateCoupon(coupon);
        }
    }
}