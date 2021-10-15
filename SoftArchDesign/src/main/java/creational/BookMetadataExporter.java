package creational;

import java.io.IOException;
import java.io.PrintStream;

import javax.xml.parsers.ParserConfigurationException;

public abstract class BookMetadataExporter extends BookCollection {
    BookMetadataFormatter formatter;

    public void export(PrintStream stream) throws IOException, ParserConfigurationException {

        for (var data : books) {
            formatter.append(data);
        }
        stream.print(formatter.getMetadataString());

    };
}
