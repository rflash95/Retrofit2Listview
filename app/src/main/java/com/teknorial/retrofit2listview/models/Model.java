
package com.teknorial.retrofit2listview.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Model {

    private List<Listbuku> listbuku = new ArrayList<Listbuku>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The listbuku
     */
    public List<Listbuku> getListbuku() {
        return listbuku;
    }

    /**
     * 
     * @param listbuku
     *     The listbuku
     */
    public void setListbuku(List<Listbuku> listbuku) {
        this.listbuku = listbuku;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
