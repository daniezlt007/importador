package br.com.deadsystem.importador.controller;

import br.com.deadsystem.importador.model.HeaderDataTextCorreto;
import br.com.deadsystem.importador.service.HeaderDataTextServiceImpl;
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
@RequestMapping("/api/import/headertext")
public class HeaderDataTextController {

    @Autowired
    private HeaderDataTextServiceImpl dataTextService;

    @PostMapping("/data")
    public ResponseEntity<?> importItemData(@RequestParam("file") MultipartFile file) {
        List<HeaderDataTextCorreto> itemDataList = new ArrayList<>();

        if (file.isEmpty()) {
            return new ResponseEntity<>("Por favor, envie um arquivo.", HttpStatus.BAD_REQUEST);
        }
        List<HeaderDataTextCorreto> dataList = this.dataTextService.fromStringHeaderDataopenCV(file);
        return ResponseEntity.ok(dataList);

    }




}
