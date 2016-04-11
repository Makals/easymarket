package com.mstoppa.view.endpoint;

import com.mstoppa.model.Offer;
import com.mstoppa.model.Product;
import com.mstoppa.model.Store;
import com.mstoppa.service.OfferService;
import com.mstoppa.view.resource.OfferResource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OfferEndpoint {

    @Autowired
    private OfferService offerService;

    @RequestMapping("/offers/{offerId}")
    public OfferResource getOffer(@PathVariable Long offerId) {
        Offer offer = offerService.getOffer(offerId);

        OfferResource offerResource = new OfferResource();

        BeanUtils.copyProperties(offer, offerResource);

        return offerResource;
    }

    @RequestMapping(value = "/offers", method = RequestMethod.POST)
    public OfferResource createOffer(@RequestBody OfferResource offerResource) {
        Offer offer = new Offer();

        BeanUtils.copyProperties(offerResource, offer);

        offer = offerService.createOffer(offer);

        BeanUtils.copyProperties(offer, offerResource);

        return offerResource;
    }
}
