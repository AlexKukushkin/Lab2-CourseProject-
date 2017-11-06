package db.repos;

import org.springframework.data.repository.CrudRepository;
import db.entities.PatientEntity;

public interface PatientRepo extends CrudRepository<PatientEntity, Long> {

}
