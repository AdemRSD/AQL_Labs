package TP3.Partie1.Exo3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private ProductApiClient productApiClient;

    @Test
    void testGetProduct_SuccessfulRetrieval_CallsApiWithCorrectId() {
        // Arrange
        String productId = "P123";
        Product expectedProduct = new Product(productId, "Laptop");
        when(productApiClient.getProduct(productId)).thenReturn(expectedProduct);
        ProductService productService = new ProductService(productApiClient);

        // Act
        Product actualProduct = productService.getProduct(productId);

        // Assert
        assertNotNull(actualProduct);
        assertEquals(expectedProduct.getId(), actualProduct.getId());
        assertEquals(expectedProduct.getName(), actualProduct.getName());
        verify(productApiClient).getProduct(productId);
    }

    @Test
    void testGetProduct_IncompatibleDataFormat_ThrowsException() {
        // Arrange
        String productId = "P123";
        when(productApiClient.getProduct(productId)).thenThrow(new RuntimeException("Incompatible data format"));
        ProductService productService = new ProductService(productApiClient);

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            productService.getProduct(productId);
        });
        assertEquals("Incompatible data format", exception.getMessage());
        verify(productApiClient).getProduct(productId);
    }

    @Test
    void testGetProduct_ApiCallFailure_ThrowsException() {
        // Arrange
        String productId = "P123";
        when(productApiClient.getProduct(productId)).thenThrow(new RuntimeException("API call failed: Network error"));
        ProductService productService = new ProductService(productApiClient);

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            productService.getProduct(productId);
        });
        assertEquals("API call failed: Network error", exception.getMessage());
        verify(productApiClient).getProduct(productId);
    }
}
