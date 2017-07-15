package com.kniost.enhancedhtml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.kniost.library.EnhancedHtml;

public class MainActivity extends AppCompatActivity {

    TextView mTestTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTestTv = (TextView) findViewById(R.id.test_tv);
        mTestTv.setText(EnhancedHtml.fromHtml(this, TEST_STRING, 0));
    }

    /**
     * 文字由UMEditor生成
     */
    private String TEST_STRING = "<p>\n" +
            "    部分<strong>文字加粗</strong>居左\n" +
            "</p>\n" +
            "<p style=\"text-align: center;\">\n" +
            "    可以<span style=\"text-decoration:underline;\">下划线，然后居中</span>\n" +
            "</p>\n" +
            "<p style=\"text-align: center;\">\n" +
            "    <img src=\"http://img.voidcn.com/vcimg/000/004/971/622_3a7_c9a.jpg\" style=\"width: 182px; height: 326px;\"/>\n" +
            "</p>\n" +
            "<p style=\"text-align: right;\">\n" +
            "    或者有个公式<span class=\"mathquill-embedded-latex\" style=\"width: 25px; height: 32px;\">x^3</span>，右对齐\n" +
            "</p>";
}
