package com.mstoppa.service.crawler.impl;

import com.mstoppa.model.Offer;
import com.mstoppa.service.crawler.StoreCrawler;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Locale;

public abstract class AbstractStoreCrawler implements StoreCrawler {

    @Override
    public void updateOffer(Offer offer) {
        try {
            Document doc = Jsoup.connect(getProductUrl(offer)).get();

            updateProductPrice(offer, doc);
            updateProductAvailability(offer, doc);

            System.out.println(offer);

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    protected String getProductUrl(Offer offer) {
        String url = offer.getStore().getUrl();
        return url.replace("{productId}", offer.getProductIdFromStore().toString());
    }

    protected abstract void updateProductPrice(Offer offer, Document doc);

    protected abstract void updateProductAvailability(Offer offer, Document doc);
}
