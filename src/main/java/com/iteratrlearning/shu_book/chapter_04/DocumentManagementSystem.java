package com.iteratrlearning.shu_book.chapter_04;

import java.util.*;

/*
NOTE : List<Document>, Constructor, importFile() are critical
 */

public class DocumentManagementSystem {
    private final List<Document> documents = new ArrayList<>();
    private final List<Document> documentView = Collections.unmodifiableList(documents);
    // tag::importer_lookup[]
    private final Map<String, Importer> extensionToImporter = new HashMap<>();

    // Constructor : To add Importers, in advance, which be in charge of various formed files if you import them from DMS
    public DocumentManagementSystem() {
        /*
        LetterImporter
        ReportImporter
        ImageImporter
        InvoiceImporter
         */
        extensionToImporter.put(); // Why put?
        extensionToImporter.put();
        extensionToImporter.put();
        extensionToImporter.put();
    }

}
