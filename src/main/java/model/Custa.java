package model;

import jakarta.persistence.*;

import java.util.Date;

@Entity(name="Custa")
@Table(name="custa")
public class Custa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Date dataCusta;
    private String descricaoCusta;
    private double valorCusta;
    @ManyToOne
    @JoinColumn(name = "processo_id", referencedColumnName = "id")
    private Processo processo;

    public int registrarCusta(){
        return 0;
    }

    public String consultarCusta(){
        return descricaoCusta;
    }

    public String listarCusta(){
        return descricaoCusta;
    }
}
