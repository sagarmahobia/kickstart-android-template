package org.projectkickstart.templates;

import androidx.annotation.NonNull;

import static org.projectkickstart.templates.Status.ERROR;
import static org.projectkickstart.templates.Status.LOADING;
import static org.projectkickstart.templates.Status.SUCCESS;

/**
 * Response holder provided to the UI
 */
public class Response<T> {

    private final Status status;

    private final T data;

    private final Throwable error;

    private Response(Status status, T data, Throwable error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    @NonNull
    public static <T> Response loading() {
        return new Response<T>(LOADING, null, null);
    }

    @NonNull
    public static <T> Response success(@NonNull T data) {
        return new Response<T>(SUCCESS, data, null);
    }

    @NonNull
    public static <T> Response error(@NonNull Throwable error) {
        return new Response<T>(ERROR, null, error);
    }

    public T getData() {
        return data;
    }

    @NonNull
    public Status getStatus() {
        return status;
    }

    public Throwable getError() {
        return error;
    }

}
