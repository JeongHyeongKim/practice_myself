package project.gsitm.geoquiz;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "QuizActivity";
    private static final String KEY_INDEX = "index";

    private Button mTureButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mPrevButton;
    private Button mCheatButton;
    private TextView mQuestionTextView;



    private TrueFalse[] mQuestionBank = new TrueFalse[] {
            new TrueFalse(R.string.question_oceans, true, false),
            new TrueFalse(R.string.question_mideast, false, false),
            new TrueFalse(R.string.question_africa, false,false),
            new TrueFalse(R.string.question_americas, true, false),
            new TrueFalse(R.string.question_asia, true, false),
    };
    //private boolean[] cheatHistory = new boolean []{false,false,false,false,false};

    private int mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null)
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);

        Log.d(TAG, "onCreate(Bundle) called");
        setContentView(R.layout.quizactivity);

        mQuestionTextView = findViewById(R.id.textarea);
        updateQuestion();

        mTureButton = findViewById(R.id.trueButton);
        mTureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        mFalseButton = findViewById(R.id.falseButton);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        mPrevButton = findViewById(R.id.prevButton);
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = mCurrentIndex==0 ? mQuestionBank.length-1 : (mCurrentIndex - 1);
                updateQuestion();
            }
        });

        mNextButton = findViewById(R.id.nextButton);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*                mCurrentIndex++;
                if (mCurrentIndex >= mQuestionBank.length) {
                    mCurrentIndex = 0;
                }*/

                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();

            }
        });

        mCheatButton = findViewById(R.id.cheatButton);
        mCheatButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, CheatActivity.class);
                boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();
                 intent.putExtra(CheatActivity.EXTRA_ANSWER_IS_TRUE,answerIsTrue);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getQuestion();
        mQuestionTextView.setText(question);


    }

    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();
        int messageResId = 0;
        if(mQuestionBank[mCurrentIndex].getCheat()){ // 치팅 했을때!
            messageResId = R.string.judgement_toast;
            mQuestionBank[mCurrentIndex].setCheat(true);
        }else { // 치팅 안했을때지만, 날라갈 수도 있음! 이를 확인해야한다.
            if (userPressedTrue == answerIsTrue)
                    messageResId = R.string.correct_toast;
                else
                    messageResId = R.string.incorrect_toast;

        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
                .show();
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data==null)
            return;
        mQuestionBank[mCurrentIndex].setCheat(data.getBooleanExtra(CheatActivity.EXTRA_ANSWER_SHOWN,false));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        checkOrientation(newConfig);
    }

    private void checkOrientation(Configuration newConfig){
        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) { // 가로
            mQuestionBank[mCurrentIndex].setCheat(false);

        }
    }


}
