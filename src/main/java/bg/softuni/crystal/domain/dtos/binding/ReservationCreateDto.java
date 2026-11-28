package bg.softuni.crystal.domain.dtos.binding;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationCreateDto {

    @NotNull
    @FutureOrPresent
    private LocalDate reservationDate;

    @NotNull
    private LocalTime reservationTime;

    @NotNull
    @Min(1)
    private Integer guestCount;

    @NotNull
    @Positive
    private Long tableId;


    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public ReservationCreateDto setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
        return this;
    }

    public LocalTime getReservationTime() {
        return reservationTime;
    }

    public ReservationCreateDto setReservationTime(LocalTime reservationTime) {
        this.reservationTime = reservationTime;
        return this;
    }

    public Integer getGuestCount() {
        return guestCount;
    }

    public ReservationCreateDto setGuestCount(Integer guestCount) {
        this.guestCount = guestCount;
        return this;
    }

    public Long getTableId() {
        return tableId;
    }

    public ReservationCreateDto setTableId(Long tableId) {
        this.tableId = tableId;
        return this;
    }
}
