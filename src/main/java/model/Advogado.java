package model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name="Advogado")
@Table (name="advogados")
public class Advogado {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oabAdvogado;
    private String nomeAdvogado;
    private String enderecoAdvogado;
    private String telefoneAdvogado;
    private String bairroAdvogado;
    private String cepAdvogado;
    private String emailAdvogado;
    @ManyToMany
    @JoinTable(
            name = "advogados_processos",
            joinColumns = @JoinColumn(name="advogados_id"),
            inverseJoinColumns = @JoinColumn(name="processos_id")
    )
    private List<Processo> processos;

    int registrarAdvogado(){
        return 0;
    }
    String consultarAdvogado(){
        return nomeAdvogado;
    }

    String listarAdvogado(){
        return nomeAdvogado;
    }
}
