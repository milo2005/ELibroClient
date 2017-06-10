package unicauca.movil.libros;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import unicauca.movil.libros.databinding.ActivityRegisterBinding;
import unicauca.movil.libros.models.User;
import unicauca.movil.libros.net.RegisterResponse;
import unicauca.movil.libros.net.UsersClient;

public class RegisterActivity extends AppCompatActivity implements Callback<RegisterResponse> {

    ActivityRegisterBinding binding;
    UsersClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        binding.setHandler(this);
        client = ((App)getApplication()).retrofit.create(UsersClient.class);
    }

    public void register(){
        String email =  binding.email.getText().toString();
        String pass =  binding.pass.getText().toString();
        String name =  binding.nombre.getText().toString();
        User user = new User(name, email, pass);

        Call<RegisterResponse> request = client.register(user);
        request.enqueue(this);
    }

    @Override
    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
        if(response.isSuccessful()){
            RegisterResponse registerResponse =  response.body();

            if(registerResponse.isSuccess()){
                Toast.makeText(this, R.string.register_success, Toast.LENGTH_SHORT).show();
                finish();
            }else{
                Toast.makeText(this, registerResponse.getMsg(), Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this, R.string.register_error_2, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<RegisterResponse> call, Throwable t) {
        Toast.makeText(this, R.string.register_error, Toast.LENGTH_SHORT).show();
    }
}
