package training360.guinessapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeatWorldRecordCommand {

    private Long recorderId;

    @NotNull
    private Long worldRecordId;
    @NotNull
    private double newValue;


}
