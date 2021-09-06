package training360.guinessapp;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;
import training360.guinessapp.dto.RecorderCreateCommand;
import training360.guinessapp.dto.RecorderDto;
import training360.guinessapp.dto.RecorderShortDto;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class RecorderController {

    private RecorderService recorderService;




    @PostMapping("/recorders")
    @ResponseStatus(HttpStatus.CREATED)
    public RecorderDto createRecorder(@RequestBody @Valid RecorderCreateCommand command) {
        return recorderService.createRecorder(command);
    }


    @GetMapping("/recorder")
    public List<RecorderShortDto> listRecordersByConditions() {
        return recorderService.listRecordersByConditions();
    }




    }
