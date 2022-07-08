package com.ProjetoIntegrador.FazSolidaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProjetoIntegrador.FazSolidaria.dto.Purchase;
import com.ProjetoIntegrador.FazSolidaria.dto.PurchaseResponse;
import com.ProjetoIntegrador.FazSolidaria.services.CheckoutService;

@RestController
@RequestMapping("/api/checkout")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class checkoutController {
	
	@Autowired
	private CheckoutService checkoutService;


    public checkoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse purchase(@RequestBody Purchase purchase){
        PurchaseResponse response = this.checkoutService.placeOrder(purchase);
        System.out.println("Chegou aqui no controller do checkout");
        return response;
    }

}
