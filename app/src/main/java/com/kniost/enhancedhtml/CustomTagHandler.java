package com.kniost.enhancedhtml;

import android.text.Editable;
import android.text.Spanned;

import com.kniost.library.EnhancedHtml;

import org.xml.sax.Attributes;
import org.xml.sax.XMLReader;

/**
 * Created by kniost on 2017/7/18.
 */

class CustomTagHandler implements EnhancedHtml.TagHandler {
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
                output.setSpan(new DemoInputSpan(), mStart, output.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
    }
}
