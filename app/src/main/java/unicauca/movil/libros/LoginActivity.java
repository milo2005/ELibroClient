package unicauca.movil.libros;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import unicauca.movil.libros.databinding.ActivityLoginBinding;
import unicauca.movil.libros.models.User;
import unicauca.movil.libros.net.SimpleResponse;
import unicauca.movil.libros.net.UsersClient;

public class LoginActivity extends AppCompatActivity implements Callback<SimpleResponse> {

    ActivityLoginBinding binding;
    UsersClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setHandler(this);
        client =  ((App)getApplication()).retrofit.create(UsersClient.class);
    }

    public void goToRegister(){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void login(){
        String email =  binding.email.getText().toString();
        String pass =  binding.pass.getText().toString();
        User user = new User(email, pass);

        Call<SimpleResponse> request = client.login(user);
        request.enqueue(this);
    }

    @Override
    public void onResponse(Call<SimpleResponse> call, Response<SimpleResponse> response) {
        if(response.isSuccessful()){
            SimpleResponse simpleResponse =  response.body();
            if(simpleResponse.isSuccess()){
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }else{
                Toast.makeText(this, simpleResponse.getMsg(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onFailure(Call<SimpleResponse> call, Throwable t) {

    }
}
