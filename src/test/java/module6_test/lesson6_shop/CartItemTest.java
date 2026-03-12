package module6_test.lesson6_shop;


import module6_test.lesson6_shop.model.CartItem;
import module6_test.lesson6_shop.model.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CartItemTest {

    @Test
    void testGetProduct() {
        Product product = new Product("1", "Product 1", 10.0);
        CartItem cartItem = new CartItem(product, 2);

        assertEquals(product, cartItem.getProduct());
    }

    @Test
    void testGetQuantity() {
        Product product = new Product("1", "Product 1", 10.0);
        CartItem cartItem = new CartItem(product, 2);

        assertEquals(2, cartItem.getQuantity());
    }

    @Test
    void testSetQuantity() {
        Product product = new Product("1", "Product 1", 10.0);
        CartItem cartItem = new CartItem(product, 2);
        cartItem.setQuantity(3);

        assertEquals(3, cartItem.getQuantity());
    }

    @Test
    void testNegativeQuantity() {
        Product product = new Product("1", "Product 1", 10.0);
        CartItem cartItem = new CartItem(product, 2);
        assertThrows(IllegalArgumentException.class, () -> cartItem.setQuantity(-1));
    }
}