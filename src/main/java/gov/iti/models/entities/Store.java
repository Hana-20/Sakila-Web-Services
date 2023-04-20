package gov.iti.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "store")
public class Store implements SakilaEntities {
    @Id
    @Column(name = "store_id", columnDefinition = "TINYINT UNSIGNED not null")
    private Short id;

    @NotNull
    @Column(name = "manager_staff_id", nullable = false)
    @JoinColumn(name = "staff_id", referencedColumnName = "staff_id")
    private Integer managerStaffId;

    @NotNull
    @Column(name = "address_id", nullable = false)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Integer addressId;

    @NotNull
    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;
}