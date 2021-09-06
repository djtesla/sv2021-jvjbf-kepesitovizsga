package training360.guinessapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecorderRepository extends JpaRepository<Recorder, Long> {


    @Query("select r.name, r.dateOfBirth from Recorder r where r.name or r.name like '%e%' order by r.dateOfBirth asc")
    List<Object[]> listRecordersByConditions();
}
