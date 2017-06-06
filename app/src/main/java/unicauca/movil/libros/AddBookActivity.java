package unicauca.movil.libros;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import unicauca.movil.libros.databinding.ActivityAddBookBinding;
import unicauca.movil.libros.models.Book;

public class AddBookActivity extends AppCompatActivity {

    ActivityAddBookBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_book);
        binding.setHandler(this);
    }

    public void addBook(){
        String name =  binding.nombre.getText().toString();
        String author =  binding.autor.getText().toString();
        String pags =  binding.pag.getText().toString();

        Book book =  new Book(name, author, Integer.parseInt(pags));
    }
}
