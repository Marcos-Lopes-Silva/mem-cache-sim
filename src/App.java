import java.text.DecimalFormat;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        
        Memoria mem = new Memoria();
        Cache cache = new Cache(8, 2);
        ArrayList<String> memoria = Arquivo.readFile("MemoriaPrincipal.txt");
        ArrayList<String> leituras = Arquivo.readFile("Leituras.txt");


        for(int i = 0; i < memoria.size(); i++) {
            
            mem.setMemoria(memoria.get(i));
        }
        for(int i = 0; i < leituras.size(); i++) {
            
            cache.acessaEndereco(leituras.get(i), mem);
        }


        geraRelatorio(cache);

    }



    public static void geraRelatorio(Cache cache) {
                
        DecimalFormat formatador = new DecimalFormat("0.00");
        float missRate = (float)((float)cache.getNumMiss() / ((float) cache.getNumMiss() + (float) cache.getNumHit())) * 100;
        float hitRate = (float)((float)cache.getNumHit() / ((float) cache.getNumMiss() + (float) cache.getNumHit())) * 100;
        String relatorio = "Relatório\n";
        relatorio += "Miss: " + cache.getNumMiss() + "\n";
        relatorio += "Hit: " + cache.getNumHit() + "\n";
        relatorio += "Miss rate: " + formatador.format(missRate) + "%\n";
        relatorio += "Hit rate: " + formatador.format(hitRate) + "%\n";

        Arquivo.writeFile("Relatorio.txt", relatorio);
    }
}
