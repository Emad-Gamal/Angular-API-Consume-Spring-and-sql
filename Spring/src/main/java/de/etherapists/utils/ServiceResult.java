package de.etherapists.utils;

import java.util.Collection;

/**
 *
 * @author mj2075
 */
public class ServiceResult<T> {
    private Collection<T> contents;
    private Integer size;

    public Collection<T> getContents() {
        return contents;
    }

    public void setContents(Collection<T> contents) {
        this.contents = contents;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
