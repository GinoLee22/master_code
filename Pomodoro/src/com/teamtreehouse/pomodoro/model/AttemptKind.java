package com.teamtreehouse.pomodoro.model;

/**
 * Created by ginolee on 12/19/16.
 */
public enum AttemptKind {
    FOCUS(25 * 60),
    BREAK(5 * 60);


    private int mTotalSeconds;

    AttemptKind(int mTotalSeconds) {
        this.mTotalSeconds = mTotalSeconds;
    }

    public int getmTotalSeconds() {
        return mTotalSeconds;
    }
}
