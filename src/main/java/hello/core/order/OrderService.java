package hello.core.order;

public interface OrderService {
    Order createeOrder(Long memberId, String itemName, int itemPrice);
}
