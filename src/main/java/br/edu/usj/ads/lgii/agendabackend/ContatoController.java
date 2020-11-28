package br.edu.usj.ads.lgii.agendabackend;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@ResponseBody //
@CrossOrigin //receber requisicoes de outras aplicacoes(algum ip qqr)
@RequestMapping("/contato") //colocacando na classe ele aprescenta o prefixo/ ...)
public class ContatoController {

    @Autowired
    ContatoRepository contatoRepository;

   
@GetMapping(value ="/")
public List<Contato> getListarTodos() {
    List<Contato> lista = contatoRepository.findAll();
    return lista;
}
    @GetMapping(value ="/{id}")
    public Contato getContatoPorId(@PathVariable Long id) {
        Contato contato = contatoRepository.findById(id).get();
        return contato;
}
    @PostMapping(value="/")
        public Contato postAdicionar(@RequestBody Contato contato){
            Contato contatoNovo = contatoRepository.save(contato);
            return contatoNovo;
    }
    @GetMapping(value="/delete/{id}")
    public void getDeletar(@PathVariable Long id) {
        contatoRepository.deleteById(id);
        
    }
    //mapeamento de delete
    @DeleteMapping(value="/{id}")
    public void deletetDeletar(@PathVariable Long id) {
    contatoRepository.deleteById(id);
    }
   
   @GetMapping(value="/pesquisar")
   public List<Contato> getPesquisarPornome(@RequestParam String nome) {
       List<Contato> lista = contatoRepository.findByNomeContainingIgnoreCase(nome);
       return lista;
   }
   
}
