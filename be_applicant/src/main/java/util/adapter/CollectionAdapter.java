/**
 *
 */
package util.adapter;

import java.lang.reflect.Type;
import java.util.Collection;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * @author joerg
 *
 */
public class CollectionAdapter implements JsonSerializer<Collection<?>> {

    /*
     * (non-Javadoc)
     * 
     * @see com.google.gson.JsonSerializer#serialize(java.lang.Object, java.lang.reflect.Type,
     * com.google.gson.JsonSerializationContext)
     */
    @Override
    public JsonElement serialize(Collection<?> src, Type typOfSrcarg1, JsonSerializationContext context) {
        if (src == null || src.isEmpty()) {
            return null;
        }

        final JsonArray array = new JsonArray();

        for (final Object child : src) {
            final JsonElement element = context.serialize(child);
            array.add(element);
        }

        return array;
    }
}
