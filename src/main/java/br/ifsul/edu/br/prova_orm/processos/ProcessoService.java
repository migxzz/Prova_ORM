package br.ifsul.edu.br.prova_orm.processos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProcessoService {

    @Autowired
    private ProcessoRepository rep;

    public Processo insert(Processo processo) {
        Assert.isNull(processo.getId(), "Não foi possível inserir");
        return rep.save(processo);
    }

    public List<Processo> getProcessos() {
        return rep.findAll();
    }

    public Processo getProcessoById(Long id) {
        Optional<Processo> optional = rep.findById(id);
        return optional.orElse(null);
    }

    public Processo update(Processo processo) {
        Assert.notNull(processo, "O objeto processo não pode ser nulo");
        Assert.notNull(processo.getId(), "Não foi possível atualizar o registro, pois o ID é nulo");

        // Busca o processo no banco de dados
        Optional<Processo> optional = rep.findById(processo.getId());

        return optional.map(db -> {
            // Atualiza apenas as propriedades não nulas
            if (processo.getDescricaoProcesso() != null) {
                db.setDescricaoProcesso(processo.getDescricaoProcesso());
            }
            if (processo.getNumeroProcesso() != null) {
                db.setNumeroProcesso(processo.getNumeroProcesso());
            }
            if (processo.getAberturaProcesso() != null) {
                db.setAberturaProcesso(processo.getAberturaProcesso());
            }
            if (processo.getConclusaoProcesso() != null) {
                db.setConclusaoProcesso(processo.getConclusaoProcesso());
            }

            // Salva as alterações no banco de dados
            return rep.save(db);
        }).orElse(null); // Retorna null se o processo não for encontrado
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }
}