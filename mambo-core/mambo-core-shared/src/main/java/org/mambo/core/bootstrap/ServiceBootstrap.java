package org.mambo.core.bootstrap;

import com.google.common.collect.Sets;
import com.google.common.util.concurrent.Service;

import java.util.Comparator;
import java.util.Set;

import static com.google.common.base.Preconditions.checkState;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 17/11/12
 * Time: 18:31
 */
public class ServiceBootstrap {
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

    private final Set<Service> services = Sets.newTreeSet(SERVICE_COMPARATOR);

    public void register(Service service) {
        services.add(service);
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
