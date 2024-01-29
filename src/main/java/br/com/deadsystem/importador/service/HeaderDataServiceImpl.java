package br.com.deadsystem.importador.service;

import br.com.deadsystem.importador.model.HeaderDataCorreto;
import br.com.deadsystem.importador.repository.HeaderDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeaderDataServiceImpl implements HeaderDataService {

    @Autowired
    private HeaderDataRepository repository;

    @Override
    public HeaderDataCorreto save(HeaderDataCorreto headerDataCorreto) {
        if(headerDataCorreto != null){
            HeaderDataCorreto save = this.repository.save(headerDataCorreto);
            return save;
        }  else {
            throw new RuntimeException("Object not found.");
        }
    }

    @Override
    public HeaderDataCorreto update(HeaderDataCorreto headerDataCorretoUpdate) {
        Optional<HeaderDataCorreto> headerDataOptional = this.repository.findById(headerDataCorretoUpdate.getId());
        if(headerDataOptional.isPresent()){
            HeaderDataCorreto headerDataCorreto = headerDataOptional.get();
            headerDataCorreto.setId(headerDataCorreto.getId());
            headerDataCorreto.setUbli(headerDataCorretoUpdate.getUbli());
            headerDataCorreto.setScacCode(headerDataCorretoUpdate.getScacCode());
            headerDataCorreto.setCreationDate(headerDataCorretoUpdate.getCreationDate());
            headerDataCorreto.setSailingDate(headerDataCorretoUpdate.getSailingDate());
            headerDataCorreto.setIssueDate(headerDataCorretoUpdate.getIssueDate());
            headerDataCorreto.setIssuingOffice(headerDataCorretoUpdate.getIssuingOffice());
            headerDataCorreto.setOrigin(headerDataCorretoUpdate.getOrigin());
            headerDataCorreto.setPortOfLoading(headerDataCorretoUpdate.getPortOfLoading());
            headerDataCorreto.setPortOfDischarge(headerDataCorretoUpdate.getPortOfDischarge());
            headerDataCorreto.setShipper(headerDataCorretoUpdate.getShipper());
            headerDataCorreto.setConsignee(headerDataCorretoUpdate.getConsignee());
            headerDataCorreto.setNotify1(headerDataCorretoUpdate.getNotify1());
            headerDataCorreto.setMultiModal(headerDataCorretoUpdate.getMultiModal());
            headerDataCorreto.setBookingDate(headerDataCorretoUpdate.getBookingDate());
            headerDataCorreto.setShortBlNr(headerDataCorretoUpdate.getShortBlNr());
            headerDataCorreto.setVessel(headerDataCorretoUpdate.getVessel());
            headerDataCorreto.setVoyage(headerDataCorretoUpdate.getVoyage());
            headerDataCorreto.setDirection(headerDataCorretoUpdate.getDirection());
            headerDataCorreto.setVersion(headerDataCorretoUpdate.getVersion());
            headerDataCorreto.setCorrectionCode(headerDataCorreto.getCorrectionCode());
            headerDataCorreto.setCreationTimeStamp(headerDataCorretoUpdate.getCreationTimeStamp());
            headerDataCorreto.setLastUnloadDate(headerDataCorretoUpdate.getLastUnloadDate());
            headerDataCorreto.setFinalManifestDate(headerDataCorretoUpdate.getFinalManifestDate());
            headerDataCorreto.setIssuingOfficePlace(headerDataCorretoUpdate.getIssuingOfficePlace());
            headerDataCorreto.setIssuingOfficeHsdg(headerDataCorreto.getIssuingOfficeHsdg());
            headerDataCorreto.setReleasedAt(headerDataCorretoUpdate.getReleasedAt());
            headerDataCorreto.setReleasedAtPlace(headerDataCorretoUpdate.getReleasedAtPlace());
            headerDataCorreto.setReleasedHsdg(headerDataCorretoUpdate.getReleasedHsdg());
            headerDataCorreto.setService(headerDataCorretoUpdate.getService());
            headerDataCorreto.setBookingNumber(headerDataCorretoUpdate.getBookingNumber());
            headerDataCorreto.setUbli13(headerDataCorretoUpdate.getUbli13());
            return this.repository.save(headerDataCorreto);
        } else {
            throw new RuntimeException("Object not found.");
        }
    }

    @Override
    public HeaderDataCorreto findById(Long id) {
        Optional<HeaderDataCorreto> headerDataOptional = this.repository.findById(id);
        if(headerDataOptional.isPresent()){
            return headerDataOptional.get();
        } else {
            throw new RuntimeException("Object not found.");
        }
    }

    @Override
    public List<HeaderDataCorreto> findAll() {
        return this.repository.findAll();
        //return this.repository.buscarTodosPorLimit10();
    }

    @Override
    public void delete(Long id) {
        Optional<HeaderDataCorreto> headerDataOptional = this.repository.findById(id);
        if(headerDataOptional.isPresent()){
            this.repository.delete(headerDataOptional.get());
        } else {
            throw new RuntimeException("Object not found.");
        }
    }

    @Override
    public List<HeaderDataCorreto> saveAll(List<HeaderDataCorreto> headerDataCorretoList) {
        if(!headerDataCorretoList.isEmpty()){
            List<HeaderDataCorreto> dataList = this.repository.saveAll(headerDataCorretoList);
            return dataList;
        } else {
            throw new RuntimeException("Object list is empty in method saveAll");
        }
    }

    public HeaderDataCorreto findByUbli(String ubli){
        if(!ubli.isEmpty()){
            HeaderDataCorreto headerDataCorreto = this.repository.findByUbli(ubli);
            return headerDataCorreto;
        } else {
            throw new RuntimeException("Object is empty in method findByUbli");
        }
    }

    public static HeaderDataCorreto fromStringHeaderData(String line) {
        HeaderDataCorreto headerDataCorreto = new HeaderDataCorreto();
        String[] parts = line.split("\\|");

        headerDataCorreto.setUbli(parts[0]);
        headerDataCorreto.setScacCode(parts[1]);
        headerDataCorreto.setCreationDate(parts[2]);
        headerDataCorreto.setSailingDate(parts[3]);
        headerDataCorreto.setIssueDate(parts[4]);
        headerDataCorreto.setIssuingOffice(parts[5]);
        headerDataCorreto.setOrigin(parts[6]);
        headerDataCorreto.setPortOfLoading(parts[7]);
        headerDataCorreto.setPortOfDischarge(parts[8]);
        headerDataCorreto.setShipper(parts[9]);
        headerDataCorreto.setConsignee(parts[10]);
        headerDataCorreto.setNotify1(parts[11]);
        headerDataCorreto.setMultiModal(parts[12]);
        headerDataCorreto.setBookingDate(parts[13]);
        headerDataCorreto.setShortBlNr(parts[14]);
        headerDataCorreto.setVessel(parts[15]);
        headerDataCorreto.setVoyage(parts[16]);
        headerDataCorreto.setDirection(parts[17]);
        headerDataCorreto.setVersion(parts[18]);
        headerDataCorreto.setCorrectionCode(parts[19]);
        headerDataCorreto.setCreationTimeStamp(parts[20]);
        headerDataCorreto.setLastUnloadDate(!parts[21].isEmpty() ? parts[21] : null);
        headerDataCorreto.setFinalManifestDate(!parts[21].isEmpty() ? parts[22] : null);
        headerDataCorreto.setIssuingOfficePlace(parts[23]);
        headerDataCorreto.setIssuingOfficeHsdg(parts[24]);
        headerDataCorreto.setReleasedAt(parts[25]);
        headerDataCorreto.setReleasedAtPlace(parts[26]);
        headerDataCorreto.setReleasedHsdg(parts[27]);
        headerDataCorreto.setService(parts[28]);
        headerDataCorreto.setBookingNumber(parts[29]);
        headerDataCorreto.setUbli13(parts[30]);
        return headerDataCorreto;
    }

}
