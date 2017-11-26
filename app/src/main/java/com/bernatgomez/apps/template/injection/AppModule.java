package com.bernatgomez.apps.template.injection;

import com.example.DataUsecaseImpl;
import com.example.IDataUsecase;
import com.example.RestDataSource;
import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

import javax.inject.Scope;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bernatgomez on 27/08/2017.
 */

@Module
public class AppModule {

    @Provides
    public IDataUsecase provideDataUsecase(Bus bus, RestDataSource data) {
        return new DataUsecaseImpl(bus, data);
    }

    @Provides
    public RestDataSource provideDataSource(Bus bus, Retrofit retrofit) {
        return new RestDataSource(bus, retrofit);
    }

    @Provides
    public Bus provideBus() {
        return new Bus(ThreadEnforcer.MAIN);
    }

    @Provides
    public OkHttpClient provideClient() {
        final int POOL_SIZE = 1;
        final int TIMEOUT = 30 * 1000;

        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        OkHttpClient client = builder.build();

        return client;

        /*
        *
        *         final int POOL_SIZE = 1;
        final int TIMEOUT = 30 * 1000;
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            clientBuilder.addInterceptor(interceptor);
        }

        ConnectionPool connectionPool = new ConnectionPool(POOL_SIZE, TIMEOUT, TimeUnit.MILLISECONDS);

        clientBuilder.connectTimeout(TIMEOUT, TimeUnit.MILLISECONDS);

        clientBuilder.readTimeout(TIMEOUT, TimeUnit.MILLISECONDS);

        clientBuilder.retryOnConnectionFailure(true);

        clientBuilder.connectionPool(connectionPool);

        OkHttpClient client = clientBuilder.build();

        return client;
        * */

    }

    @Provides
    public Retrofit provideRetrofit(OkHttpClient client) {
        Retrofit retro =
            new Retrofit.Builder()
                .baseUrl(AppComponent.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                    .build();

        return retro;
    }
}
