package edumaps.app.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import javax.ws.rs.Path;
import javax.ws.rs.ext.Provider;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(Provider.class));
        scanner.addIncludeFilter(new AnnotationTypeFilter(Path.class));
        Set<BeanDefinition> restBeans = scanner.findCandidateComponents("edumaps.app.resource");

        registerClasses(restBeans.stream()
                .map(beanDefinition -> ClassUtils
                        .resolveClassName(beanDefinition.getBeanClassName(), this.getClassLoader()))
                .collect(Collectors.toSet()));
    }
}