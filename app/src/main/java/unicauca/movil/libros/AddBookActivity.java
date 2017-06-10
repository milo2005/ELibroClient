package unicauca.movil.libros;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import unicauca.movil.libros.databinding.ActivityAddBookBinding;
import unicauca.movil.libros.models.Book;
import unicauca.movil.libros.net.BooksClient;
import unicauca.movil.libros.net.SimpleResponse;

public class AddBookActivity extends AppCompatActivity implements Callback<SimpleResponse> {

    ActivityAddBookBinding binding;
    BooksClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_book);
        binding.setHandler(this);

        client =  ((App)getApplication()).retrofit.create(BooksClient.class);
    }

    public void addBook(){
        String name =  binding.nombre.getText().toString();
        String author =  binding.autor.getText().toString();
        String pags =  binding.pag.getText().toString();

        Book book =  new Book(name, author, Integer.parseInt(pags));

        Call<SimpleResponse> request =  client.insert(book);
        request.enqueue(this);
    }

    @Override
    public void onResponse(Call<SimpleResponse> call, Response<SimpleResponse> response) {
        if(response.isSuccessful()){
            SimpleResponse simpleResponse =  response.body();
            if(simpleResponse.isSuccess()){
                Toast.makeText(this, R.string.add_success, Toast.LENGTH_SHORT).show();
                finish();
            }else{
                Toast.makeText(this, R.string.add_error, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onFailure(Call<SimpleResponse> call, Throwable t) {

    }
}
