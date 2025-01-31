package pl.edu.vistula.firstrestapispring.product.api;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.vistula.firstrestapispring.product.api.request.ProductRequest;
import pl.edu.vistula.firstrestapispring.product.api.response.ProductResponse;
import pl.edu.vistula.firstrestapispring.product.service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) { this.productService = productService; }
    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest productRequest) {
    ProductResponse productResponse = productService.create(productRequest);
    return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
    }
@PutMapping("/{id}")
@Operation(summary = "Update product")
public ResponseEntity<ProductResponse> update (@PathVariable Long id, @RequestBody UpdateProductRequest updateProductRequest) {
        List<ProductResponse> productResponses = productService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }
}
@Operation(summary = "Delete item")
public ResponseEntity<Void> delete(@PathVariable Long id){
    productService.delete(id);
    return ResponseEntity.noContent().build();
}