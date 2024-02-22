package Modelos;

public class Obj extends ObjArvore<Obj> {
    Integer meuValor;

    public Obj(Integer meuValor) {
        this.meuValor = meuValor;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((meuValor == null) ? 0 : meuValor.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Obj other = (Obj) obj;
        if (meuValor == null) {
            if (other.meuValor != null)
                return false;
        } else if (!meuValor.equals(other.meuValor))
            return false;
        return true;
    }

    @Override
    public int compareTo(Obj o) {
        if (this.meuValor > o.meuValor) {
            return 1;
        } else if (this.meuValor < o.meuValor) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return meuValor.toString();
    }

}