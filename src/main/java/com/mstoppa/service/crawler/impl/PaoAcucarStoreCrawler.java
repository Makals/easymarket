package com.mstoppa.service.crawler.impl;

import com.mstoppa.model.Offer;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Locale;

public class PaoAcucarStoreCrawler extends AbstractStoreCrawler {

    @Override
    protected void updateProductPrice(Offer offer, Document doc) {
        Elements eProductPrice = doc.select(".product-control__price .value");

        Double productPrice = null;
        try {
            productPrice = DecimalFormat.getNumberInstance(Locale.GERMAN).parse(eProductPrice.text()).doubleValue();
        } catch (ParseException exception) {
            exception.printStackTrace();
        }

        offer.setPrice(productPrice);
    }

    @Override
    protected void updateProductAvailability(Offer offer, Document doc) {
        offer.setAvailable(offer.getPrice() != null);
    }
}
