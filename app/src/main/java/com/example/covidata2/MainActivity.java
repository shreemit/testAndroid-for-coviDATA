package com.example.covidata2;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    EditText editT;
    Button btn;
    private int k=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editT=findViewById(R.id.editTT);
        btn=findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView btn2=new TextView(MainActivity.this);
                linearLayout=findViewById(R.id.linear_layout);

                LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                float bb=10;
                btn2.setText(("afasdfasd"));
                btn2.setId(k);
                //btn2.setTextColor(Color.rgb(0,77,255));
               // btn2.setTextSize(bb);

                linearLayout.addView(btn2,layoutParams);
            }
        });

    }

    public void btnCLick(View v)
    {
        for (int i=0;i<2;i++) {
            addTextViews();
            //addCheckBoxes();
            //addRadioButtons();
            //addEditTexts();
        }
    }
    private void addRadioButtons() {

        //RadioButtons are always added inside a RadioGroup
        RadioGroup radioGroup = new RadioGroup(this);
        radioGroup.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.addView(radioGroup);
        for (int i = 1; i <= 3; i++) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText("Option " + String.valueOf(i));
            radioGroup.addView(radioButton);
            setRadioButtonAttributes(radioButton);
        }
        addLineSeperator();
    }

    private void addTextViews() {
        //Adding a LinearLayout with HORIZONTAL orientation
        LinearLayout textLinearLayout = new LinearLayout(this);
        textLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.addView(textLinearLayout);
        TextView textView = new TextView(this);
        textView.setText("TextView ");
        setTextViewAttributes(textView);
        textLinearLayout.addView(textView);
        addLineSeperator();
    }


    private void addCheckBoxes() {

        LinearLayout checkBoxLayout = new LinearLayout(this);
        checkBoxLayout.setOrientation(LinearLayout.VERTICAL);

        linearLayout.addView(checkBoxLayout);

        for (int i = 1; i <= 3; i++) {
            CheckBox checkBox = new CheckBox(this);
            checkBox.setText("CheckBox " + String.valueOf(i));
            setCheckBoxAttributes(checkBox);
            checkBoxLayout.addView(checkBox);
        }
        addLineSeperator();
    }

    private void addEditTexts() {

        LinearLayout editTextLayout = new LinearLayout(this);
        editTextLayout.setOrientation(LinearLayout.VERTICAL);

        linearLayout.addView(editTextLayout);

        for (int i = 1; i <= 3; i++) {
            EditText editText = new EditText(this);
            editText.setHint("EditText " + String.valueOf(i));
            setEditTextAttributes(editText);
            editTextLayout.addView(editText);
        }
        addLineSeperator();
    }

    private void setEditTextAttributes(EditText editText) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        params.setMargins(convertDpToPixel(16),
                convertDpToPixel(16),
                convertDpToPixel(16),
                0
        );

        editText.setLayoutParams(params);
    }

    private void setCheckBoxAttributes(CheckBox checkBox) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        params.setMargins(convertDpToPixel(16),
                convertDpToPixel(16),
                convertDpToPixel(16),
                0
        );

        checkBox.setLayoutParams(params);

        //This is used to place the checkbox on the right side of the textview
        //By default, the checkbox is placed at the left side
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(android.R.attr.listChoiceIndicatorMultiple,
                typedValue, true);

        checkBox.setButtonDrawable(null);
        checkBox.setCompoundDrawablesWithIntrinsicBounds(0, 0,
                typedValue.resourceId, 0);
    }

    private void setTextViewAttributes(TextView textView) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        params.setMargins(convertDpToPixel(16),
                convertDpToPixel(16),
                0, 0
        );

        textView.setTextColor(Color.BLACK);
        textView.setLayoutParams(params);
    }

    private void setRadioButtonAttributes(RadioButton radioButton) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        params.setMargins(convertDpToPixel(16),
                convertDpToPixel(16),
                0, 0
        );

        radioButton.setLayoutParams(params);
    }

    //This function to convert DPs to pixels
    private int convertDpToPixel(float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return Math.round(px);
    }

    private void addLineSeperator() {
        LinearLayout lineLayout = new LinearLayout(this);
        lineLayout.setBackgroundColor(Color.GRAY);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                2);
        params.setMargins(0, convertDpToPixel(10), 0, convertDpToPixel(10));
        lineLayout.setLayoutParams(params);
        linearLayout.addView(lineLayout);
    }


}