package com.mstoppa.service;

import com.mstoppa.model.Offer;
import com.mstoppa.service.crawler.StoreCrawler;
import com.mstoppa.service.crawler.StoreCrawlerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuyListService {

    @Autowired
    private StoreCrawlerFactory storeCrawlerFactory;

    @Autowired
    private OfferService offerService;

    public List<Offer> buildBuyList() {
        List<Offer> offers = updateOffers();

        List<Offer> bestOffers = offers.stream()
                .filter(offer -> offer.isAvailable())
                .filter(offer -> offer.getPrice() != null)
                .collect(Collectors.groupingBy(Offer::getProduct)).entrySet().stream()
                .map(entry -> entry.getValue().stream().min(Comparator.comparingDouble(Offer::getPrice)).get())
                .collect(Collectors.toList());

        return bestOffers;
    }

    public List<Offer> updateOffers() {
        List<Offer> offers = offerService.listOffers();

        for (Offer offer : offers) {
            StoreCrawler storeCrawler = storeCrawlerFactory.getStoreCrawler(offer.getStore());

            storeCrawler.updateOffer(offer);

            offerService.updateOffer(offer);
        }

        return offers;
    }
}
