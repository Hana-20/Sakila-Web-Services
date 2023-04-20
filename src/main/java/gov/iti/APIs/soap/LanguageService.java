package gov.iti.APIs.soap;


import java.util.ArrayList;
import java.util.List;

import gov.iti.models.dtos.LanguageDto;
import gov.iti.models.dtos.SakilaDtos;
import gov.iti.services.CrudServices;
import jakarta.jws.WebService;

@WebService
public class LanguageService {
    
    private CrudServices<LanguageDto> languageService;
    
    public LanguageService() {
        languageService = new CrudServices<>(LanguageDto.class);
    }
    
    public LanguageDto getLanguageById(Integer id) {
        return (LanguageDto) languageService.getdtoById(id);
    }
    
    public void deleteLanguage(Integer id) {
        languageService.delete(id);
    }
    
    public void updateLanguage(LanguageDto languageDto) {
        languageService.update(languageDto);
    }
    
    public void addLanguage(LanguageDto languageDto) {
        languageService.add(languageDto);
    }
    
    public List<LanguageDto> findAllLanguages() {
        List<LanguageDto> languageDtos = new ArrayList<>();
        for (SakilaDtos sakilaDto : languageService.findAll()) {
            LanguageDto languageDto = (LanguageDto) sakilaDto;
            languageDtos.add(languageDto);
        }
        return languageDtos;
    }
}
