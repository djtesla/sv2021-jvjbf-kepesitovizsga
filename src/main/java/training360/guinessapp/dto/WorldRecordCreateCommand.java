package training360.guinessapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorldRecordCreateCommand {

    @NotNull
    @NotBlank(message = "must not be blank")
    @NotEmpty
    private String description;
    @NotNull
    private double value;
    @NotNull
    @NotBlank
    @NotEmpty
    private String unitOfMeasure;
    @NotNull
    private LocalDate dateOfRecord;
    @NotNull
    private Long recorderId;
}
