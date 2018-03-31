package pl.mar_lew.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int SCORE = 0;
    private final int MAX_POINTS = 7;
    private final String ANSWER_2_RIGHT = "main";
    private final String ANSWER_6_RIGHT = "2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    }

    private void getScoreQuestion1() {
        if (!((CheckBox) findViewById(R.id.answer_1a)).isChecked()
                && ((CheckBox) findViewById(R.id.answer_1b)).isChecked()
                && !((CheckBox) findViewById(R.id.answer_1c)).isChecked()
                && ((CheckBox) findViewById(R.id.answer_1d)).isChecked()
                ) SCORE=SCORE+1;
    }

    private void getScoreQuestion2() {
        if (((EditText) findViewById(R.id.answer_2a)).getText().toString().equals(ANSWER_2_RIGHT)) SCORE=SCORE+1;
    }

    private void getScoreQuestion3() {
        if (!((CheckBox) findViewById(R.id.answer_3a)).isChecked()
                && ((CheckBox) findViewById(R.id.answer_3b)).isChecked()
                && !((CheckBox) findViewById(R.id.answer_3c)).isChecked()
                && ((CheckBox) findViewById(R.id.answer_3d)).isChecked()) SCORE=SCORE+1;
    }


    private void getScoreQuestion4() {
        if (((CheckBox) findViewById(R.id.answer_4a)).isChecked()
                && !((CheckBox) findViewById(R.id.answer_4b)).isChecked()
                && !((CheckBox) findViewById(R.id.answer_4c)).isChecked()
                && ((CheckBox) findViewById(R.id.answer_4d)).isChecked()) SCORE=SCORE+1;
    }

    private void getScoreQuestion5() {
        RadioGroup Question5RadioGroup = (RadioGroup) findViewById(R.id.answer_5_RadioGroup);

        if (Question5RadioGroup.getCheckedRadioButtonId() != -1 && ((RadioButton) findViewById((Question5RadioGroup)
                .getCheckedRadioButtonId())).getText().equals(getResources().getString(R.string.answer_5c))) SCORE=SCORE+1;
    }

    private void getScoreQuestion6() {
        if (((EditText) findViewById(R.id.answer_6a)).getText().toString().equals(ANSWER_6_RIGHT)) SCORE=SCORE+1;
    }

    private void getScoreQuestion7() {
        RadioGroup Question7RadioGroup = (RadioGroup) findViewById(R.id.answer_7_RadioGroup);

        if (Question7RadioGroup.getCheckedRadioButtonId() != -1 && ((RadioButton) findViewById((Question7RadioGroup)
                .getCheckedRadioButtonId())).getText().equals(getResources().getString(R.string.answer_7c))) SCORE=SCORE+1;
    }

    public void finish(View v) {
        getScoreQuestion1();
        getScoreQuestion2();
        getScoreQuestion3();
        getScoreQuestion4();
        getScoreQuestion5();
        getScoreQuestion6();
        getScoreQuestion7();
        String ScoreText = "";
        if (SCORE<=2) ScoreText = "You scored: " + SCORE + "/" + MAX_POINTS + "\n" + "No good";
        if (SCORE>2 && SCORE<5) ScoreText = "You scored: " + SCORE + "/" + MAX_POINTS + "\n" + "Very good";
        if (SCORE>=5) ScoreText = "You scored: " + SCORE + "/" + MAX_POINTS + "\n" + "You are the best";
        Toast.makeText(getApplicationContext(), ScoreText, Toast.LENGTH_LONG).show();
        SCORE=0;
    }
}
