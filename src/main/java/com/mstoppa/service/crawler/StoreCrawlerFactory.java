package com.mstoppa.service.crawler;

import com.mstoppa.model.Store;
import com.mstoppa.service.crawler.impl.ExtraStoreCrawler;
import com.mstoppa.service.crawler.impl.PaoAcucarStoreCrawler;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StoreCrawlerFactory {

    private Map<Store, StoreCrawler> storeCrawlerMap;

    public StoreCrawlerFactory() {
        storeCrawlerMap = new HashMap<>();

        storeCrawlerMap.put(new Store(1L), new PaoAcucarStoreCrawler());
        storeCrawlerMap.put(new Store(2L), new ExtraStoreCrawler());
    }

    public StoreCrawler getStoreCrawler(Store store) {
        return storeCrawlerMap.get(store);
    }
}
