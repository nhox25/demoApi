package nhoxs25.yenvo.demretrofit;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by yenvo on 05/01/2017.
 */

public interface ApiInterface {

    @GET("articles?source=the-next-web&sortBy=latest&apiKey=6034c984919e4f5abd9d9261d230c0ca")
    Call<NewspaperResponse> getAll();

}