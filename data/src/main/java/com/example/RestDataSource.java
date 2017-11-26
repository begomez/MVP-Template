package com.example;


import com.squareup.otto.Bus;

import retrofit2.Retrofit;


/**
 * Created by bernatgomez on 27/08/2017.
 */
public class RestDataSource implements IDataSource {

    private Bus bus;

    private Retrofit retrofit;

    private MyApi api;


    /**
     *
     * @param bus
     * @param retrofit
     */
    public RestDataSource(Bus bus, Retrofit retrofit) {
        this.bus = bus;
        this.retrofit = retrofit;

        this.init();
    }

    private void init() {
        this.createApi();
    }

    private void createApi() {
        this.api = this.retrofit.create(MyApi.class);
    }

    public void getData() {
        //this.api.getData();

        this.bus.post(new Integer(100));
    }

}
