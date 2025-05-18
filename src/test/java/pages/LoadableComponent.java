package pages;

public abstract class LoadableComponent<T extends LoadableComponent<T>> {
    protected abstract void isLoaded() throws Error;
}