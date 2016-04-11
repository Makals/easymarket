package com.mstoppa.view.endpoint;

import com.mstoppa.model.Offer;
import com.mstoppa.service.BuyListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BuyListEndpoint {

    @Autowired
    private BuyListService buyListService;

    @RequestMapping("/buylist")
    public List<Offer> getBuyList() {
        return buyListService.buildBuyList();
    }
}
