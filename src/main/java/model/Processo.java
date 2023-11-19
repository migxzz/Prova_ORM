package model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity (name="Processo")
@Table(name="processos")
public class Processo {
    @Id @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long numeroProcesso;
    private Date aberturaProcesso;

    private Date conclusaoProcesso;
    private String descricaoProcesso;
    private Situacao situacaoProcesso;

    @ManyToMany(mappedBy = "advogado")
    private List<Advogado> advogados;
    @OneToMany(mappedBy = "processo")
    private List<Audiencia> audiencias;
    @OneToMany(mappedBy = "processo")
    private List<Custa>custas;

    public int registrarProcesso(){
        return 0;
    }

    public String consultarProcesso(){
        return descricaoProcesso;
    }
    public String listarProcesso(){
        return descricaoProcesso;
    }

    public int atualizarProcesso(){
        return 0;
    }
}
