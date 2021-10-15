package creational;

import java.io.IOException;
import java.io.PrintStream;

import javax.xml.parsers.ParserConfigurationException;

public class XMLMetadataExporter extends BookMetadataExporter {
    @Override
    public void export(PrintStream stream) throws IOException, ParserConfigurationException {
        formatter = new XMLBookMetadataFormatter();
        super.export(stream);
    }
}
