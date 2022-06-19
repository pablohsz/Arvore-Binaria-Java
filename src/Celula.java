public class Celula {

    private int key;
    private Celula pai;
    private Celula direita;
    private Celula esquerda;

    public Celula(int chave){
        key = chave;
        direita = null;
        esquerda = null;
        pai = null;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Celula getPai() {
        return pai;
    }

    public void setPai(Celula pai) {
        this.pai = pai;
    }

    public Celula getDireita() {
        return direita;
    }

    public void setDireita(Celula direita) {
        this.direita = direita;
    }

    public Celula getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Celula esquerda) {
        this.esquerda = esquerda;
    }
}
