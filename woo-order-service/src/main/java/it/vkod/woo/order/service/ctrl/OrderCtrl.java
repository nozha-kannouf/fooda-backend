package it.vkod.woo.order.service.ctrl;

import org.springframework.web.bind.annotation.*;

public interface OrderCtrl<RES, REQ> {

    @GetMapping("all/{page}")
    RES[] apiGetOrdersAll(@PathVariable("page") final int page);

    @GetMapping("{id}")
    RES apiGetOrderOne(@PathVariable("id") final long id);

    @PostMapping
    void apiPostOrderOne(@RequestBody final REQ order);

    @PutMapping("{id}")
    void apiPutOrderOne(@PathVariable("id") final long id, @RequestBody final REQ order);

    @DeleteMapping("{id}")
    void apiDeleteOrderOne(@PathVariable("id") final long id);

}
