package com.norconex.blog.crawler;

import com.norconex.commons.lang.file.ContentType;
import com.norconex.commons.lang.map.Properties;
import com.norconex.importer.Importer;
import com.norconex.importer.ImporterConfig;
import com.norconex.importer.ImporterException;
import com.norconex.importer.doc.ImporterDocument;
import com.norconex.importer.parser.DocumentParserException;
import com.norconex.importer.parser.IDocumentParser;
import com.norconex.importer.parser.IDocumentParserFactory;
import com.norconex.importer.response.ImporterResponse;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ImporterException {
        ImporterConfig config = new ImporterConfig();

        File tempFile = File.createTempFile("F:/oasp/Web-Content-Crawler/filesystem-collector-resources/", ".txt");
        config.setTempDir(tempFile);

        Importer importer = new Importer(config);

        Properties properties = new Properties();
        properties.setString("name", "hmchung");

        File fileInput = new File("F:/oasp/Web-Content-Crawler/filesystem-collector-resources/demo.txt");
        ImporterResponse importerResponse = importer.importDocument(fileInput, properties);

        if(importerResponse.getImporterStatus().getStatus().name().equals("ERROR")){
            System.out.println("ERROR: File was imported to : " + tempFile);
        } else {
            System.out.println("File was imported to : " + tempFile);
            System.out.println("File content: : " + importerResponse.getDocument().getContent());
        }

    }
}
