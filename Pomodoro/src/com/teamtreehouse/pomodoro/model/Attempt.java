package com.teamtreehouse.pomodoro.model;

/**
 * Created by ginolee on 12/19/16.
 */
public class Attempt {
    private String mMessage;
    private int mRemainingSeconds;
    private AttemptKind mKind;

    public Attempt(String mMessage, int mRemainingSeconds) {
        this.mMessage = mMessage;
        this.mRemainingSeconds = mRemainingSeconds;
        this.mRemainingSeconds = mKind.getmTotalSeconds();
    }

    public String getmMessage() {
        return mMessage;
    }

    public int getmRemainingSeconds() {
        return mRemainingSeconds;
    }

    public AttemptKind getmKind() {
        return mKind;
    }

    public void setmMessage(String mMessage) {
        this.mMessage = mMessage;
    }
}
