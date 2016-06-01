package kotApp.utils

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

open class LocalDateTimeSerializer : JsonSerializer<LocalDateTime>() {
    override fun serialize(p0: LocalDateTime?, p1: JsonGenerator?, p2: SerializerProvider?) {
        val outDate = Date.from(p0?.atZone(ZoneId.systemDefault())?.toInstant());
        p1?.writeNumber(outDate.time)
    };
}