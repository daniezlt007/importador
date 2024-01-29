package br.com.deadsystem.importador.controller;

import br.com.deadsystem.importador.model.Charge;
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
@RequestMapping("/api/import/charge")
public class ChargeController {

    @Autowired
    private ChargeServiceImpl chargeService;

    @PostMapping("/data")
    public ResponseEntity<?> chargeData(@RequestParam("file") MultipartFile file) {
        List<Charge> itemDataList = new ArrayList<>();

        if (file.isEmpty()) {
            return new ResponseEntity<>("Por favor, envie um arquivo.", HttpStatus.BAD_REQUEST);
        }
        List<Charge> dataList = this.chargeService.fromStringChargeDataopenCV(file);
        return ResponseEntity.ok(dataList);

    }

}
