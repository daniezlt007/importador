package br.com.deadsystem.importador.controller;

import br.com.deadsystem.importador.model.dto.RelDto;
import br.com.deadsystem.importador.service.GeradorRelatorioService;
import br.com.deadsystem.importador.service.RelatorioUtil;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/relatorio")
public class RelatorioController {

    @Autowired
    private GeradorRelatorioService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> retornoRelatorio(@PathVariable("id") String id){
        RelDto relDto = this.service.retornoRel(id);
        RelatorioUtil relatorioUtil = new RelatorioUtil();
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("scacCode", relDto.getScacCode());
        try {
            relatorioUtil.gerarRelatorio(relDto);
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(relDto);
    }

}
