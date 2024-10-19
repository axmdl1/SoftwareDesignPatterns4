package observer;

public class NewsChannel implements Observer{
    private String news;
    private String channelName;

    public NewsChannel(String channelName) {
        this.channelName = channelName;
    }

    @Override
    public void update(String news) {
        this.news = news;
        System.out.println(channelName + " receiver news: " + news);
    }
}