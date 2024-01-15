package br.com.deadsystem.importador.controller;

import br.com.deadsystem.importador.model.dto.RelDto;
import br.com.deadsystem.importador.service.GeradorRelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/relatorio")
public class RelatorioController {

    @Autowired
    private GeradorRelatorioService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> retornoRelatorio(@PathVariable("id") String id){
        RelDto relDto = this.service.retornoRel(id);
        return ResponseEntity.ok(relDto);
    }

}
