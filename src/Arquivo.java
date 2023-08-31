
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Arquivo {

    

    public static ArrayList<String> readFile(String path) {

        ArrayList<String> arr = new ArrayList<>();
        
        try {
            String conteudo = Files.readString(Paths.get(path), StandardCharsets.UTF_8);
            
            for(String linha : conteudo.split("\n")) {
                arr.add(linha);
            }
            
            return arr;
        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo" + e);
        }

        return arr;

    }

    public static void writeFile(String path, String conteudo) {
        try {
            Files.writeString(Paths.get(path), conteudo, StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.out.println("Erro ao escrever arquivo" + e);
        }
    }

    



}