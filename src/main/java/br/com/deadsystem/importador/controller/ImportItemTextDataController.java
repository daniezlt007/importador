package br.com.deadsystem.importador.controller;

import br.com.deadsystem.importador.model.ItemTextDataCorreto;
import br.com.deadsystem.importador.service.ItemTextDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/import/itemtextdata")
public class ImportItemTextDataController {

    @Autowired
    private ItemTextDataServiceImpl itemTextDataService;

    @PostMapping("/data")
    public ResponseEntity<?> importItemData(@RequestParam("file") MultipartFile file) {
        List<ItemTextDataCorreto> itemDataList = new ArrayList<>();

        if (file.isEmpty()) {
            return new ResponseEntity<>("Por favor, envie um arquivo.", HttpStatus.BAD_REQUEST);
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Pula a primeira linha (cabeçalho)
                }
                ItemTextDataCorreto headerData = this.itemTextDataService.fromStringItemTextData(line);
                itemDataList.add(headerData);
            }

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Falha ao importar os dados de remessa.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        List<ItemTextDataCorreto> dataList = this.itemTextDataService.saveAll(itemDataList);
        return ResponseEntity.ok(dataList);

    }


}
