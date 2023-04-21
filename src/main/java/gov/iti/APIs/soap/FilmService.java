package gov.iti.APIs.soap;


import java.util.ArrayList;
import java.util.List;

import gov.iti.APIs.Exception.ResourceNotFoundException;
import gov.iti.models.dtos.FilmDto;
import gov.iti.models.dtos.SakilaDtos;
import gov.iti.services.CrudServices;
import jakarta.jws.WebService;

@WebService
public class FilmService {
    
    private CrudServices<FilmDto> filmService;
    
    public FilmService() {
        filmService = new CrudServices<>(FilmDto.class);
    }
    
    public FilmDto getFilmById(Integer id) {
        FilmDto filmDto = (FilmDto) filmService.getdtoById(id);
        if (filmDto == null)
        throw new ResourceNotFoundException("Film with ID:" + id + " Not Found");
         return filmDto;
    }
    
    public void deleteFilm(Integer id) {
        filmService.delete(id);
    }
    
    public void updateFilm(FilmDto filmDto) {
        filmService.update(filmDto);
    }
    
    public void addFilm(FilmDto filmDto) {
        filmService.add(filmDto);
    }
    
    public List<FilmDto> findAllFilms() {
        List<FilmDto> filmDtos = new ArrayList<>();
        for (SakilaDtos sakilaDto : filmService.findAll()) {
            FilmDto filmDto = (FilmDto) sakilaDto;
            filmDtos.add(filmDto);
        }
        return filmDtos;
    }
}
