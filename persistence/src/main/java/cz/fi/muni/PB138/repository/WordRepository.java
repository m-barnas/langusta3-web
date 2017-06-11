package cz.fi.muni.PB138.repository;

import cz.fi.muni.PB138.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Martin on 10.6.2017.
 *
 * @author Martin Barnas 433523
 */
public interface WordRepository extends JpaRepository<Word, Long>, JpaSpecificationExecutor {
}
