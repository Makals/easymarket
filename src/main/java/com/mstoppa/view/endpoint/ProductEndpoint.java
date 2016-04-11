package com.mstoppa.view.endpoint;

import com.mstoppa.model.Product;
import com.mstoppa.service.ProductService;
import com.mstoppa.view.resource.ProductResource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductEndpoint {

    @Autowired
    private ProductService productService;

    @RequestMapping("/products/{productId}")
    public ProductResource getProduct(@PathVariable Long productId) {
        Product product = productService.getProduct(productId);

        ProductResource productResource = new ProductResource();
        BeanUtils.copyProperties(product, productResource);

        return productResource;
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ProductResource createProduct(@RequestBody ProductResource productResource) {
        Product product = new Product();

        BeanUtils.copyProperties(productResource, product);

        product = productService.createProduct(product);

        BeanUtils.copyProperties(product, productResource);

        return productResource;
    }
}
