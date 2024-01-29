package br.com.deadsystem.importador.controller;

import br.com.deadsystem.importador.model.Charge;
import br.com.deadsystem.importador.model.ChargeCalculoCorreto;
import br.com.deadsystem.importador.service.ChargeCalculoCorretoServiceImpl;
import br.com.deadsystem.importador.service.ChargeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/import/chargecorreto")
public class ChargeCorretoController {

    @Autowired
    private ChargeCalculoCorretoServiceImpl chargeService;

    @PostMapping("/data")
    public ResponseEntity<?> chargeCorretoData(@RequestParam("file") MultipartFile file) {
        List<Charge> itemDataList = new ArrayList<>();

        if (file.isEmpty()) {
            return new ResponseEntity<>("Por favor, envie um arquivo.", HttpStatus.BAD_REQUEST);
        }
        List<ChargeCalculoCorreto> dataList = this.chargeService.fromStringChargeCalculoDataopenCV(file);
        return ResponseEntity.ok(dataList);

    }

}
