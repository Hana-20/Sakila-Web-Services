package gov.iti.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class Customer implements SakilaEntities {
    @Id
    @Column(name = "customer_id", columnDefinition = "SMALLINT UNSIGNED not null")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @Size(max = 45)
    @NotNull
    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Size(max = 45)
    @NotNull
    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @Size(max = 50)
    @Column(name = "email", length = 50)
    private String email;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @NotNull
    @Column(name = "active", nullable = false)
    private Boolean active = false;

    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;


  @OneToMany(cascade = CascadeType.ALL, mappedBy = "id", fetch = FetchType.EAGER)
    private Set<Rental> rentalSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id", fetch = FetchType.EAGER)
    private Set<Payment> paymentSet;



    

}

// package gov.iti.models.entities;

// import jakarta.persistence.*;
// import jakarta.validation.constraints.NotNull;
// import jakarta.validation.constraints.Size;
// import lombok.AllArgsConstructor;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;

// import java.sql.Date;
// import java.time.Instant;
// import java.util.Set;

// @Getter
// @Setter
// @Entity
// @NoArgsConstructor
// @AllArgsConstructor
// @Table(name = "customer")
// public class Customer implements SakilaEntities {
//     @Id
//     @Column(name = "customer_id", columnDefinition = "SMALLINT UNSIGNED not null")
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Integer id;

//     @NotNull
//     @ManyToOne(fetch = FetchType.LAZY, optional = false)
//     @JoinColumn(name = "store_id", nullable = false)
//     private Store store;

//     @Size(max = 45)
//     @NotNull
//     @Column(name = "first_name", nullable = false, length = 45)
//     private String firstName;

//     @Size(max = 45)
//     @NotNull
//     @Column(name = "last_name", nullable = false, length = 45)
//     private String lastName;

//     @Size(max = 50)
//     @Column(name = "email", length = 50)
//     private String email;

//     @NotNull
//     @ManyToOne(fetch = FetchType.EAGER, optional = false)
//     @JoinColumn(name = "address_id", nullable = false)
//     private Address address;

//     @NotNull
//     @Column(name = "active", nullable = false)
//     private Boolean active = false;

//     @Column(name = "create_date")
//     @Temporal(TemporalType.TIMESTAMP)
//     private Date createDate;
//     @Column(name = "last_update")
//     @Temporal(TemporalType.TIMESTAMP)
//     private Date lastUpdate;
//     // @OneToMany(cascade = CascadeType.ALL, mappedBy = "id", fetch = FetchType.LAZY)
//     // private Set<Rental> rentalSet;
//     // @OneToMany(cascade = CascadeType.ALL, mappedBy = "id", fetch = FetchType.LAZY)
//     // private Set<Payment> paymentSet;
    

// }