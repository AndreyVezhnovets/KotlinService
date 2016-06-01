package kotApp.config

import com.fasterxml.jackson.core.Version
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import kotApp.utils.LocalDateTimeDeserializer
import kotApp.utils.LocalDateTimeSerializer
import java.time.LocalDateTime


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = arrayOf("kotApp"))
open class WebConfig() : WebMvcConfigurerAdapter() {

    override fun configureMessageConverters(converters: MutableList<HttpMessageConverter<*>>?) {
        val simpleModule = SimpleModule("CustomSimpleModule", Version(1, 0, 0, "SNAPSHOT", "org.demo.server", null))
        simpleModule.addSerializer(LocalDateTime::class.java, LocalDateTimeSerializer());
        simpleModule.addDeserializer(LocalDateTime::class.java, LocalDateTimeDeserializer());

        val objectMapper = ObjectMapper()
        objectMapper.registerModule(JavaTimeModule())
        objectMapper.registerModule(simpleModule)

        val converter = MappingJackson2HttpMessageConverter()
        converter.objectMapper = objectMapper
        converter.supportedMediaTypes = listOf(MediaType.APPLICATION_JSON)

        converters?.add(converter)
    }
}