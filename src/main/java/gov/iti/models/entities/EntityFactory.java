package gov.iti.models.entities;

import gov.iti.models.dtos.*;

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