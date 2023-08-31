import java.util.ArrayList;
import java.util.List;

public class Memoria {
    private List<String> memoria;

    public Memoria() {
        this.memoria = new ArrayList<String>();
    }


    public String getMemoria(String endereco) {
        int index = Integer.parseInt(endereco, 2);
        return this.memoria.get(index);
    }
 
    public void setMemoria(String memoria) {
        this.memoria.add(memoria);
    }
}
