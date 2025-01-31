package shared.api.response;

public class ErrorMessageResponse {
    private final String message;
    public ErrorMessageResponse(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    public ProductResponse update(Long id, UpdateProductRequest update ProductRequest){
        Product product = productRepository.findById(id).orElseThrow(
                ProductExceptionSupplier.productNotFound(id));
        productRepository.save(productMapper.toProduct(product, updateProductRequest));
        return productMapper.toProductResponse(product);
    }
}
