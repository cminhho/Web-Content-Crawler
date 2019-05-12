package com.norconex.blog.crawler;

import com.norconex.collector.http.HttpCollector;
import com.norconex.collector.http.HttpCollectorConfig;
import com.norconex.collector.http.crawler.HttpCrawlerConfig;

public class Main {
    public static void main(String[] args) {
        HttpCollectorConfig collectorConfig = new HttpCollectorConfig();
        collectorConfig.setId("MyHttpCollector");
        collectorConfig.setLogsDir("/tmp/logs/");

        HttpCrawlerConfig crawlerConfig = new HttpCrawlerConfig();
        crawlerConfig.setId("MyHttpCrawler");
        crawlerConfig.setStartURLs("http://example1.com", "http://example2.com");

        collectorConfig.setCrawlerConfigs(new HttpCrawlerConfig[]{crawlerConfig});

        HttpCollector collector = new HttpCollector(collectorConfig);
        collector.start(true);
    }
}
