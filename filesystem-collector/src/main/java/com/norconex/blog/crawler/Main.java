package com.norconex.blog.crawler;

import com.norconex.collector.fs.FilesystemCollector;
import com.norconex.collector.fs.FilesystemCollectorConfig;
import com.norconex.collector.fs.crawler.FilesystemCrawlerConfig;

public class Main {
    public static void main(String[] args) {
        //FilesystemCollectorConfig config = (FilesystemCollectorConfig)
//        new CollectorConfigLoader(FilesystemCollectorConfig.class)
//            .loadCollectorConfig(myXMLFile, myVariableFile);

        FilesystemCollectorConfig collectorConfig = new FilesystemCollectorConfig();
        collectorConfig.setId("MyFilesystemCollector");
        collectorConfig.setLogsDir("F:/oasp/Web-Content-Crawler/filesystem-collector/tmp/logs/");

        FilesystemCrawlerConfig crawlerConfig = new FilesystemCrawlerConfig();
        crawlerConfig.setId("MyFilesystemCrawler");
        crawlerConfig.setStartPaths(
                new String[]{"F:/oasp/Web-Content-Crawler/filesystem-collector-resources/demo.txt"});

        collectorConfig.setCrawlerConfigs(crawlerConfig);

        FilesystemCollector collector = new FilesystemCollector(collectorConfig);
        collector.start(true);
    }
}
