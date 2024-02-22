class NoBin<T extends Comparable<T>> {
    private NoBin<T> noEsq;
    private NoBin<T> noDir;
    private T conteudo;        

    public NoBin<T> getNoEsq() {
        return noEsq;
    }

    public void setNoEsq(NoBin<T> noEsq) {
        this.noEsq = noEsq;
    }

    public NoBin<T> getNoDir() {
        return noDir;
    }

    public void setNoDir(NoBin<T> noDir) {
        this.noDir = noDir;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public NoBin(T conteudo) {
        this.conteudo = conteudo;
        this.noEsq = this.noDir = null;
    }

    public NoBin() {
        
    }

    @Override
    public String toString() {
        return "No{conteudo=" + this.conteudo + "}";
    }

}

public class ArvoreBinaria<T extends Comparable<T>> {
    public NoBin<T> raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(T conteudo) {
        NoBin<T> novoNo = new NoBin<>(conteudo);
        this.raiz = inserir(this.raiz, novoNo);
    }

    private NoBin<T> inserir(NoBin<T> noAtual, NoBin<T> novoNo) {
        if (noAtual == null) {
            return novoNo;
        } else if (novoNo.getConteudo().compareTo(noAtual.getConteudo()) < 0) {
            noAtual.setNoEsq(this.inserir(noAtual.getNoEsq(), novoNo));
        } else {
            noAtual.setNoDir(this.inserir(noAtual.getNoDir(), novoNo));
        }

        return noAtual;
    }

    public void exibirInOrdem() {
        System.out.println("\nExibindo InOrdem");
        this.exibirInOrdem(this.raiz);
        System.out.println();
    }

    private void exibirInOrdem(NoBin<T> noAtual) {
        if (noAtual != null) {
            this.exibirInOrdem(noAtual.getNoEsq());
            System.out.print(noAtual.getConteudo() + ", ");
            this.exibirInOrdem(noAtual.getNoDir());
        }
    }

    public void exibirPosOrdem() {
        System.out.println("\nExibindo em PosOrdem");
        this.exibirPosOrdem(this.raiz);
        System.out.println();
    }

    private void exibirPosOrdem(NoBin<T> noAtual) {
        if (noAtual != null) {
            this.exibirInOrdem(noAtual.getNoEsq());
            this.exibirInOrdem(noAtual.getNoDir());
            System.out.print(noAtual.getConteudo() + ", ");
        }
    }

    public void exibirPreOrdem() {
        System.out.println("\nExibindo em PreOrdem");
        this.exibirPreOrdem(this.raiz);
        System.out.println();
    }

    private void exibirPreOrdem(NoBin<T> noAtual) {
        if (noAtual != null) {
            System.out.print(noAtual.getConteudo() + ", ");
            this.exibirInOrdem(noAtual.getNoEsq());
            this.exibirInOrdem(noAtual.getNoDir());
        }
    }

    public void remover(T conteudo) {
        try {
            NoBin<T> noAtual = this.raiz;
            NoBin<T> noPai = null;
            NoBin<T> noFilho = null;
            NoBin<T> noTemp = null;

            while (noAtual != null && !noAtual.getConteudo().equals(conteudo)) {
                noPai = noAtual;
                if (conteudo.compareTo(noAtual.getConteudo()) < 0) {
                    noAtual = noAtual.getNoEsq();
                } else {
                    noAtual = noAtual.getNoDir();
                }
            }

            if (noAtual == null) {
                System.out.println("Conteudo nao encontrado! (Try)");
            }

            if (noPai == null) {
                if (noAtual.getNoDir() == null) {
                    this.raiz = noAtual.getNoEsq();
                } else if (noAtual.getNoEsq() == null) {
                    this.raiz = noAtual.getNoDir();
                } else {
                    for (
                        noTemp = noAtual, noFilho = noAtual.getNoEsq();
                        noFilho.getNoDir() != null;
                        noTemp = noFilho, noFilho = noFilho.getNoEsq()
                    ) {
                        if(noFilho != noAtual.getNoEsq()) {
                            noTemp.setNoDir(noFilho.getNoEsq());
                            noFilho.setNoEsq(this.raiz.getNoEsq());
                        }
                    }

                    noFilho.setNoDir(this.raiz.getNoDir());
                    this.raiz = noFilho;
                }

            } else if (noAtual.getNoDir() == null) {
                if (noPai.getNoEsq() == noAtual) {
                    noPai.setNoEsq(noAtual.getNoEsq());
                } else {
                    noPai.setNoDir(noAtual.getNoEsq());
                }

            } else if (noAtual.getNoEsq() == null) {
                if (noPai.getNoDir() == noAtual) {
                    noPai.setNoEsq(noAtual.getNoDir());
                } else {
                    noPai.setNoDir(noAtual.getNoDir());
                }

            } else {
                for (
                    noTemp = noAtual, noFilho = noAtual.getNoEsq();
                    noFilho.getNoDir() != null;
                    noTemp = noFilho, noFilho = noFilho.getNoDir()    
                ) {
                    if (noFilho != noAtual.getNoEsq()) {
                        noTemp.setNoDir(noFilho.getNoEsq());
                        noFilho.setNoEsq(noAtual.getNoEsq());
                    }

                    noFilho.setNoDir(noAtual.getNoDir());

                    if (noPai.getNoEsq() == noAtual) {
                        noPai.setNoEsq(noFilho);
                    } else {
                        noPai.setNoDir(noFilho);
                    }
                }
            }

        } catch(NullPointerException e) {
            System.out.println("Conteudo nao encontrado! (Catch)");
        }
    }
}
