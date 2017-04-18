package pavlosnicolaou.newsapp;

/**
 * Created by vl1s on 14/04/2017.
 */

public class News {

    private String newsName;
    private String newsDetails;
    private String article;
    private int newsId;
    private String imageUrl;

    public News(int newsId, String newsName, String newsDetails, String article, String imageUrl) {
        this.newsId = newsId;
        this.newsName = newsName;
        this.newsDetails = newsDetails;
        this.article = article;
        this.imageUrl = imageUrl;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getNewsName() {
        return newsName;
    }

    public void setNewsName(String newsName) {
        this.newsName = newsName;
    }

    public String getNewsDetails() {
        return newsDetails;
    }

    public void setNewsDetails(String newsDetails) {
        this.newsDetails = newsDetails;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }
}
