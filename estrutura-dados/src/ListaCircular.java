public class ListaCircular<T> {
    private class No<T> {
        private T conteudo;
        private No<T> proximo;
        
        public No(T conteudo) {
            this.proximo = null;
            this.conteudo = conteudo;
        }
    
        public T getConteudo() {
            return conteudo;
        }
    
        public void setConteudo(T conteudo) {
            this.conteudo = conteudo;
        }
    
        public No<T> getProximo() {
            return proximo;
        }
    
        public void setProximo(No<T> proximo) {
            this.proximo = proximo;
        }
    
        @Override
        public String toString() {
            return "No{conteudo=" + conteudo + "}";
        }
        
    }
    
    private No<T> cabeca;
    private No<T> cauda;
    private int tamanhoLista;

    public ListaCircular() {
        this.cauda = null;
        this.cabeca = null;
        this.tamanhoLista = 0;
    }

    public int size() {
        return this.tamanhoLista;
    }

    public boolean isEmpty() {
        return this.tamanhoLista == 0 ? true : false;
    }

    private No<T> getNo(int index) {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException("A lista está vazia!");
        }

        if (index == 0) {
            return this.cauda;
        }

        No<T> aux = this.cauda;

        for (int i=0; (i < index) && (aux != null); i++) {
            aux = aux.getProximo();
        }

        return aux;
    }

    public T get(int index) {
        return this.getNo(index).getConteudo();
    }

    public void remove(int index) {
        if (index >= this.tamanhoLista) {
            throw new IndexOutOfBoundsException("O índice é maior que o tamanho da lista!");
        }

        No<T> aux = cauda;

        if (index == 0) {
            this.cauda = this.cabeca.getProximo();
            this.cabeca.setProximo(this.cauda);
        } else if (index == 1) {
            this.cauda.setProximo(this.cauda.getProximo().getProximo());
        } else {
            for (int i=0; i < index-1; i++) {
                aux = aux.getProximo();
            }

            aux.setProximo(aux.getProximo().getProximo());
        }

        this.tamanhoLista--;
    }

    public void add(T conteudo) {
        No<T> novo = new No(conteudo);

        if (this.tamanhoLista == 0) {
            this.cabeca = novo;
            this.cauda = this.cabeca;
            this.cabeca.setProximo(this.cauda);
        } else {
            novo.setProximo(this.cauda);
            this.cabeca.setProximo(novo);
            this.cauda = novo;
        }

        this.tamanhoLista++;
    }

    @Override
    public String toString() {
        String str = "";

        No<T> aux = this.cauda;

        for (int i=0; i < this.size(); i++) {
            str += "[No{conteudo=" + aux.getConteudo() + "}]-->";
            aux = aux.getProximo();
        }

        str += this.size() != 0 ? "(Retorna ao inicio)" : "[]";

        return str;
    }
}
