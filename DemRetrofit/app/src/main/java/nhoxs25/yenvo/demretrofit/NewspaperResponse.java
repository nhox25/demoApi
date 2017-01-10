package nhoxs25.yenvo.demretrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class NewspaperResponse {

    @SerializedName("articles")
    private List<Newspaper> results;

    public List<Newspaper> getResults() {
        return results;
    }

    public void setResults(List<Newspaper> results) {
        this.results = results;
    }

}