package app.controller;

import app.models.Carro;
import app.service.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import app.models.ObjetoArquivo;
import app.util.json.Json;

@RestController
public class LocacaoController {

    @Autowired
    LojaService lj;

    @PostMapping("/enviarObjetoArquivo")
    public Object testeRetornoVariavel(@RequestBody ObjetoArquivo objetoArquivo){

        return new Json(lj.calcularValorLocacao(objetoArquivo)).getData();
    }

}
