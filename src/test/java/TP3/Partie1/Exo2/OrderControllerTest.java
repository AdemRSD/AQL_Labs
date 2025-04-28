package TP3.Partie1.Exo2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderControllerTest {
    @Mock
    private OrderService orderService;

    @Mock
    private OrderDao orderDao;

    @Test
    void testCreateOrder_CallsServiceAndDaoWithCorrectOrder() {
        // Arrange
        Order order = new Order(1L, "Laptop");
        OrderController orderController = new OrderController(orderService);

        // Act
        orderController.createOrder(order);

        // Assert
        verify(orderService).createOrder(order);
        verify(orderDao, never()).saveOrder(order); // Pas d'appel direct à orderDao depuis OrderController
    }

    @Test
    void testCreateOrder_FullChain_CallsServiceAndDao() {
        // Arrange
        Order order = new Order(1L, "Laptop");
        OrderService realOrderService = new OrderService(orderDao);
        OrderController orderController = new OrderController(realOrderService);

        // Act
        orderController.createOrder(order);

        // Assert
        verify(orderDao).saveOrder(order); // Vérifie que orderDao est appelé via la vraie OrderService
    }
}