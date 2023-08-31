import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CacheSet {
    
    private List<CacheEntry> entries;
    private int numEntradas;

    public CacheSet(int numEntradas) {
        this.numEntradas = numEntradas;
        this.entries = new ArrayList<CacheEntry>();
    }

    
    public CacheEntry findEntry(String tag) {
        for (int i = 0; i < this.entries.size(); i++) {
            if (this.entries.get(i).getTag().equals(tag)) {
                return this.entries.get(i);
            }
        }
        return null;
    }

    public void insertEntry(String tag, String data) {
        if (this.entries.size() < this.numEntradas) {
            this.entries.add(new CacheEntry(tag, data));
        } else {
            Random rand = new Random();
            int randomIndex = rand.nextInt(this.entries.size());
            this.entries.set(randomIndex, new CacheEntry(tag, data));
        }
    }
    
    
}
