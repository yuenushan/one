package com.example.boot.graphql.publisher;

import com.example.boot.graphql.entity.Drug;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.observables.ConnectableObservable;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;

@Component
public class DrugPublisher {

    private final Flowable<Drug> publisher;
    private ObservableEmitter<Drug> emitter;

    public DrugPublisher() {
        Observable<Drug> drugUpdateObservable = Observable.create(emitter -> {
            this.emitter = emitter;
        });
        ConnectableObservable<Drug> connectableObservable = drugUpdateObservable.share().publish();
        connectableObservable.connect();
        publisher = connectableObservable.toFlowable(BackpressureStrategy.BUFFER);
    }

    public void publish(Drug drug) {
        emitter.onNext(drug);
    }

    public Publisher<Drug> getPublisher() {
        return publisher;
    }
}
