package project.gsitm.geoquiz;

public class TrueFalse {
    private int mQuestion;
    private boolean mTrueQuestion;
    private boolean mHisCheat;


    public TrueFalse(int Question, boolean trueQuestion, boolean mHisCheat){
        mQuestion = Question;
        mTrueQuestion = trueQuestion;
        this.mHisCheat = mHisCheat;
    }
    public int getQuestion(){
        return mQuestion;
    }

    public void setQuestion(int question) {
        mQuestion = question;
    }

    public boolean isTrueQuestion() {
        return mTrueQuestion;
    }

    public void setTrueQuestion(boolean trueQuestion) {
        mTrueQuestion = trueQuestion;
    }

    public boolean  getCheat(){
        return this.mHisCheat;
    }

    public void setCheat(boolean mHisCheat){
        this.mHisCheat = mHisCheat;
    }
}
