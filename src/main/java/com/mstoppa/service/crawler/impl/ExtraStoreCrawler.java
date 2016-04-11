package com.mstoppa.service.crawler.impl;

import com.mstoppa.model.Offer;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Locale;

public class ExtraStoreCrawler extends AbstractStoreCrawler {

    @Override
    protected void updateProductPrice(Offer offer, Document doc) {
        Elements eProductPrice = doc.select(".box-price .price-off .sale-price, .box-price.boxNoOffer .price-off");

        Double productPrice = null;
        try {
            String sProductPrice = eProductPrice.text().replaceAll("[^\\d,]", "");

            productPrice = DecimalFormat.getNumberInstance(Locale.GERMAN).parse(sProductPrice).doubleValue();
        } catch (ParseException exception) {
            exception.printStackTrace();
        }

        productPrice = checkPromotions(doc, offer, productPrice);

        offer.setPrice(productPrice);
    }

    @Override
    protected void updateProductAvailability(Offer offer, Document doc) {
        offer.setAvailable(doc.select(".semEstoque").isEmpty());
    }

    private Double checkPromotions(Document doc, Offer offer, Double productPrice) {
        if (!doc.select(".box-price .economia123_product").isEmpty()) {
            offer.setPromotion(true);

            productPrice *= 0.8;
        }

        return productPrice;
    }
}
