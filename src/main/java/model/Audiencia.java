package model;

import jakarta.persistence.*;

import java.util.Date;
@Entity (name="Audiencia")
@Table (name="audiencias")
public class Audiencia {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Date dataAudiencia;
    private String parecerAudiencia;
    @ManyToOne
    @JoinColumn(name = "processo_id", referencedColumnName = "id")
    private Processo processo;

    public int registrarAudiencia(){
        return 0;
    }

    public String consultarAudiencia(){
        return parecerAudiencia;
    }

    public String listarAudiencia(){
        return parecerAudiencia;
    }

}
