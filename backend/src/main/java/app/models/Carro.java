package app.models;

/**
 *
 * @author Lucas
 */
public class Carro {

    private String nomeLoja; 
    private String categoriaCarro;
    private int capacidadeLimite; 
    private int taxa[][] = new int[2][2]; //O primeiro [] eh referente ao tipo de cliente e o segundo [] eh referente aos dias da semana.
    private boolean disponibilidade=true;
    private int valorTotal;

    public Carro(String nomeLoja,  String categoriaCarro, int capacidadeLimite, int taxa[][]){
        this.setNomeLoja(nomeLoja);
        this.setCategoriaCarro(categoriaCarro);
        this.setCapacidadeLimite(capacidadeLimite);
        this.setTaxa(taxa);
        this.setValorTotal(0);
    }

    public Carro(){}


    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponivel) {
        this.disponibilidade = disponivel;
    }
    
    public String getNomeLoja() {
        return nomeLoja;
    }

    public void setNomeLoja(String nome) {
        this.nomeLoja = nome;
    }

    public int[][] getTaxa() {
        return taxa;
    }

    public void setTaxa(int[][] taxa) {
        this.taxa = taxa;
    }

    public String getCategoriaCarro() {
        return categoriaCarro;
    }

    public void setCategoriaCarro(String categoriaCarro) {
        this.categoriaCarro = categoriaCarro;
    }
    
    public int getCapacidadeLimite() {
        return capacidadeLimite;
    }

    public void setCapacidadeLimite(int capacidadeLimite) {
        this.capacidadeLimite = capacidadeLimite;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }
}
