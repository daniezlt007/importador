package br.com.deadsystem.importador.service;

import br.com.deadsystem.importador.model.HeaderData;
import br.com.deadsystem.importador.repository.HeaderDataRepository;
import br.com.deadsystem.importador.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class HeaderDataDataServiceImpl implements HeaderDataService {

    @Autowired
    private HeaderDataRepository repository;

    @Override
    public HeaderData save(HeaderData headerData) {
        if(headerData != null){
            HeaderData save = this.repository.save(headerData);
            return save;
        }  else {
            throw new RuntimeException("Object not found.");
        }
    }

    @Override
    public HeaderData update(HeaderData headerDataUpdate) {
        Optional<HeaderData> headerDataOptional = this.repository.findById(headerDataUpdate.getId());
        if(headerDataOptional.isPresent()){
            HeaderData headerData = headerDataOptional.get();
            headerData.setId(headerData.getId());
            headerData.setUbli(headerDataUpdate.getUbli());
            headerData.setScacCode(headerDataUpdate.getScacCode());
            headerData.setCreationDate(headerDataUpdate.getCreationDate());
            headerData.setSailingDate(headerDataUpdate.getSailingDate());
            headerData.setIssueDate(headerDataUpdate.getIssueDate());
            headerData.setIssuingOffice(headerDataUpdate.getIssuingOffice());
            headerData.setOrigin(headerDataUpdate.getOrigin());
            headerData.setPortOfLoading(headerDataUpdate.getPortOfLoading());
            headerData.setPortOfDischarge(headerDataUpdate.getPortOfDischarge());
            headerData.setShipper(headerDataUpdate.getShipper());
            headerData.setConsignee(headerDataUpdate.getConsignee());
            headerData.setNotify1(headerDataUpdate.getNotify1());
            headerData.setMultiModal(headerDataUpdate.getMultiModal());
            headerData.setBookingDate(headerDataUpdate.getBookingDate());
            headerData.setShortBlNr(headerDataUpdate.getShortBlNr());
            headerData.setVessel(headerDataUpdate.getVessel());
            headerData.setVoyage(headerDataUpdate.getVoyage());
            headerData.setDirection(headerDataUpdate.getDirection());
            headerData.setVersion(headerDataUpdate.getVersion());
            headerData.setCorrectionCode(headerData.getCorrectionCode());
            headerData.setCreationTimeStamp(headerDataUpdate.getCreationTimeStamp());
            headerData.setLastUnloadDate(headerDataUpdate.getLastUnloadDate());
            headerData.setFinalManifestDate(headerDataUpdate.getFinalManifestDate());
            headerData.setIssuingOfficePlace(headerDataUpdate.getIssuingOfficePlace());
            headerData.setIssuingOfficeHsdg(headerData.getIssuingOfficeHsdg());
            headerData.setReleasedAt(headerDataUpdate.getReleasedAt());
            headerData.setReleasedAtPlace(headerDataUpdate.getReleasedAtPlace());
            headerData.setReleasedHsdg(headerDataUpdate.getReleasedHsdg());
            headerData.setService(headerDataUpdate.getService());
            headerData.setBookingNumber(headerDataUpdate.getBookingNumber());
            headerData.setUbli13(headerDataUpdate.getUbli13());
            return this.repository.save(headerData);
        } else {
            throw new RuntimeException("Object not found.");
        }
    }

    @Override
    public HeaderData findById(Long id) {
        Optional<HeaderData> headerDataOptional = this.repository.findById(id);
        if(headerDataOptional.isPresent()){
            return headerDataOptional.get();
        } else {
            throw new RuntimeException("Object not found.");
        }
    }

    @Override
    public List<HeaderData> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void delete(Long id) {
        Optional<HeaderData> headerDataOptional = this.repository.findById(id);
        if(headerDataOptional.isPresent()){
            this.repository.delete(headerDataOptional.get());
        } else {
            throw new RuntimeException("Object not found.");
        }
    }

    @Override
    public List<HeaderData> saveAll(List<HeaderData> headerDataList) {
        if(!headerDataList.isEmpty()){
            List<HeaderData> dataList = this.repository.saveAll(headerDataList);
            return dataList;
        } else {
            throw new RuntimeException("Object list is empty in method saveAll");
        }
    }

    public static HeaderData fromStringHeaderData(String line) {
        HeaderData headerData = new HeaderData();
        String[] parts = line.split("\\|");

        headerData.setUbli(parts[0]);
        headerData.setScacCode(parts[1]);
        headerData.setCreationDate(Util.convertDate(parts[2]));
        headerData.setSailingDate(Util.convertDate(parts[3]));
        headerData.setIssueDate(Util.convertDate(parts[4]));
        headerData.setIssuingOffice(parts[5]);
        headerData.setOrigin(parts[6]);
        headerData.setPortOfLoading(parts[7]);
        headerData.setPortOfDischarge(parts[8]);
        headerData.setShipper(parts[9]);
        headerData.setConsignee(parts[10]);
        headerData.setNotify1(parts[11]);
        headerData.setMultiModal(parts[12]);
        headerData.setBookingDate(Util.convertDate(parts[13]));
        headerData.setShortBlNr(parts[14]);
        headerData.setVessel(parts[15]);
        headerData.setVoyage(parts[16]);
        headerData.setDirection(parts[17]);
        headerData.setVersion(parts[18]);
        headerData.setCorrectionCode(parts[19]);
        headerData.setCreationTimeStamp(Util.convertDateTime(parts[20]));
        headerData.setLastUnloadDate(!parts[21].isEmpty() ? Util.convertDate(parts[21]) : null);
        headerData.setFinalManifestDate(!parts[21].isEmpty() ? Util.convertDate(parts[22]) : null);
        headerData.setIssuingOfficePlace(parts[23]);
        headerData.setIssuingOfficeHsdg(parts[24]);
        headerData.setReleasedAt(parts[25]);
        headerData.setReleasedAtPlace(parts[26]);
        headerData.setReleasedHsdg(parts[27]);
        headerData.setService(parts[28]);
        headerData.setBookingNumber(parts[29]);
        headerData.setUbli13(parts[30]);
        return headerData;
    }

}
