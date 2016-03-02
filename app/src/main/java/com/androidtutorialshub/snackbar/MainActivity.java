package com.androidtutorialshub.snackbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CoordinatorLayout coordinatorLayout;

    // Button variables
    private Button buttonSimpleSnackbar;
    private Button buttonCustomSnackbar;
    private Button buttonMultiColorSnackbar;
    private Button buttonActionCallbackSnackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initViews();
        initListeners();

    }

    /**
     * method to initialize views objects
     */
    private void initViews() {
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        buttonSimpleSnackbar = (Button) findViewById(R.id.buttonSimpleSnackbar);
        buttonCustomSnackbar = (Button) findViewById(R.id.buttonCustomSnackbar);
        buttonMultiColorSnackbar = (Button) findViewById(R.id.buttonMultiColorSnackbar);
        buttonActionCallbackSnackbar = (Button) findViewById(R.id.buttonActionCallbackSnackbar);

    }

    /**
     * method to initialize listeners
     */
    private void initListeners() {

        buttonSimpleSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Android Tutorials Hub Welcomes You", Snackbar.LENGTH_LONG);

                snackbar.show();
            }
        });

        buttonCustomSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Server Not Responding!", Snackbar.LENGTH_LONG)
                        .setAction("TRY AGAIN", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                            }
                        });

                // Message text color
                snackbar.setActionTextColor(Color.WHITE);

                // Action button text color
                View snackBarView = snackbar.getView();
                TextView textView = (TextView) snackBarView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.RED);

                snackbar.show();
            }
        });

        buttonMultiColorSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Creating MultiColor Text
                SpannableStringBuilder snackbarText = new SpannableStringBuilder();
                snackbarText.append("Welcome to ");
                int boldStart = snackbarText.length();
                snackbarText.append("Android Tutorials Hub");
                snackbarText.setSpan(new ForegroundColorSpan(Color.CYAN), boldStart, snackbarText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                snackbarText.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), boldStart, snackbarText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                snackbarText.append(".");

                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, snackbarText, Snackbar.LENGTH_LONG);

                snackbar.show();


            }
        });

        buttonActionCallbackSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Email is deleted", Snackbar.LENGTH_LONG)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar snackbarUndo = Snackbar.make(coordinatorLayout, "Email is restored!", Snackbar.LENGTH_SHORT);
                                snackbarUndo.show();
                            }
                        });

                snackbar.show();
            }
        });
    }


}
