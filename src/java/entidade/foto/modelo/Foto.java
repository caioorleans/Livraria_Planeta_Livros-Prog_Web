package entidade.foto.modelo;

/**
 *
 * @author caioo
 */
public class Foto {
    
    private Integer id;
    private String endereco;
    private String descricao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getEhCapa() {
        return ehCapa;
    }

    public void setEhCapa(Boolean ehCapa) {
        this.ehCapa = ehCapa;
    }
    private Boolean ehCapa;
}
