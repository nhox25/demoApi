package nhoxs25.yenvo.demretrofit;

/**
 * Created by yenvo on 05/01/2017.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MovieViewHolder> {

    private List<Newspaper> movies;
    private int rowLayout;
    private Context context;
    MyOnClickListener myOnClickListener;

    public void setMyOnClickListener(MyOnClickListener myOnClickListener) {
        this.myOnClickListener = myOnClickListener;
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {

        LinearLayout moviesLayout;
        TextView author;
        TextView title;
        ImageView image;

        public MovieViewHolder(View v) {
            super(v);
            moviesLayout = (LinearLayout) v.findViewById(R.id.layout);
            author = (TextView) v.findViewById(R.id.author);
            title = (TextView) v.findViewById(R.id.title);
            image = (ImageView) v.findViewById(R.id.image);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myOnClickListener.onClick(getAdapterPosition());

                }
            });
        }
    }

    public RecyclerAdapter(List<Newspaper> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout,
                parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        holder.author.setText(movies.get(position).getAuthor());
        holder.title.setText(movies.get(position).getTitle());
        Picasso.with(context)
                .load(movies.get(position).getUrlToImage())
                .resize(32, 32)
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    interface MyOnClickListener{
        void onClick(int position);
    }

}