package com.example;


import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

/**
 * Created by bernatgomez on 27/08/2017.
 */

public class DataUsecaseImpl extends BaseUsecase implements IDataUsecase {

    public DataUsecaseImpl(Bus bus, RestDataSource data) {
        super(bus, data);
    }

    @Override
    public void getData() {
        this.bus.register(this);

        this.data.getData();
    }

    @Subscribe
    public void onDataReceived(Integer data) {
        this.bus.post(data);

        this.bus.unregister(this);
    }
}
