package unicauca.movil.libros;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import unicauca.movil.libros.databinding.ActivityLoginBinding;
import unicauca.movil.libros.models.User;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setHandler(this);
    }

    public void goToRegister(){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void login(){
        String email =  binding.email.getText().toString();
        String pass =  binding.pass.getText().toString();
        User user = new User(email, pass);
    }
}
