package it.vkod.woo.product.service.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icoderman.woocommerce.EndpointBaseType;
import com.icoderman.woocommerce.WooCommerce;
import it.vkod.woo.product.service.pojo.req.WooProductRequest;
import it.vkod.woo.product.service.pojo.res.WooProductResponse;
import it.vkod.woo.product.service.utils.EnvUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/products")
public class WooProductController implements ProductController<WooProductResponse, WooProductRequest> {

    @Value("${store.id}")
    private long storeId;

    @Value("${store.ck}")
    private String ck;

    @Value("${store.cs}")
    private String cs;

    @Value("${store.url}")
    private String url;

    private final WooCommerce woo;
    private final EnvUtil env;
    private final ObjectMapper mapper;

    public WooProductController(WooCommerce woo, EnvUtil env, ObjectMapper mapper) {
        this.woo = woo;
        this.env = env;
        this.mapper = mapper;
    }

    @Override
    public WooProductResponse[] apiGetProductsAll(final int page) {
        Map<String, String> params = new HashMap<>();
        params.put("per_page", "10");
        params.put("offset", String.valueOf(page));
        @SuppressWarnings("unchecked")    // we'll throw an exception from service to simulate a failure
        final List<Map<String, Object>> productListMap = woo.getAll(EndpointBaseType.PRODUCTS.getValue(), params);
        final WooProductResponse[] wooProductResponses = mapper.convertValue(productListMap, WooProductResponse[].class);
        Arrays.stream(wooProductResponses).forEach(wooProductResponse -> {
            wooProductResponse.setStoreId(storeId);
            wooProductResponse.setRestUrl(env.getHostname() + ":" + env.getPort());
        });
        return wooProductResponses;
    }

    @Override
    public WooProductResponse[] apiGetProductsSearch(String search) {
        Map<String, String> params = new HashMap<>();
        params.put("per_page", "10"); // it was 100 by default ..
        params.put("offset", "0");
        params.put("search", search);
        @SuppressWarnings("unchecked") final List<Map<String, Object>> productListMap = woo.getAll(EndpointBaseType.PRODUCTS.getValue(), params);
        final WooProductResponse[] wooProductResponses = mapper.convertValue(productListMap, WooProductResponse[].class);
        Arrays.stream(wooProductResponses).forEach(wooProductResponse -> {
            wooProductResponse.setStoreId(storeId);
            wooProductResponse.setRestUrl(env.getHostname() + ":" + env.getPort());
        });
        return wooProductResponses;
    }

    @Override
    public WooProductResponse[] apiGetProductsSearch(double min, double max) {
        Map<String, String> params = new HashMap<>();
        params.put("per_page", "10");
        params.put("offset", "0");
        params.put("min_price", String.valueOf(min));
        params.put("max_price", String.valueOf(max));
        @SuppressWarnings("unchecked")    // we'll throw an exception from service to simulate a failure
        final List<Map<String, Object>> productListMap = woo.getAll(EndpointBaseType.PRODUCTS.getValue(), params);
        final WooProductResponse[] wooProductResponses = mapper.convertValue(productListMap, WooProductResponse[].class);
        Arrays.stream(wooProductResponses).forEach(wooProductResponse -> {
            wooProductResponse.setStoreId(storeId);
            wooProductResponse.setRestUrl(env.getHostname() + ":" + env.getPort());
        });
        return wooProductResponses;
    }

    @Override
    public WooProductResponse apiGetProductOne(final long id) {
        @SuppressWarnings("unchecked")    // we'll throw an exception from service to simulate a failure
                Map<String, Object> productMap = woo.get(EndpointBaseType.PRODUCTS.getValue(), (int) id);
        final WooProductResponse wooProductResponse = mapper.convertValue(productMap, WooProductResponse.class);
        wooProductResponse.setStoreId(storeId);
        wooProductResponse.setRestUrl(env.getHostname() + ":" + env.getPort());
        return wooProductResponse;
    }

    @Override
    public void apiPostProductAll(WooProductRequest[] products) {
        Arrays.stream(products).forEach(this::apiPostProductOne);
    }

    @Override
    public void apiPostProductOne(WooProductRequest product) {
        final Map<String, Object> productMap = mapper.convertValue(product, new TypeReference<Map<String, Object>>() {
        });
        woo.create(EndpointBaseType.PRODUCTS.getValue(), productMap);
    }

    @Override
    public void apiPutProductAll(WooProductRequest[] products) {
        Arrays.stream(products).forEach(product -> apiPutProductOne(Long.parseLong(String.valueOf(product.getId())), product));
    }

    @Override
    public void apiPutProductOne(long id, WooProductRequest product) {
        final Map<String, Object> productMap = mapper.convertValue(product, new TypeReference<Map<String, Object>>() {
        });
        woo.update(EndpointBaseType.PRODUCTS.getValue(), (int) id, productMap);
    }

    @Override
    public void apiDeleteProductOne(long id) {
        woo.delete(EndpointBaseType.PRODUCTS.getValue(), (int) id);
    }

    @Override
    public void apiDeleteProductAll(long... ids) {
        Arrays.stream(ids).forEach(this::apiDeleteProductOne);
    }
}