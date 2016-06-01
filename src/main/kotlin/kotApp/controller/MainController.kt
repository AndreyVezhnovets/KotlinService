package kotApp.controller

import kotApp.entity.Ent

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import kotApp.service.EntService


@RestController
open class MainController @Autowired constructor(val service: EntService) {

    @RequestMapping(value = "/2", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun getAllReminders(): List<Ent> {
        return service.getAll()
    }

    @RequestMapping(value = "/1{id}", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun getReminder(@PathVariable("id") remindId: Long): Ent {
        print(service.getById(remindId).title)
        return service.getById(remindId)
    }

    @RequestMapping(method = arrayOf(RequestMethod.POST))
    fun saveReminder(@RequestBody remind: Ent): Ent {
        return service.save(remind)
    }

    @RequestMapping(value = "/{id}", method = arrayOf(RequestMethod.DELETE))
    fun delete(@PathVariable id: Long) {
        service.remove(id)
    }
}