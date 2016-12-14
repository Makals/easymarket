package com.mstoppa.service;

import com.mstoppa.model.Store;
import com.mstoppa.model.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public Store getStore(Long id) {
        return storeRepository.findOne(id);
    }

    public Store createStore(Store store) {
        return storeRepository.save(store);
    }

    public List<Store> listStores() {
        return storeRepository.findAll();
    }
}
