
public class Arvore {
    private Celula raiz;

    public Arvore(int chave) {
        raiz = new Celula(chave);

    }

    public Celula getRaiz() {
        return raiz;
    }

    public void setRaiz(Celula raiz) {
        this.raiz = raiz;
    }

    public void inserir(int chave) {
        //Método para inserir um nó na árvore.
        Celula z = new Celula(chave);
        Celula y, x;
        y = null;
        x = this.raiz;
        while (x != null) {
            y = x;
            if (z.getKey() < x.getKey()) {
                x = x.getEsquerda();
            } else {
                x = x.getDireita();
            }
        }
        z.setPai(y);
        z.setEsquerda(null);
        z.setDireita(null);
        if (y == null) {
            this.setRaiz(z);
        } else {
            if (z.getKey() < y.getKey()) {
                y.setEsquerda(z);
            } else {
                y.setDireita(z);
            }
        }
    }

    public void remocao(Celula z) {
        //Método para remover um nó da árvore.
        if (z.getEsquerda() == null) {
            this.transplante(z, z.getDireita());
        } else {
            if (z.getDireita() == null) {
                this.transplante(z, z.getEsquerda());
            } else {
                Celula y = this.sucessor(z);
                if (y.getPai() != z) {
                    this.transplante(y, y.getDireita());
                    y.setDireita(z.getDireita());
                    (y.getDireita()).setPai(y);
                }
                this.transplante(z, y);
                y.setEsquerda(z.getEsquerda());
                (y.getEsquerda()).setPai(y);
            }
        }
    }

    public Celula busca(Celula x, int k) {
        //Método para buscar um nó na árvore.
        if (x == null || k == x.getKey()){
            return x;
        }
        if (k < x.getKey()){
            return busca(x.getEsquerda(),k);
        } else {
            return busca(x.getDireita(), k);
        }
    }

    public Celula minimo(Celula x) {
        //Método recursivo para encontrar o mínimo da árvore.
        while (x.getEsquerda() != null) {
            x = x.getEsquerda();
        }
        return x;
    }

    public Celula maximo(Celula x) {
        //Método recursivo para encontrar o máximo da árvore.
        while (x.getDireita() != null) {
            x = x.getDireita();
        }
        return x;
    }

    public Celula sucessor(Celula x) {
        //Método recursivo para encontrar o sucessor de um nodo.
        if (x.getDireita() == null) {
            return this.minimo(x.getDireita());
        }
        Celula y = x.getPai();
        while (y != null && x == y.getDireita()) {
            x = y;
            y = y.getPai();
        }
        return y;
    }

    public Celula predecessor(Celula x) {
        //Método recursivo para encontrar o predecessor de um nodo.
        if (x.getEsquerda() != null) {
            return this.maximo(x.getEsquerda());
        }
        Celula y = x.getPai();
        while (y != null && x == y.getEsquerda()) {
            x = y;
            y = y.getPai();
        }
        return y;
    }

    public void transplante(Celula u, Celula v) {
        //Método para realizar um transplante. Substitui uma subárvore como um filho de seu pai por outra árvore.
        if (u.getPai() == null) {
            this.raiz = v;
        } else {
            if (u == u.getPai().getEsquerda()){
                u.getPai().setEsquerda(v);
            } else {
                u.getPai().setDireita(v);
            }
        }
        if (v != null){
            v.setPai(u.getPai());
        }
    }

    public void emOrdem(Celula x) {
        //Método recursivo para percorrer a árvore em-ordem.
        if (x != null) {
            this.emOrdem(x.getEsquerda());
            System.out.println(x.getKey());
            this.emOrdem(x.getDireita());
        }
    }

    public void preOrdem(Celula x) {
        //Método recursivo para percorrer a árvore pré-ordem.
        if (x != null) {
            System.out.println(x.getKey());
            this.preOrdem(x.getEsquerda());
            this.preOrdem(x.getDireita());
        }
    }

    public void posOrdem(Celula x) {
        //Método recursivo para percorrer a árvore pós-ordem.
        if (x != null) {
            this.posOrdem(x.getEsquerda());
            this.posOrdem(x.getDireita());
            System.out.println(x.getKey());
        }
    }
}
