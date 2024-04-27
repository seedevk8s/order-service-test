package co.kr.ideacube.orderservicetest.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.kr.ideacube.orderservicetest.models.Order;
import co.kr.ideacube.orderservicetest.services.OrderService;

@RestController
@RequestMapping(value = "/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(path = "/orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok().body(orderService.getOrders());
    }

    @PostMapping(path = "/orders")
    public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
        Order newOrder = orderService.createOrder(order);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

    @GetMapping(path = "/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok().body(orderService.getOrderById(id));
    }

    @DeleteMapping(path = "/orders/{id}")
    public ResponseEntity<String> deleteOrderById(@PathVariable Long id) {
        boolean deleteOrderById = orderService.deleteOrderById(id);
        if (deleteOrderById) {
            return new ResponseEntity<>(("Order deleted - Order ID:" + id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(("Order deletion failed - Order ID:" + id), HttpStatus.BAD_REQUEST);
        }
    }

}