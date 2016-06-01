package kotApp.service

import kotApp.entity.Ent


interface EntService {
    fun getAll(): List<Ent>
    fun getById(id: Long): Ent
    fun save(remind: Ent): Ent
    fun remove(id: Long)
}