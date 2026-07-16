class Order {
    protected String orderId;
    protected String orderDate;

    public Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return "Order Placed";
    }
}

class ShippedOrder extends Order {
    protected String trackingNumber;

    public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    public String getOrderStatus() {
        return "Order Shipped";
    }
}

class DeliveredOrder extends ShippedOrder {
    private String deliveryDate;

    public DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    public String getOrderStatus() {
        return "Order Delivered";
    }

    public void displayDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Tracking Number: " + trackingNumber);
        System.out.println("Delivery Date: " + deliveryDate);
        System.out.println("Status: " + getOrderStatus());
    }
}

public class OrderManagementDemo {
    public static void main(String[] args) {
        Order order = new Order("ORD1001", "24-06-2026");
        ShippedOrder shippedOrder = new ShippedOrder("ORD1002", "23-06-2026", "TRK5678");
        DeliveredOrder deliveredOrder = new DeliveredOrder("ORD1003", "20-06-2026", "TRK9999", "24-06-2026");

        System.out.println("Base Order Status: " + order.getOrderStatus());
        System.out.println("Shipped Order Status: " + shippedOrder.getOrderStatus());
        deliveredOrder.displayDetails();
    }
}
