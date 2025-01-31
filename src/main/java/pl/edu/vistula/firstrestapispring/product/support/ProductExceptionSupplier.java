package pl.edu.vistula.firstrestapispring.product.support.exception.ProductNotFoundException;

import pl.edu.vistula.firstrestapispring.product.support.exception.ProductNotFoundException;

import java.util.funcition.Supplier;

public class ProductExceptionSupplier {
    public static Supplier<ProductNotFoundException> productNotFound(Long id) {
        return () -> new ProductNotFoundException(id);
    }
}
