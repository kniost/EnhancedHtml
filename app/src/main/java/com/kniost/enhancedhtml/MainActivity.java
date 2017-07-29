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
import com.kniost.library.HtmlConfig;
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
        HtmlConfig config = new HtmlConfig.Builder()
                .setFormulaScaleType(HtmlConfig.ScaleType.DENSITY)
                .setFormulaAlignment(HtmlConfig.ImgAlignment.VERTICAL_CENTER)
                .build();
        Spanned spannableString = EnhancedHtml.fromHtml(MainActivity.this,
                TEST_STRING,
                0, null,
                new CustomTagHandler(), config);
        mTestTv.setText(spannableString);

    }

    /**
     * 文字由UMEditor生成
     */
    private final String TEST_STRING =
            "<p>\n" +
            "    部分<input value=\"你好\"><span class=\"mathquill-embedded-latex\" style=\"background-color: rgb(255, 255, 255); width: 141px; height: 50px;\">\\frac{-b\\pm\\sqrt[2]{b^2-4ac}}{2a}</span><strong>文字加粗</strong>居左\n" +
            "</p>\n" +
            "<p style=\"text-align: center;\">\n" +
            "    可以<input value=\"你好\"><span style=\"color:rgb(255, 0, 0); text-decoration:line-through;\"><span style=\"text-decoration:underline;\">下划线，然后居中</span></span>\n" +
            "</p>\n" +
            "<p style=\"text-align: center;\">\n" +
            "    <img src=\"http://img.voidcn.com/vcimg/000/004/971/622_3a7_c9a.jpg\" style=\"width: 45.123px; height: 46.33px;\"/>\n" +
            "<br/> <input value=\"你好\">" +
            "</p>\n" +
            "<p style=\"text-align: right;\">\n" +
            "    或者有<font color=\"green\">个公式</font><span class=\"mathquill-embedded-latex\" style=\"width: 79px; height: 26px;\">x=x^2&lt;2&gt;1</span>，右对齐\n" +
            "</p>" +
            "<p>\n" +
            "    <br/>\n" +
            "    <div style=\"text-align: center;\">\n" +
            "        <span class=\"mathquill-embedded-latex\" style=\"background-color: rgb(255, 255, 255); width: 141px; height: 50px;\">\\frac{-b\\pm\\sqrt[2]{b^2-4ac}}{2a}</span>\n" +
            "    </div>\n" +
                    "<span class=\"mathquill-embedded-latex\" style=\"width: 116px; height: 32px;\">x=x^2\\&lt;1&gt;3</span>" +
            "</p>";
    private final String LATEX_STRING = "\\frac{-b\\pm\\sqrt[2]{b^2-4ac}}{2a}";


}
