package nhoxs25.yenvo.demretrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerAdapter mTeamAdapter;
    RecyclerAdapter.MovieViewHolder movieViewHolder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_recycler_view);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<NewspaperResponse> call = apiService.getAll();
        call.enqueue(new Callback<NewspaperResponse>() {
            @Override
            public void onResponse(Call<NewspaperResponse> call, Response<NewspaperResponse> response) {
                final ArrayList<Newspaper> news = (ArrayList<Newspaper>) response.body().getResults();
                Log.d("TAG",news.size()+"");
                mTeamAdapter = new RecyclerAdapter(news, R.layout.activity_main,
                        getApplicationContext());
                recyclerView.setAdapter(mTeamAdapter);
                mTeamAdapter.notifyDataSetChanged();
                mTeamAdapter.setMyOnClickListener(new RecyclerAdapter.MyOnClickListener() {
                    @Override
                    public void onClick(int position) {
                        Intent it = new Intent(getApplication(), DetailAdapter.class);
                        Bundle bd = new Bundle();
                        bd.putParcelable("NextUrl",news.get(position));
                        it.putExtras(bd);
                        startActivity(it);
                    }
                });
            }

            @Override
            public void onFailure(Call<NewspaperResponse> call, Throwable t) {
                Log.e("TAG",t.toString());
            }
        });
    }

}
