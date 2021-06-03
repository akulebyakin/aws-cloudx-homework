package pro.kulebyakin.awscloudxhomework.core.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import pro.kulebyakin.awscloudxhomework.core.exceptions.NotFoundException;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public abstract class CrudService<T> {

    public List<T> getAll() {
        JpaRepository<T, Long> repository = getRepository();
        return repository.findAll();
    }

    public T get(Long entityId) {
        JpaRepository<T, Long> repository = getRepository();
        Optional<T> optional = repository.findById(entityId);
        return optional.orElseThrow(() -> new NotFoundException(entityId));
    }

    public T save(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity is null");
        }
        JpaRepository<T, Long> repository = getRepository();
        return repository.save(entity);
    }

    public abstract JpaRepository<T, Long> getRepository();

}
