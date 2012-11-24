package org.mambo.core.bootstrap;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static com.google.common.base.Preconditions.checkState;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 17/11/12
 * Time: 18:31
 */
@Singleton
public class ServiceBootstrap {
    private static final Logger log = LoggerFactory.getLogger(ServiceBootstrap.class);

    public static final Comparator<Service> SERVICE_COMPARATOR = new Comparator<Service>() {
        public int compare(Service first, Service second) {
            int result = 0;
            ServicePriority annotation;

            if ((annotation = first.getClass().getAnnotation(ServicePriority.class)) != null) {
                result += annotation.value().value();
            }
            if ((annotation = second.getClass().getAnnotation(ServicePriority.class)) != null) {
                result -= annotation.value().value();
            }

            return result;
        }
    };

    private final List<Service> services;

    @Inject
    public ServiceBootstrap(Set<Service> services) {
        this.services = Lists.newArrayList(services);
        Collections.sort(this.services, SERVICE_COMPARATOR);
    }

    public void boot() {
        for (Service service : services) {
            checkState(service.startAndWait() != Service.State.FAILED);
        }
    }

    public void shutdown() {
        for (Service service : services) {
            checkState(service.startAndWait() != Service.State.FAILED);
        }
    }
}
