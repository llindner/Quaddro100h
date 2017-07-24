package br.com.luizlindner.quaddro100h.lab07.app.util;

import android.content.Context;

import br.com.luizlindner.quaddro100h.R;
import br.com.luizlindner.quaddro100h.lab04.app.ws.EnderecoEndpoint;
import br.com.luizlindner.quaddro100h.lab07.app.ws.StarwarsEndpoint;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Luiz on 19/07/2017.
 */

public final class RetrofitHelper {

    private Context context;
    private Retrofit retrofit;

    private RetrofitHelper(Context context){
        super();
        this.context = context;
        this.retrofit = new Retrofit.Builder()
                .baseUrl(context.getString(R.string.lab07_retrofit_baseUrl_sw))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RetrofitHelper with(Context context){
        return new RetrofitHelper(context);
    }

    public StarwarsEndpoint createStarwarsEndpoint(){
        return retrofit.create(StarwarsEndpoint.class);
    }
}
