

import java.io.*;
import java.util.ArrayList;

public class GerenciadorDeArquivo {
    String remetente;
    String destinatario;
    String assunto;
    String texto;
    private static GerenciadorDeArquivo instancia = null;
    public  static GerenciadorDeArquivo getInstancia() {
        if(instancia == null) {
            instancia = new GerenciadorDeArquivo();
        }
        return instancia;
    }
    //
    private File file;
    private GerenciadorDeArquivo() {
        file = new File("arquivo.txt");
    }

    public void escreverNoArquivo(String texto) throws IOException {
        PrintStream ps = new PrintStream(file);
        ps.println(texto);
        ps.close();
    }

    public String lerDoArquivo() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String resposta = "";
        String temp = br.readLine();
        while(temp != null) {

            resposta+= temp;
            temp = br.readLine();
        }

        String auxilar[] = resposta.split("}");


        for(String s : auxilar) {
            String a[] = s.split(",");
            s = s.replace("{", "");
            s = s.replace("}", "");
            s = s.replace("\"", "");
            a = s.split(",");

            String fields[];
            for (String element : a) {
                fields = element.split(":");


                if (fields[0].equalsIgnoreCase("remetente")) remetente = fields[1];
                else if (fields[0].equalsIgnoreCase("destinatario")) destinatario = fields[1];
                else if (fields[0].equalsIgnoreCase("assunto")) assunto = fields[1];
                else if (fields[0].equalsIgnoreCase("texto")) texto = fields[1];
            }
//            ArrayList <Mensagem> nome = new ArrayList<>(auxilar.length);
//            nome.add(new Mensagem(remetente,destinatario,assunto,texto));
//            System.out.println();
        }

        br.close();
        return resposta;
    }

}
