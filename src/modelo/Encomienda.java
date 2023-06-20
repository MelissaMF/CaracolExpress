package modelo;

public class Encomienda {
  
    private int en_id;
    private String en_destinatario;
    private String ed_direccion;
    private String en_tipo;
    private boolean en_entregadomicilio;
    private String en_tamano;
    private String en_remitente;
    
    public Encomienda(int id){
        this.en_id = id;
    }

    public Encomienda() {
        this.en_id = 0;
        this.en_destinatario = "";
        this.ed_direccion = "";
        this.en_tipo = "";
        this.en_entregadomicilio = false;
        this.en_remitente = "";
    }

    public int getEn_id() {
        return en_id;
    }

    public void setEn_id(int en_id) {
        this.en_id = en_id;
    }

    public String getEn_destinatario() {
        return en_destinatario;
    }

    public void setEn_destinatario(String en_destinatario) {
        this.en_destinatario = en_destinatario;
    }

    public String getEd_direccion() {
        return ed_direccion;
    }

    public void setEd_direccion(String ed_direccion) {
        this.ed_direccion = ed_direccion;
    }

    public String getEn_tipo() {
        return en_tipo;
    }

    public void setEn_tipo(String en_tipo) {
        this.en_tipo = en_tipo;
    }

    public boolean isEn_entregadomicilio() {
        return en_entregadomicilio;
    }

    public String getEn_tamano() {
        return en_tamano;
    }

    public void setEn_tamano(String en_tamano) {
        this.en_tamano = en_tamano;
    }
    
    public void setEn_entregadomicilio(boolean en_entregadomicilio) {
        this.en_entregadomicilio = en_entregadomicilio;
    }

    public String getEn_remitente() {
        return en_remitente;
    }

    public void setEn_remitente(String en_remitente) {
        this.en_remitente = en_remitente;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + this.en_id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Encomienda other = (Encomienda) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Encomienda{" + "en_id=" + en_id + ", en_destinatario=" + en_destinatario + ", ed_direccion=" + ed_direccion + ", en_tipo=" + en_tipo + ", en_entregadomicilio=" + en_entregadomicilio + ", en_remitente=" + en_remitente + '}';
    }
    
    
    
}
