package com.iteratrlearning.shu_book.chapter_04;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static com.iteratrlearning.shu_book.chapter_04.Attributes.PATH;
import static java.util.stream.Collectors.toList;

// tag::classDefinition[]
// This is required to complete importFile() from Importer classes
public class TextFile {
    // get files and save as List to parse them
    private final Map<String, String> attributes;
    private final List<String> lines;

    // class continues ...
// end::classDefinition[]

    // Constructor
    TextFile(final File file) throws IOException {
        attributes = new HashMap<>(); // 1. create Stream of HashMap and init it to save file paths and other metadata for later time
        attributes.put(PATH, file.getPath()); // 2. save path of files as attributes Map in order to get access easily later to the path data by adding it to `attributes` Map
        lines = Files.lines(file.toPath()).collect(toList()); // 3. read every single line of a file and save em to `lines` List
        /*
        1. Encapsulation : Encapsulates the file-related attribute information (attributes) and the actual file content (lines)
        2. About `throws IOException` in the constructor
            : Methods used inside the constructor might cause an IOException, so the responsibility to handle this exception is passed to the method that calls the constructor.
            2.1. Exception propagation
                : Rather than using `try-catch` inside the constructor, the exception is passed on to the method that called the constructor.
                  This way, the calling method can handle the exception properly.
         */
    }

    Map<String, String> getAttributes() {
        return attributes;
    }

    // tag::addLines[]
    int addLines (final int start, final Predicate<String> isEnd, final String attributeName) {
        final StringBuilder accumulator = new StringBuilder();
        int lineNumber;
        for (lineNumber = start; lineNumber < lines.size(); lineNumber++) {
            final String line = lines.get(lineNumber); // get a current line from lines
            if (isEnd.test(line)) // boolean true or not if the line is an end
                break; // get out of the loop if it meets the condition
            accumulator.append(line); // add the current line into `accumulator`
            accumulator.append("\n");
        }
        attributes.put(attributeName, accumulator.toString().trim()); // store the final string in the attributes map, removing leading and trailing whitespace
        return lineNumber; // return the last read lineNumber (int type)
    }
    // end::addLines[]

    // tag::addLineSuffix[]
    /*
    addLineSuffix() is used to find a line in the file that starts with a given prefix
    and then store the remainder of that line (after the prefix)
    into the `attributes` map with the specified attribute name.
     */
    void addLineSuffix(final String prefix, final String attributeName) {
        for (final String line : lines) {
            if (line.startsWith(prefix)) {
                // Key : attributeName, Value: line.substring(prefix.length())
                /*
                value: The string after the prefix,
                       where line.substring(prefix.length()) gets the remaining part of the current line
                       after removing the prefix.
                 */
                attributes.put(attributeName, line.substring(prefix.length()));
                break;
            }
        }
    }
    // end::addLineSuffix[]
}
