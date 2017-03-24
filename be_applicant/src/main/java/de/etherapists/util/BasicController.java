package  de.etherapists.util;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSerializer;

import  de.etherapists.util.adapter.CollectionAdapter;
import  de.etherapists.util.adapter.EnumAdapter;
import  de.etherapists.util.adapter.StackTraceElementArrayAdapter;

@Controller
public class BasicController {

    private final Logger logger = LoggerFactory.getLogger(BasicController.class);

    /**
     *
     * generates a response with body of a JSON object with a given state
     *
     * @param request
     *            request
     * @param response
     *            response
     * @param objToJSon
     *            object you want to put into a json object (entity or exception)
     * @param status
     *            HTTPStatus of the response
     * @throws IOException
     *             Exception if something going wrong
     */

    protected void callJSONResponse(HttpServletRequest request, HttpServletResponse response, Object objToJSon, HttpStatus status)
            throws IOException {

        final Gson gson = new GsonBuilder().registerTypeHierarchyAdapter(Collection.class, new CollectionAdapter())
                .registerTypeHierarchyAdapter(StackTraceElement[].class, new StackTraceElementArrayAdapter())
                .registerTypeHierarchyAdapter(Enum.class, new EnumAdapter()).create();

        final String json = gson.toJson(objToJSon);
        response.setHeader("Content-Type", "application/json; charset=utf-8");
        response.setStatus(status.value());
        response.getWriter().write(json);

    }

    /**
     * generates a response with body of a JSON object with a given state and a given TypeAdapter
     *
     * @param request
     *            request
     * @param response
     *            response
     * @param objToJSon
     *            object you want to put into a JSON object (entity or exception)
     * @param status
     *            HTTPStatus of the response
     * @param toconvertJSon
     *            The Class of the JSON object
     * @param adapter
     *            The type adapter of the given JSON object
     * @throws IOException
     *             exception
     */
    protected void callJSONResponse(HttpServletRequest request, HttpServletResponse response, Object objToJSon, HttpStatus status,
            Class<?> toconvertJSon, JsonSerializer<?> adapter) throws IOException {
        final GsonBuilder gsonBuilder = new GsonBuilder();
        final Gson gson = gsonBuilder.registerTypeAdapter(toconvertJSon, adapter).create();
        final String json = gson.toJson(objToJSon);
        response.setHeader("Content-Type", "application/json; charset=utf-8");
        response.setStatus(status.value());
        response.getWriter().write(json);
    }

    /**
     * generates a response with a list of JsonSerializer. All serializer will be registered first, before the response
     * is created
     *
     * @param request
     *            request
     * @param response
     *            response
     * @param objToJSon
     *            object you want to put into a JSON object (entity or exception)
     * @param status
     *            HTTPStatus of the response
     * @param adapterList
     *            a hashmap with the class and JsonSerializer which will be registered first
     * @throws IOException
     *             exception
     */
    protected void callJSONResponse(HttpServletRequest request, HttpServletResponse response, Object objToJSon, HttpStatus status,
            HashMap<Class<?>, JsonSerializer<?>> adapterList) throws IOException {
        final GsonBuilder gsonBuilder = new GsonBuilder();
        final Iterator<Class<?>> itr = adapterList.keySet().iterator();
        while (itr.hasNext()) {
            final Class<?> currentClass = itr.next();
            gsonBuilder.registerTypeAdapter(currentClass, adapterList.get(currentClass));
        }
        final Gson gson = gsonBuilder.create();
        final String json = gson.toJson(objToJSon);
        response.setHeader("Content-Type", "application/json; charset=utf-8");
        response.setStatus(status.value());
        response.getWriter().write(json);
    }

    /**
     *
     * generates a response without any body and the given HTTP Status
     *
     * @param request
     *            request
     * @param response
     *            response
     * @param status
     *            HTTP Status of the response
     */
    protected void callResponse(HttpServletRequest request, HttpServletResponse response, HttpStatus status) {
        response.setStatus(status.value());
    }

    /**
     *
     * generates a response without any body but with the HTTP Status 200 (OK)
     *
     * @param request
     *            request
     * @param response
     *            response
     */
    protected void callResponse(HttpServletRequest request, HttpServletResponse response) {
        callResponse(request, response, HttpStatus.OK);
    }

}