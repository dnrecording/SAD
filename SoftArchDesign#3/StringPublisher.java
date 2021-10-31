import static java.lang.Thread.currentThread;
import static java.util.concurrent.Executors.newSingleThreadExecutor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class StringPublisher implements Flow.Publisher{

    private static final String LOG_MESSAGE_FORMAT = "Publisher >> [%s] %s%n";

	final ExecutorService executor = Executors.newFixedThreadPool(4);
	private List subscriptions = Collections.synchronizedList(new ArrayList());

	private final CompletableFuture terminated = new CompletableFuture<>();

	@Override
	public void subscribe(Subscriber subscriber) {
		MySubscription subscription = new MySubscription(subscriber, executor);

		subscriptions.add(subscription);

		subscriber.onSubscribe(subscription);
	}

	public void waitUntilTerminated() throws InterruptedException {
		try {
			terminated.get();
		} catch (ExecutionException e) {
			System.out.println(e);
		}
	}
}
