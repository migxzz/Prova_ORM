package br.ifsul.edu.br.prova_orm.processos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity (name="Processo")
@Table(name="processos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Processo {
    @Id @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroProcesso;
    private String  aberturaProcesso;

    private Date conclusaoProcesso;
    private String descricaoProcesso;

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