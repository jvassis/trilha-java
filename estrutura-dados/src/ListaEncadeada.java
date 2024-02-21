class ListaEncadeada<T> {
    NoListaEncadeada<T> referenciaEntrada;

    public ListaEncadeada() {
        this.referenciaEntrada = null;
    }

    public int size() {
        int n = 0;

        NoListaEncadeada<T> refAux = referenciaEntrada;

        while (true) {
            if (refAux != null) {
                n += 1;
                if (refAux.getProximoNo() != null) {
                    refAux = refAux.getProximoNo();
                } else {
                    break;
                }
            } else {
                break;
            }
        }

        return n;
    }

    public boolean isEmpty() {
        return referenciaEntrada == null ? true : false;
    }

    public void add(T conteudo) {
        NoListaEncadeada<T> novoNo = new NoListaEncadeada<>(conteudo);

        if (this.isEmpty()) {
            referenciaEntrada = novoNo;
            return;
        }

        NoListaEncadeada<T> noAux = referenciaEntrada;
        for (int i=0; i < this.size()-1; i++) {
            noAux = noAux.getProximoNo();
        }

        noAux.setProximoNo(novoNo);
    }

    private void validaIndice(int index) {
        if (index >= size()) {
            int ultimoIndice = this.size() - 1;
            throw new IndexOutOfBoundsException("Não existe conteúdo no índice " + index + " desta lista. (n=" + ultimoIndice + ").");
        }

    }

    private NoListaEncadeada<T> getNo(int index) {
        validaIndice(index);

        NoListaEncadeada<T> noAux = referenciaEntrada;
        NoListaEncadeada<T> noRetorno = null;

        for(int i=0; i <= index; i++) {
            noRetorno = noAux;
            noAux = noAux.getProximoNo();
        }

        return noRetorno;
    }

    public T get(int index) {
        return getNo(index).getConteudo();
    }

    public T remove(int index) {
        NoListaEncadeada<T> noPivo = this.getNo(index);

        if (index == 0) {
            referenciaEntrada = noPivo.getProximoNo();
            return noPivo.getConteudo();
        }

        NoListaEncadeada<T> noAnterior = getNo(index - 1);
        noAnterior.setProximoNo(noPivo.getProximoNo());
        return noPivo.getConteudo();
    }

    @Override
    public String toString() {
        String str = "";

        NoListaEncadeada<T> noAux = referenciaEntrada;

        for (int i=0; i <= this.size()-1; i++) {
            str += "[No{conteudo=" + noAux.getConteudo() + "}]-->";
            noAux = noAux.getProximoNo();
        }

        str += "null";

        return str;
    }
}
