package kotApp

import kotApp.config.WebConfig
import org.springframework.web.WebApplicationInitializer
import org.springframework.web.context.ContextLoaderListener
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet
import javax.servlet.ServletContext
import javax.servlet.ServletRegistration

open class ApplicationInitializer : WebApplicationInitializer {

    companion object {
        val DISPATCHER: String = "ApplicationServerDispatcher"
    }

    override fun onStartup(servletContext: ServletContext?) {
        val ctx = AnnotationConfigWebApplicationContext()
        ctx.register(WebConfig::class.java)
        servletContext?.addListener(ContextLoaderListener(ctx))
        val servlet = servletContext?.addServlet(DISPATCHER, DispatcherServlet(ctx)) as ServletRegistration.Dynamic
        servlet.addMapping("/")
        servlet.setLoadOnStartup(1)
    }

}