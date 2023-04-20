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
@Table(name = "rental")
public class Rental implements SakilaEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "rental_date", nullable = false)
    private Instant rentalDate;

   
    @Column(name = "inventory_id", nullable = false)
    private Integer inventoryId;

   
    @Column(name = "customer_id", nullable = false)
    private Integer customerId;

    @Column(name = "return_date")
    private Instant returnDate;

    
    @Column(name = "staff_id", nullable = false)
    private Integer staffId;

    @NotNull
    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

}