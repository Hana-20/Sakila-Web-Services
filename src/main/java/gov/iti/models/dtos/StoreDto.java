package gov.iti.models.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.core.Link;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import gov.iti.models.entities.Staff;

/**
 * A DTO for the {@link gov.iti.models.entities.Store} entity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class StoreDto implements Serializable , SakilaDtos {
    private  Integer id;
    
    private  StaffDto managerStaff;
    private  AddressDto address;
    private  Instant lastUpdate;
    
    private List<Link>links=new ArrayList<Link>();
}