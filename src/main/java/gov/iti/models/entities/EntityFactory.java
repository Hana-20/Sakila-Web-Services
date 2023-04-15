package gov.iti.models.entities;

import gov.iti.models.dtos.ActorDto;
import gov.iti.models.dtos.AddressDto;
import gov.iti.models.dtos.CategoryDto;
import gov.iti.models.dtos.CityDto;
import gov.iti.models.dtos.CountryDto;
import gov.iti.models.dtos.CustomerDto;
import gov.iti.models.dtos.FilmActorDto;
import gov.iti.models.dtos.FilmCategoryDto;
import gov.iti.models.dtos.FilmDto;
import gov.iti.models.dtos.FilmTextDto;
import gov.iti.models.dtos.InventoryDto;
import gov.iti.models.dtos.LanguageDto;
import gov.iti.models.dtos.PaymentDto;
import gov.iti.models.dtos.RentalDto;
import gov.iti.models.dtos.SakilaDtos;
import gov.iti.models.dtos.StaffDto;
import gov.iti.models.dtos.StoreDto;

public class EntityFactory {

    public static <T extends SakilaDtos> Class<? extends SakilaEntities> createEntity(Class<T> dtoClass) {

        if (dtoClass == ActorDto.class)
            return Actor.class;

        if (dtoClass == AddressDto.class)
            return Address.class;

        if (dtoClass == CategoryDto.class)
            return Category.class;

        if (dtoClass == CityDto.class)
            return City.class;

        if (dtoClass == CountryDto.class)
            return Country.class;

        if (dtoClass == CustomerDto.class)
            return Customer.class;

        if (dtoClass == FilmDto.class)
            return Film.class;
        if (dtoClass == FilmActorDto.class)
            return FilmActor.class;

        if (dtoClass == FilmCategoryDto.class)
            return FilmCategory.class;

        if (dtoClass == FilmTextDto.class)
            return FilmText.class;

        if (dtoClass == InventoryDto.class)
            return Inventory.class;

        if (dtoClass == LanguageDto.class)
            return Language.class;

        if (dtoClass == PaymentDto.class)
            return Payment.class;

        if (dtoClass == RentalDto.class)
            return Rental.class;

        if (dtoClass == StaffDto.class)
            return Staff.class;

        if (dtoClass == StoreDto.class)
            return Store.class;
            
        return null;
    }
}