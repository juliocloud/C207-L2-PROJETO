package inatel.Model;

public class CRLV {
    private String id;
    private String vencimento;

    public String getId() {
        return id;
    }

    public String getVencimento() {
        return vencimento;
    }

    public CRLV(String id, String vencimento) {
        this.id = id;
        this.vencimento = vencimento;
    }
}
