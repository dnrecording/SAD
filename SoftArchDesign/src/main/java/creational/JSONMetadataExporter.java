package creational;

import java.io.IOException;
import java.io.PrintStream;

import javax.xml.parsers.ParserConfigurationException;

public class JSONMetadataExporter extends BookMetadataExporter {
    @Override
    public void export(PrintStream stream) throws IOException, ParserConfigurationException {
        formatter = new JSONBookMetadataFormatter();
        super.export(stream);
    }
}
