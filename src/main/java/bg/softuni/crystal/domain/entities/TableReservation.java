package bg.softuni.crystal.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "table_reservations")
public class TableReservation extends BaseEntity{

    @NotNull
    private LocalDate reservationDate;

    private LocalTime reservationTime;

    @NotNull
    @Min(1)
    private Integer guestCount;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "table_id", referencedColumnName = "id")
    private TableEntity table;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;


    public TableReservation() {
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public TableReservation setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
        return this;
    }

    public LocalTime getReservationTime() {
        return reservationTime;
    }

    public TableReservation setReservationTime(LocalTime reservationTime) {
        this.reservationTime = reservationTime;
        return this;
    }

    public Integer getGuestCount() {
        return guestCount;
    }

    public TableReservation setGuestCount(Integer guestCount) {
        this.guestCount = guestCount;
        return this;
    }

    public TableEntity getTable() {
        return table;
    }

    public TableReservation setTable(TableEntity table) {
        this.table = table;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public TableReservation setUser(UserEntity user) {
        this.user = user;
        return this;
    }
}
