package com.kniost.enhancedhtml;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.TextView;

import com.kniost.library.EnhancedHtml;
import com.kniost.library.InputSpan;

import org.xml.sax.Attributes;
import org.xml.sax.XMLReader;

public class MainActivity extends AppCompatActivity {

    TextView mTestTv;
    Button mRefreshBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTestTv = (TextView) findViewById(R.id.test_tv);
        mTestTv.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Spanned spanned = ((Spanned)mTestTv.getText());
                InputSpan[] inputSpans = spanned.getSpans(0, spanned.length(), InputSpan.class);
                if (inputSpans != null && inputSpans.length > 0) {
                    for (int i = 0; i < inputSpans.length; i++) {
                        Log.d("RectFGGG", inputSpans[i].getRectF().toString());
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
        CustomTagHandler tagHandler = new CustomTagHandler();
        Spanned spannableString = EnhancedHtml.fromHtml(MainActivity.this, TEST_STRING, 0, null, tagHandler);
        mTestTv.setText(spannableString);

    }

    /**
     * 文字由UMEditor生成
     */
    private String TEST_STRING = "<p>\n" +
            "    部分<input value=\"你好\"><strong>文字加粗</strong>居左\n" +
            "</p>\n" +
            "<p style=\"text-align: center;\">\n" +
            "    可以<input value=\"你好\"><span style=\"color:#ff0000\"><span style=\"text-decoration:underline;\">下划线，然后居中</span></span>\n" +
            "</p>\n" +
            "<p style=\"text-align: center;\">\n" +
            "    <img src=\"http://img.voidcn.com/vcimg/000/004/971/622_3a7_c9a.jpg\" style=\"width: 182px; height: 326px;\"/>\n" +
            "<br/> <input value=\"你好\">" +
            "</p>\n" +
            "<p style=\"text-align: right;\">\n" +
            "    或者有<font color=\"green\">个公式</font><span class=\"mathquill-embedded-latex\" style=\"width: 25px; height: 32px;\">x^3</span>，右对齐\n" +
            "</p>";

    private class CustomTagHandler implements EnhancedHtml.TagHandler {
        private String mInputValue;
        private int mStart;

        @Override
        public void handleTag(boolean opening, String tag, Attributes attributes, Editable output, XMLReader xmlReader) {
            if (opening) {
                if (tag.equalsIgnoreCase("input")) {
                    mInputValue = attributes.getValue("", "value");
                    mStart = output.length();
                    output.append(mInputValue);
                }
            }

            if (!opening) {
                if (tag.equalsIgnoreCase("input")) {
                    output.setSpan(new InputSpan(), mStart, output.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
            }
        }
    }

}
