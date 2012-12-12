package org.mambo.core.io;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mambo.core.event.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * @author Blackrush
 *         Mambo
 */
public class EventBusTest {
    static class EventListener {
        long received, received2;

        @EventHandler
        public void onString(Event<String> event) {
            received = System.nanoTime();
        }

        @EventHandler(priority = EventHandler.Priority.GOD)
        public void onString2(String string) {
            received2 = System.nanoTime();
        }

        @EventHandler
        public void onString3(Event<String> event) {
            event.reply("Hello " + event.get() + "!");
        }
    }

    static class OtherEventListener {
        long received;

        @EventHandler
        public void onString(Event<String> event) {
            received = System.nanoTime();
        }
    }

    private EventBus eventBus;
    private EventListener listener;
    private OtherEventListener otherListener;

    @Before
    public void setUp() {
        eventBus = LightEventBus.create(new ReflectiveEventHandlerManager());
        listener = new EventListener();
        otherListener = new OtherEventListener();

        eventBus.register(listener);
        eventBus.register(otherListener);
    }

    @After
    public void tearDown() {
        eventBus.unregister(listener);
        eventBus.unregister(otherListener);
    }

    @Test
    public void dispatch() throws InterruptedException {
        eventBus.publish("Hello world!");

        assertThat(listener.received, not(0L));
        assertThat(listener.received2, not(0L));
        assertThat(otherListener.received, not(0L));
        assertTrue(listener.received2 < listener.received);
        assertTrue(listener.received2 < otherListener.received);
    }

    @Test
    public void reply() throws ExecutionException, InterruptedException, TimeoutException {
        Event<String> event = eventBus.publish("world");
        Object reply = event.getReplyFuture().get(1, TimeUnit.SECONDS);

        assertThat(reply, is((Object) "Hello world!"));
    }
}
