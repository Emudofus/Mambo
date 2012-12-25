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
            } finally {
                tearDown();
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
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException("can't shutdown worker", e);
        }
    }
}
