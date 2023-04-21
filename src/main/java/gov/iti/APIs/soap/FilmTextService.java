package gov.iti.APIs.soap;

import java.util.ArrayList;
import java.util.List;

import gov.iti.APIs.Exception.ResourceNotFoundException;
import gov.iti.models.dtos.FilmTextDto;
import gov.iti.models.dtos.SakilaDtos;
import gov.iti.services.CrudServices;
import jakarta.jws.WebService;

@WebService
public class FilmTextService {
    
    private CrudServices<FilmTextDto> filmTextService;
    
    public FilmTextService() {
        filmTextService = new CrudServices<>(FilmTextDto.class);
    }
    
    public FilmTextDto getFilmTextById(Integer id) {

        FilmTextDto filmTextDto = (FilmTextDto) filmTextService.getdtoById(id);
        if (filmTextDto== null)
        throw new ResourceNotFoundException("FilmText with ID:" + id + " Not Found");
            return filmTextDto;
    }
    
    public void deleteFilmText(Integer id) {
        filmTextService.delete(id);
    }
    
    public void updateFilmText(FilmTextDto filmTextDto) {
        filmTextService.update(filmTextDto);
    }
    
    public void addFilmText(FilmTextDto filmTextDto) {
        filmTextService.add(filmTextDto);
    }
    
    public List<FilmTextDto> findAllFilmTexts() {
        List<FilmTextDto> filmTextDtos = new ArrayList<>();
        for (SakilaDtos sakilaDto : filmTextService.findAll()) {
            FilmTextDto filmTextDto = (FilmTextDto) sakilaDto;
            filmTextDtos.add(filmTextDto);
        }
        return filmTextDtos;
    }
}
