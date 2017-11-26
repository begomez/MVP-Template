package com.example;

import com.squareup.otto.Bus;

/**
 * Created by bernatgomez on 27/08/2017.
 */

public class BaseUsecase {
    protected Bus bus;
    protected RestDataSource data;

    public BaseUsecase(Bus bus, RestDataSource data) {
        this.bus = bus;
        this.data = data;
    }
}
