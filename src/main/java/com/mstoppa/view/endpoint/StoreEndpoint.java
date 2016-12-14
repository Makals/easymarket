package com.mstoppa.view.endpoint;

import com.mstoppa.model.Store;
import com.mstoppa.service.StoreService;
import com.mstoppa.view.resource.StoreResource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StoreEndpoint {

    @Autowired
    private StoreService storeService;

    @RequestMapping("/stores/{storeId}")
    public StoreResource getStore(@PathVariable Long storeId) {
        Store store = storeService.getStore(storeId);

        StoreResource storeResource = new StoreResource();

        BeanUtils.copyProperties(store, storeResource);

        return storeResource;
    }

    @RequestMapping(value = "/stores", method = RequestMethod.POST)
    public StoreResource createStore(@RequestBody StoreResource storeResource) {
        Store store = new Store();

        BeanUtils.copyProperties(storeResource, store);

        store = storeService.createStore(store);

        BeanUtils.copyProperties(store, storeResource);

        return storeResource;
    }

    @RequestMapping(value = "/stores", method = RequestMethod.GET)
    public List<StoreResource> listStores() {
        List<Store> stores = storeService.listStores();

        List<StoreResource> storeResources = stores.stream()
                .map(store -> {
                    StoreResource storeResource = new StoreResource();
                    BeanUtils.copyProperties(store, storeResource);
                    return storeResource;
                }).collect(Collectors.toList());

        return storeResources;
    }
}
