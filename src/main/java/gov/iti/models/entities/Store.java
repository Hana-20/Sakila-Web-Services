package gov.iti.models.entities;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id", columnDefinition = "TINYINT UNSIGNED not null")
    private Short id;

    @OneToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "manager_staff_id", nullable = true)
    private Staff managerStaff;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "address_id", nullable = true)
    private Address address;

    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

}