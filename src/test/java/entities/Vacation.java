package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="vacations")
@Data
public class Vacation {
    private Long id;
    private String vacation_title;
    private String description;
    private BigDecimal travel_price;
    private String image_URL;
    private Date create_date;
    private Date last_update;
    private Set<Excursion> excurions;
}
