public class CacheEntry {
    
    private String tag;
    private String data;


    public CacheEntry(String tag, String data) {
        this.tag = tag;
        this.data = data;
    }

    public String getTag() {
        return this.tag;
    }

    public String getData() {
        return this.data;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setData(String data) {
        this.data = data;
    }
}
