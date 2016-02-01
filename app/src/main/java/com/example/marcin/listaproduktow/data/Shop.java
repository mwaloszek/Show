package com.example.marcin.listaproduktow.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Marcin on 01.02.2016.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Shop {

    public int id;
    public String name;
    public String status;

}


