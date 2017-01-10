package nhoxs25.yenvo.demretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailAdapter extends AppCompatActivity {
    ImageView img;
    TextView tvauthor;
    TextView tvtitle;
    TextView tvdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        WebView myWebView = (WebView) findViewById(R.id.webview);
        img = (ImageView) findViewById(R.id.imagedetail);
        tvauthor = (TextView) findViewById(R.id.tvauthor);
        tvtitle = (TextView) findViewById(R.id.tvtitle);
        tvdate = (TextView) findViewById(R.id.tvdate);
        Bundle bd = getIntent().getExtras();
        Newspaper newspaper = (Newspaper) bd.get("NextUrl");

        tvtitle.setText(String.valueOf(newspaper.getTitle()).toString());
        tvauthor.setText(String.valueOf(newspaper.getAuthor()).toString());
        tvdate.setText(String.valueOf(newspaper.getPublishedAt()).toString());
        Picasso.with(this).load(newspaper.getUrlToImage()).resize(100,100).into(img);
        myWebView.loadUrl(newspaper.getUrl());
    }
}
