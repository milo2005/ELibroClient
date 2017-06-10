package unicauca.movil.libros.net;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import unicauca.movil.libros.models.Book;

/**
 * Created by darfe on 9/06/2017.
 */

public interface BooksClient {

    @GET("books")
    Call<List<Book>> all();

    @POST("books")
    Call<SimpleResponse> insert(@Body Book book);

}
