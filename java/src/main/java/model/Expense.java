package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_expenses")
public class Expense {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String expense;
    private String description;
    private BigDecimal amount;

}
