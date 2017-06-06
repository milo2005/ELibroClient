package unicauca.movil.libros;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

import unicauca.movil.libros.adapters.BookAdapter;
import unicauca.movil.libros.databinding.ActivityMainBinding;
import unicauca.movil.libros.models.Book;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setHandler(this);

        adapter =  new BookAdapter(getLayoutInflater(), new ArrayList<Book>());
        binding.list.setAdapter(adapter);
        binding.list.setLayoutManager(new LinearLayoutManager(this));
        loadBooks();
    }

    private void loadBooks() {

    }

    public void goToAdd(){
        Intent intent = new Intent(this, AddBookActivity.class);
        startActivity(intent);
    }
}
