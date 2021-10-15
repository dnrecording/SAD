package creational;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONBookMetadataFormatter implements BookMetadataFormatter {

    JSONObject book_obj = new JSONObject();
    JSONArray book_array = new JSONArray();

    public JSONBookMetadataFormatter() throws IOException {
        reset();
    }

    @Override
    public BookMetadataFormatter reset() {
        book_obj = new JSONObject();
        book_array = new JSONArray();
        book_obj.put("Books", book_array);
        // Please implement this method. You may create additional methods as you see fit.
        return null;
    }

    @Override
    public BookMetadataFormatter append(Book b) {
        var bo = new JSONObject();
        bo.put("ISBN", b.getISBN());
        bo.put("Title", b.getTitle());
        bo.put("Publisher", b.getPublisher());

        var ba = new JSONArray();
        for(int i = 0 ; i < b.getAuthors().length; i++){
            ba.add(b.getAuthors()[i]);
        }
        bo.put("Authors", ba);

        book_array.add(bo);
        
        // Please implement this method. You may create additional methods as you see fit.
        return this;
    }

    @Override
    public String getMetadataString() {
        // Please implement this method. You may create additional methods as you see fit.
        return book_obj.toString();
    }
}
