import java.util.ArrayList;
import java.util.List;

public class Cache {

    private int numMiss;
    private int numHit;
    private List<CacheSet> sets;
   

    public Cache(int numSets, int entryPorSets) {
        this.numMiss = 0;
        this.numHit = 0;
        this.sets = new ArrayList<>();

        for (int i = 0; i < numSets; i++) {
            this.sets.add(new CacheSet(entryPorSets));
        }
    }

    public int getNumMiss() {
        return numMiss;
    }

    public int getNumHit() {
        return numHit;
    }


    public void acessaEndereco(String endereco, Memoria mem){
        
        String tag = endereco.substring(0, 3);
        String index = endereco.substring(3);

        int indexInt = Integer.parseInt(index, 2);

        CacheSet set = this.sets.get(indexInt);
       
        if(set.findEntry(tag) != null) {
            numHit++;
            System.out.println("Hit! Tag: " +tag + " Index: " +index+ " Endereço: " +endereco );

        } else {
            numMiss++;
            System.out.println("Miss! Tag: " +tag + " Index: " +index+ " Endereço: " +endereco );
            
            String data = mem.getMemoria(endereco);
            set.insertEntry(tag, data);
        }

    }

}