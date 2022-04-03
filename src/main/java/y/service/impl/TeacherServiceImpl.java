package y.service.impl;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import y.domain.Teacher;
import y.repository.TeacherRepository;
import y.service.TeacherService;

/**
 * Service Implementation for managing {@link Teacher}.
 */
@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

    private final Logger log = LoggerFactory.getLogger(TeacherServiceImpl.class);

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher save(Teacher teacher) {
        log.debug("Request to save Teacher : {}", teacher);
        return teacherRepository.save(teacher);
    }

    @Override
    public Optional<Teacher> partialUpdate(Teacher teacher) {
        log.debug("Request to partially update Teacher : {}", teacher);

        return teacherRepository
            .findById(teacher.getId())
            .map(existingTeacher -> {
                if (teacher.getFirstName() != null) {
                    existingTeacher.setFirstName(teacher.getFirstName());
                }
                if (teacher.getLastName() != null) {
                    existingTeacher.setLastName(teacher.getLastName());
                }
                if (teacher.getEmail() != null) {
                    existingTeacher.setEmail(teacher.getEmail());
                }
                if (teacher.getIdNumber() != null) {
                    existingTeacher.setIdNumber(teacher.getIdNumber());
                }

                return existingTeacher;
            })
            .map(teacherRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Teacher> findAll(Pageable pageable) {
        log.debug("Request to get all Teachers");
        return teacherRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Teacher> findOne(Long id) {
        log.debug("Request to get Teacher : {}", id);
        return teacherRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Teacher : {}", id);
        teacherRepository.deleteById(id);
    }
}
