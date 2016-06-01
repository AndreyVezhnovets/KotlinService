package kotApp.repository


import kotApp.entity.Ent
import org.springframework.data.jpa.repository.JpaRepository


interface CrudRepository : JpaRepository<Ent, Long> {
}