package org.projectkickstart.templates;

/**
 * Generated using Android KickStart Template.
 * visit https://github.com/sagarmahobia/kickstart-android-template to learn more.
 */

public class PagingState {
    public static int Loading = 1;
    public static int Success = 2;
    public static int Error = 3;

    private int state;
    private Throwable exception;

    private PagingState(int state) {
        this.state = state;
    }

    public static PagingState error(Throwable exception) {
        PagingState pagingState = new PagingState(Error);
        pagingState.exception = exception;
        return pagingState;
    }

    public static PagingState success() {
        return new PagingState(Success);
    }

    public static PagingState loading() {
        return new PagingState(Loading);
    }

    public int getState() {
        return state;
    }


    public Throwable getError() {
        return exception;
    }
}
