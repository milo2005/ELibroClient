package unicauca.movil.libros;

import android.app.Application;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class App extends Application {

    Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit =  new Retrofit.Builder()
                //.baseUrl("http://10.0.2.2:3000")
                .baseUrl("http://192.168.0.11:3000")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();

    }
}
