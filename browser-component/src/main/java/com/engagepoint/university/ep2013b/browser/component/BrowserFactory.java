package com.engagepoint.university.ep2013b.browser.component;


import com.engagepoint.university.ep2013b.browser.api.BrowserService;

import java.util.ServiceLoader;


// Search necessary data service provider

public class BrowserFactory {
    private static BrowserService instance;

    // Creating new data service provider for specific name
    public static BrowserService getInstance(String serviceName) throws NullPointerException {
//            , boolean reconnect) throws NullPointerException {
//        if (reconnect) {
//            findService(serviceName);
//            instance.connect();
//        } else
        {
            // create instance only if not created before with the same serviceName
            if ((instance == null) || (!instance.getServiceName().equalsIgnoreCase(serviceName))) {
                findService(serviceName);
            }

            if (instance == null)
                throw new NullPointerException("Service with name \"" + serviceName + "\" not found.");
        }
        return instance;
    }

    private static void findService(String serviceName) {
        ServiceLoader<BrowserService> services = ServiceLoader.load(BrowserService.class);

        for (BrowserService i : services) {
            if (i.getServiceName().equalsIgnoreCase(serviceName)) {
                instance = i;
                break;
            }
        }
    }
}
