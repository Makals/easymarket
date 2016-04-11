package com.mstoppa.service;

import com.mstoppa.model.Offer;
import com.mstoppa.model.repository.OfferRepository;
import com.mstoppa.view.resource.OfferResource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    public Offer getOffer(Long id) {
        return offerRepository.findOne(id);
    }

    public List<Offer> listOffers() {
        return offerRepository.findAll();
    }

    public Offer createOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    public Offer updateOffer(Offer offer) {
        return offerRepository.save(offer);
    }
}
