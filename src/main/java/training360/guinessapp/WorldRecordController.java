package training360.guinessapp;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;
import training360.guinessapp.dto.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping("/api/worldrecords")
public class WorldRecordController {

    private WorldRecordService worldRecordService;




    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WorldRecordDto createWorldRecord(@RequestBody @Valid WorldRecordCreateCommand command) {
        return worldRecordService.createWorldRecord(command);
    }


    @PutMapping("/{id}/beatrecords")
    public BeatWorldRecordDto recorderBeatsWorldRecord(@PathVariable("id") long id,  @Valid BeatWorldRecordCommand command) {
        return worldRecordService.recorderBeatsWorldRecord(command);
    }



    @ExceptionHandler(RecorderNotFoundException.class)
    public ResponseEntity<Problem> handleRecorderNotFound(RecorderNotFoundException rnfe) {
        Problem problem = Problem.builder()
                .withType(URI.create("recorder/not-found"))
                .withStatus(Status.NOT_FOUND)
                .withTitle("Recorder not found")
                .withDetail(rnfe.getMessage())
                .build();
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(problem);
    }


    @ExceptionHandler(WorldRecordNotFoundException.class)
    public ResponseEntity<Problem> handleRecorderNotFound(WorldRecordNotFoundException wrnfe) {
        Problem problem = Problem.builder()
                .withType(URI.create("recor/not-found"))
                .withStatus(Status.NOT_FOUND)
                .withTitle("Recorder not found")
                .withDetail(wrnfe.getMessage())
                .build();
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(problem);
    }

}
