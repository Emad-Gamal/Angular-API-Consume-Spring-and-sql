/**
 *
 */
package  de.etherapists.util.adapter;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * @author joerg
 *
 */
public class StackTraceElementArrayAdapter implements JsonSerializer<StackTraceElement[]> {

    /*
     * (non-Javadoc)
     *
     * @see com.google.gson.JsonSerializer#serialize(java.lang.Object, java.lang.reflect.Type,
     * com.google.gson.JsonSerializationContext)
     */
    @Override
    public JsonElement serialize(StackTraceElement[] src, Type typOfSrc, JsonSerializationContext context) {

        // if (src == null || src.length == 0) {
        // return null;
        // }
        //
        // final JsonArray array = new JsonArray();
        //
        // for (final Object child : src) {
        // final JsonElement element = context.serialize(child);
        // array.add(element);
        // }
        //
        // return array;

        return null;

    }

}
