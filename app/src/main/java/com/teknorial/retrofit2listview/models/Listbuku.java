
package com.teknorial.retrofit2listview.models;

import java.util.HashMap;
import java.util.Map;

//Listbuku.java


public class Listbuku {
    //Variabel dalam json
    private Integer idbuku;
    private String nama;
    private Integer harga;
    private String status;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The idbuku
     */
    //getter dan setter
    public Integer getIdbuku() {
        return idbuku;
    }

    /**
     * 
     * @param idbuku
     *     The idbuku
     */
    public void setIdbuku(Integer idbuku) {
        this.idbuku = idbuku;
    }

    /**
     * 
     * @return
     *     The nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * 
     * @param nama
     *     The nama
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * 
     * @return
     *     The harga
     */
    public Integer getHarga() {
        return harga;
    }

    /**
     * 
     * @param harga
     *     The harga
     */
    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    /**
     * 
     * @return
     *     The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
