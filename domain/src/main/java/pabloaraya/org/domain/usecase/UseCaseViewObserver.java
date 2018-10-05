package pabloaraya.org.domain.usecase;

import io.reactivex.observers.DisposableObserver;

public abstract class UseCaseViewObserver<V, T> extends DisposableObserver<T> {

    private V view;

    public void attachView(V view) {
        this.view = view;
    }

    protected V getView() {
        return view;
    }

    @Override public void onComplete() {
    }

    @Override public void onError(Throwable e) {

    }

    @Override public void onNext(T t) {

    }
}