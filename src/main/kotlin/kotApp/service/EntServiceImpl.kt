package kotApp.service

import kotApp.entity.Ent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotApp.repository.CrudRepository


@Service
class EntServiceImpl @Autowired constructor(
        val repository: CrudRepository) : EntService {

    override fun getAll(): List<Ent> {
        return repository.findAll()
    }

    override fun getById(id: Long): Ent {
        return repository.findOne(id)
    }

    override fun save(remind: Ent): Ent {
        return repository.saveAndFlush(remind)
    }

    override fun remove(id: Long) {
        repository.delete(id)
    }
}