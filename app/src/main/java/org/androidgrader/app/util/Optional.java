package org.androidgrader.app.util;


public final class Optional<T> {

    private final T       value;
    private final boolean present;

    private Optional() {
        value   = null;
        present = false;
    }

    private Optional(T value) {

        if(value != null) {
            this.value = value;
            present    = true;
        } else {
            this.value   = null;
            this.present = false;
        }
    }

    static <T> Optional<T> empty() {
        return new Optional<T>();
    }


    public T get(){
        if(!isPresent())
            throw new IllegalStateException("Get called on empty Optional");

        return value;
    }


    public boolean isPresent(){
        return present;
    }

    public static <T> Optional<T> of(T value){
        return new Optional(value);
    }
}
