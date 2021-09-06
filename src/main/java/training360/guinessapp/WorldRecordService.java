package training360.guinessapp;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import training360.guinessapp.dto.*;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class WorldRecordService {

    private WorldRecordRepository worldRecordRepository;
    private RecorderRepository recorderRepository;
    private ModelMapper modelMapper;

    @Transactional
    public WorldRecordDto createWorldRecord(WorldRecordCreateCommand command) {
        long recorderId = command.getRecorderId();
        Recorder recorder = recorderRepository.findById(recorderId).orElseThrow(() -> new RecorderNotFoundException("Recorder cannot be found by id " + recorderId));
        WorldRecord worldRecord = new WorldRecord(command.getDescription(), command.getValue(), command.getUnitOfMeasure(), command.getDateOfRecord(),recorderId, recorder.getName());
            worldRecordRepository.save(worldRecord);
            return modelMapper.map(worldRecord, WorldRecordDto.class);
        }


    @Transactional
        public BeatWorldRecordDto recorderBeatsWorldRecord(BeatWorldRecordCommand command) {
        long oldRecorderId = command.getRecorderId();
        long worldRecordId = command.getWorldRecordId();
        Recorder oldRecorder = recorderRepository.findById(oldRecorderId).orElseThrow(() -> new RecorderNotFoundException("Recorder cannot be found by id " + oldRecorderId));
        Recorder newRecorder = recorderRepository.findById(command.getRecorderId()).orElseThrow(() -> new RecorderNotFoundException("Recorder cannot be found by id " + command.getRecorderId()));
        WorldRecord oldWorldRecord  = worldRecordRepository.findById(worldRecordId).orElseThrow(() -> new WorldRecordNotFoundException("World record cannot be found by id " + worldRecordId));
        double recordDifference = command.getNewValue() - oldWorldRecord.getValue();
        return new BeatWorldRecordDto(oldWorldRecord.getDescription(), oldWorldRecord.getUnitOfMeasure(), oldRecorder.getName(), newRecorder.getName(), command.getNewValue(),recordDifference);
    }
}

