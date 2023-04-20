package bg.softuni.crystal.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "table_reservations")
public class TableReservation extends BaseEntity{

    @NotNull
    private LocalDate reservationDate;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "table_id", referencedColumnName = "id")
    private TableEntity table;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;


    public TableReservation() {
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public TableReservation setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
        return this;
    }

    public TableEntity getTable() {
        return table;
    }

    public TableReservation setTable(TableEntity table) {
        this.table = table;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public TableReservation setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }
}
