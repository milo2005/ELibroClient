package unicauca.movil.libros.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import unicauca.movil.libros.R;
import unicauca.movil.libros.databinding.TemplateBookBinding;
import unicauca.movil.libros.models.Book;

/**
 * Created by darfe on 21/05/2017.
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookHolder> {

    LayoutInflater inflater;
    List<Book> data;

    public BookAdapter(LayoutInflater inflater, List<Book> data) {
        this.inflater = inflater;
        this.data = data;
    }

    @Override
    public BookHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.template_book, parent, false);
        return new BookHolder(v);
    }

    @Override
    public void onBindViewHolder(BookHolder holder, int position) {
        holder.binding.setBook(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<Book> data){
        this.data = data;
        notifyDataSetChanged();
    }

    static class BookHolder extends RecyclerView.ViewHolder{
        TemplateBookBinding binding;
        public BookHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
