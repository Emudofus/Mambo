package org.mambo.core.concurrent;

/**
 * @author Blackrush
 *         Mambo
 */
public abstract class Worker {
    private boolean started;

    private final Thread thread = new Thread() {
        public void run() {
            try {
                Worker.this.run();
            } catch (Throwable t) {
                tearDown();
                throw new RuntimeException(t);
            }
        }
    };

    protected abstract void run();
    protected abstract void triggerShutdown();
    protected abstract void setUp();
    protected abstract void tearDown();

    public final void start() {
        if (started) return;
        started = true;

        setUp();
        thread.start();
    }

    public final void shutdown() {
        if (!started) return;
        started = false;

        triggerShutdown();
        tearDown();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException("can't shutdown worker", e);
        }
    }
}
