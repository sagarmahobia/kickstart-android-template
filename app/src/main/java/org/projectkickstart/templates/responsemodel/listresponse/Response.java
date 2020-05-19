package org.projectkickstart.templates.responsemodel.listresponse;

import androidx.annotation.NonNull;

import static org.projectkickstart.templates.responsemodel.listresponse.Type.ERROR;
import static org.projectkickstart.templates.responsemodel.listresponse.Type.LOADING;
import static org.projectkickstart.templates.responsemodel.listresponse.Type.NEW_LIST;
import static org.projectkickstart.templates.responsemodel.listresponse.Type.UPDATE_LIST;


/**
 * Created by SAGAR MAHOBIA on 18-Jan-19. at 20:07
 */
public class Response<T> {

    private final Type type;

    private final T data;

    private final Throwable error;

    private Response(Type status, T data, Throwable error) {
        this.type = status;
        this.data = data;
        this.error = error;
    }

    public T getData() {
        return data;
    }

    @NonNull
    public Type getType() {
        return type;
    }

    public Throwable getError() {
        return error;
    }

    @NonNull
    public static <T> Response loading() {
        return new Response<T>(LOADING, null, null);
    }

    @NonNull
    public static <T> Response newList(@NonNull T data) {
        return new Response<>(NEW_LIST, data, null);
    }

    @NonNull
    public static <T> Response update(T data) {
        return new Response<>(UPDATE_LIST, data, null);
    }

    @NonNull
    public static Response error(@NonNull Throwable error) {
        return new Response<>(ERROR, null, error);
    }

}
