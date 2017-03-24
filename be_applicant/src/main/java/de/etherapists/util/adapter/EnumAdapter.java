/**
 *
 */
package  de.etherapists.util.adapter;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * @author joerg
 *
 */
public class EnumAdapter implements JsonSerializer<Enum<?>> {

    /*
     * (non-Javadoc)
     * 
     * @see com.google.gson.JsonSerializer#serialize(java.lang.Object, java.lang.reflect.Type,
     * com.google.gson.JsonSerializationContext)
     */
    @Override
    public JsonElement serialize(Enum<?> src, Type typeOfSrc, JsonSerializationContext context) {

        if (src == null) {
            return null;
        }

        final JsonElement result = new JsonPrimitive(src.toString());

        return result;

    }

}
