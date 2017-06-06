package unicauca.movil.libros;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import unicauca.movil.libros.databinding.ActivityRegisterBinding;
import unicauca.movil.libros.models.User;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        binding.setHandler(this);
    }

    public void register(){
        String email =  binding.email.getText().toString();
        String pass =  binding.pass.getText().toString();
        String name =  binding.nombre.getText().toString();
        User user = new User(name, email, pass);
    }
}
