package gov.iti.models.mappers;

import gov.iti.models.dtos.*;
import org.modelmapper.ModelMapper;

public class MapperFactory {
    public static <T extends SakilaDtos> SakilaMapper createMapper(Class<T> dtoClass) {
        if (dtoClass == ActorDto.class)
            return new ActorMapper(new ModelMapper());
        if (dtoClass == AddressDto.class)
            return new AddressMapper(new ModelMapper());

        if (dtoClass == CategoryDto.class)
            return new CategoryMapper(new ModelMapper());

        if (dtoClass == CityDto.class)
            return new CityMapper(new ModelMapper());

        if (dtoClass == CountryDto.class)
            return new CategoryMapper(new ModelMapper());

        if (dtoClass == CustomerDto.class)
            return new CustomerMapper(new ModelMapper());

        if (dtoClass == FilmDto.class)
            return new FilmMapper(new ModelMapper());
        if (dtoClass == FilmActorDto.class)
            return new FilmActorMapper(new ModelMapper());

        if (dtoClass == FilmCategoryDto.class)
            return new FilmCategoryMapper(new ModelMapper());

        if (dtoClass == FilmTextDto.class)
            return new FilmTextMapper(new ModelMapper());

        if (dtoClass == InventoryDto.class)
            return new InventoryMapper(new ModelMapper());

        if (dtoClass == LanguageDto.class)
            return new LanguageMapper(new ModelMapper());

        if (dtoClass == PaymentDto.class)
            return new PaymentMapper(new ModelMapper());

        if (dtoClass == RentalDto.class)
            return new RentalMapper(new ModelMapper());

        if (dtoClass == StaffDto.class)
            return new StaffMapper(new ModelMapper());

        if (dtoClass == StoreDto.class)
            return new StoreMapper(new ModelMapper());

        return null;
    }
}
