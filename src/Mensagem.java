public class Mensagem {
    String remetente;
    String destinatario;
    String assunto;
    String texto;

    public Mensagem(String remetente, String destinatario, String assunto, String texto) {
        this.remetente    = remetente;
        this.destinatario = destinatario;
        this.assunto      = assunto;
        this.texto        = texto;
    }
    public String toString() {
        String resposta = "de:" + remetente+ "\n";
        resposta += "para:" + destinatario+ "\n";
        resposta += "assunto:" + assunto+ "\n";
        resposta += "texto:" + texto+ "\n";
        return resposta;
    }
    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMensagem() {
        return texto;
    }

    public void setMensagem(String mensagem) {
        this.texto = mensagem;
    }

    public String getRementente() {
        return remetente;
    }

    public void setRementente(String rementente) {
        this.remetente = rementente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
}