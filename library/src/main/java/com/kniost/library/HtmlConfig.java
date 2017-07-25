package com.kniost.library;

import com.kniost.library.jlatexmath.core.TeXFormula;

/**
 * This class is used to customize the behaivor of EnhancedHtml,
 * TexIconBuilder allows you to customize the LaTeX formula's appearance
 * ScaleType ORIGINAL shows the picture in defined size, DENSITY shows the pic in density-based scaled size
 */
public class HtmlConfig {
    enum ScaleType {
        ORIGNAL, DENSITY
    }
    private TeXFormula.TeXIconBuilder mTeXIconBuilder;
    private ScaleType mImgScaleType;
    private ScaleType mFormulaScaleType;
    private boolean mIsOverrideFontSize;

    HtmlConfig() {}

    public TeXFormula.TeXIconBuilder getTeXIconBuilder() {
        return mTeXIconBuilder;
    }

    public ScaleType getImgScaleType() {
        return mImgScaleType;
    }

    public void setTeXIconBuilder(TeXFormula.TeXIconBuilder teXIconBuilder) {
        mTeXIconBuilder = teXIconBuilder;
    }

    public void setImgScaleType(ScaleType imgScaleType) {
        mImgScaleType = imgScaleType;
    }

    public ScaleType getFormulaScaleType() {
        return mFormulaScaleType;
    }

    public void setFormulaScaleType(ScaleType formulaScaleType) {
        mFormulaScaleType = formulaScaleType;
    }

    public boolean isOverrideFontSize() {
        return mIsOverrideFontSize;
    }

    public void setOverrideFontSize(boolean overrideFontSize) {
        mIsOverrideFontSize = overrideFontSize;
    }

    public static class Builder {
        HtmlConfig mHtmlConfig;

        public Builder() {
            mHtmlConfig = new HtmlConfig();
            mHtmlConfig.setOverrideFontSize(true);
        }

        public Builder setTeXIconBuilder(TeXFormula.TeXIconBuilder builder) {
            mHtmlConfig.setTeXIconBuilder(builder);
            return this;
        }

        public Builder setScaleType(ScaleType scaleType) {
            mHtmlConfig.setImgScaleType(scaleType);
            return this;
        }

        public Builder setFormulaScaleType(ScaleType scaleType) {
            mHtmlConfig.setFormulaScaleType(scaleType);
            return this;
        }

        public Builder setOverrideFontSize(boolean overrideFontSize) {
            mHtmlConfig.setOverrideFontSize(overrideFontSize);
            return this;
        }

        public HtmlConfig build() {
            if (mHtmlConfig.getImgScaleType() == null) {
                mHtmlConfig.setImgScaleType(ScaleType.DENSITY);
            }
            if (mHtmlConfig.getFormulaScaleType() == null) {
                mHtmlConfig.setFormulaScaleType(ScaleType.ORIGNAL);
            }
            return mHtmlConfig;
        }
    }
}