package entidade.compra.modelo;

import java.sql.Date;

/**
 *
 * @author caioo
 */
public class Compra {
    
    private Integer id;
    private Date dataHora;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }
}
