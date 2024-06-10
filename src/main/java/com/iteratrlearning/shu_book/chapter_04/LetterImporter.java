package com.iteratrlearning.shu_book.chapter_04;

import java.io.File;
import java.io.IOException;

// 인스턴스화하기 위하여 Importer 상속 IF가 아닌, Importer를 implements하는 Class
public class LetterImporter implements Importer {
    private static final String NAME_PREFIX = "Dear ";

    // tag::importFile[]
    @Override
    public Document importFile(final File file) throws IOException {
        final TextFile textFile = new TextFile(file);

        return new Document();
    }
}
