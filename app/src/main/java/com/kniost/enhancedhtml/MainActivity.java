package com.kniost.enhancedhtml;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.TextView;

import com.kniost.library.EnhancedHtml;
import com.kniost.library.jlatexmath.core.AjLatexMath;

public class MainActivity extends AppCompatActivity {

    TextView mTestTv;
    Button mRefreshBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AjLatexMath.init(this);

        mTestTv = (TextView) findViewById(R.id.test_tv);
        mTestTv.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Spanned spanned = ((Spanned)mTestTv.getText());
                DemoInputSpan[] demoInputSpen = spanned.getSpans(0, spanned.length(), DemoInputSpan.class);
                if (demoInputSpen != null && demoInputSpen.length > 0) {
                    for (int i = 0; i < demoInputSpen.length; i++) {
                        Log.d("RectFGGG", demoInputSpen[i].getRectF().toString());
                    }
                }
            }
        });
        setTestTv();

        mRefreshBtn = (Button) findViewById(R.id.refresh_btn);
        mRefreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTestTv();
            }
        });
    }

    private void setTestTv() {
        Spanned spannableString = EnhancedHtml.fromHtml(MainActivity.this, TEST_STRING, 0, null, new CustomTagHandler());
        mTestTv.setText(spannableString);

    }

    /**
     * 文字由UMEditor生成
     */
    private final String TEST_STRING = "<p>\n" +
            "    部分<input value=\"你好\"><strong>文字加粗</strong>居左\n" +
            "</p>\n" +
            "<p style=\"text-align: center;\">\n" +
            "    可以<input value=\"你好\"><span style=\"color:#ff0000\"><span style=\"text-decoration:underline;\">下划线，然后居中</span></span>\n" +
            "</p>\n" +
            "<p style=\"text-align: center;\">\n" +
            "    <img src=\"http://img.voidcn.com/vcimg/000/004/971/622_3a7_c9a.jpg\" style=\"width: 182.123px; height: 326.33px;\"/>\n" +
            "<br/> <input value=\"你好\">" +
            "</p>\n" +
            "<p style=\"text-align: right;\">\n" +
            "    或者有<font color=\"green\">个公式</font><span class=\"mathquill-embedded-latex\" style=\"width: 25px; height: 32px;\">x^3</span>，右对齐\n" +
            "</p>" +
            "<p>\n" +
            "    <br/>\n" +
            "    <div style=\"text-align: center;\">\n" +
            "        <span class=\"mathquill-embedded-latex\" style=\"background-color: rgb(255, 255, 255); width: 141px; height: 50px;\">\\frac{-b\\pm\\sqrt[2]{b^2-4ac}}{2a}</span>\n" +
            "    </div>\n" +
            "</p>";

    private final String LATEX_STRING = "\\frac{-b\\pm\\sqrt[2]{b^2-4ac}}{2a}";


}
