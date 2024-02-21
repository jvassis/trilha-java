public class NoDuplo<T> {
    private T conteudo;
    private NoDuplo<T> noAnterior;
    private NoDuplo<T> noProximo;

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public NoDuplo<T> getNoAnterior() {
        return noAnterior;
    }

    public void setNoAnterior(NoDuplo<T> noAnterior) {
        this.noAnterior = noAnterior;
    }

    public NoDuplo<T> getNoProximo() {
        return noProximo;
    }

    public void setNoProximo(NoDuplo<T> noProximo) {
        this.noProximo = noProximo;
    }

    public NoDuplo(T conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public String toString() {
        return "NoDuplo{" + conteudo + "}";
    }
}
