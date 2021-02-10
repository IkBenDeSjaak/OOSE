package nl.han.ica.oose.dea;

public class OrdersWriter {
    private Orders orders;

    public OrdersWriter(Orders orders) {
        this.orders = orders;
    }

    public String getContents() {
        StringBuffer ordersJsonString = new StringBuffer("{\"orders\": [");

        for (int i = 0; i < orders.getOrdersCount(); i++) {
            Order order = orders.getOrder(i);
            ordersJsonString.append("{\"id\": ");
            ordersJsonString.append(order.getOrderId());
            ordersJsonString.append(", \"products\": [");
            for (int j = 0; j < order.getProductsCount(); j++) {
                Product product = order.getProduct(j);

                ordersJsonString.append("{\"code\": \"");
                ordersJsonString.append(product.getCode());
                ordersJsonString.append("\", \"color\": \"");
                ordersJsonString.append(product.getColorString());
                ordersJsonString.append("\", ");

                if (product.getSize() != product.SIZE_NOT_VALID) {
                    ordersJsonString.append("\"size\": \"");
                    ordersJsonString.append(product.getSizeString());
                    ordersJsonString.append("\", ");
                }

                ordersJsonString.append("\"price\": ");
                ordersJsonString.append(product.getPrice());
                ordersJsonString.append(", \"currency\": \"");
                ordersJsonString.append(product.getCurrency());
                ordersJsonString.append("\"}, ");
            }

            if (order.getProductsCount() > 0) {
                ordersJsonString.delete(ordersJsonString.length() - 2, ordersJsonString.length());
            }

            ordersJsonString.append("]}, ");
        }

        if (orders.getOrdersCount() > 0) {
            ordersJsonString.delete(ordersJsonString.length() - 2, ordersJsonString.length());
        }

        ordersJsonString.append("]}");

        return ordersJsonString.toString();
    }
}
