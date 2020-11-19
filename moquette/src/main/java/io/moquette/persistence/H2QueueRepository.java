package io.moquette.persistence;

import org.h2.mvstore.MVStore;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import io.moquette.broker.IQueueRepository;
import io.moquette.broker.SessionRegistry;

public class H2QueueRepository implements IQueueRepository {

    private MVStore mvStore;

    public H2QueueRepository(MVStore mvStore) {
        this.mvStore = mvStore;
    }

    @Override
    public Queue<SessionRegistry.EnqueuedMessage> createQueue(String cli, boolean clean) {
        if (!clean) {
            return new H2PersistentQueue<>(mvStore, cli);
        }
        return new ConcurrentLinkedQueue<>();
    }
}
