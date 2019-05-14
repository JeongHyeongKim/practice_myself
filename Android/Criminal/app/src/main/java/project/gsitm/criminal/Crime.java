package project.gsitm.criminal;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;

public class Crime {
    private UUID mId;
    private String mTitle;
    private String mDate;
    private boolean mSolved;

    public Crime(){
        mId=UUID.randomUUID();


        SimpleDateFormat formatClock = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        formatClock.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
        String new_date = formatClock.format(new Date(System.currentTimeMillis()));

        mDate = new_date;

    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID mId) {
        this.mId = mId;
    }


    public String getDate() {
        return mDate;
    }

    public void setDate(String mDate) {
        this.mDate = mDate;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }

    public String toString() {
        return mTitle;
    }

}
