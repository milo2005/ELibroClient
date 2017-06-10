package unicauca.movil.libros.net;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import unicauca.movil.libros.models.User;

public interface UsersClient {

    @POST("users/registro")
    Call<RegisterResponse> register(@Body User user);

    @POST("users/login")
    Call<SimpleResponse> login(@Body User user);

}
