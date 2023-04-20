package bg.softuni.crystal.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tables")
public class TableEntity extends BaseEntity{

    @NotNull
    private int capacity;

    public TableEntity() {
    }

    public int getCapacity() {
        return capacity;
    }

    public TableEntity setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }
}
