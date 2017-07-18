# Enhanced Html

Android 的 Html 库的加强版。参考了[HtmlCompat](https://github.com/Pixplicity/HtmlCompat)。

[English](README.md)

## 加强了什么？

### 1. 从Android自带的Html加强

支持所有 Android N 更新的`Html`库功能，现在支持的tag如下所示：

*   `<br>` `<p>` `<ul>` `<li>` `<div>` `<span>` `<img>`
*   `<strong>` `<b>` `<em>` `<i>` `<u>` `<s>` `<strike>` `<del>`
*   `<cite>` `<dfn>` `<big>` `<small>` `<font>` `<blockquote>` `<tt>`
*   `<a>` `<sup>` `<sub>`
*   `<h1>` `<h2>` `<h3>` `<h4>` `<h5>` `<h6>`

还支持下面这些内联CSS样式:

*   `text-align` (left, right, center, start, end)
*   `color` `width` `height`
*   `background`, `background-color`
*   `text-decoration`(line-through, underline)

支持所有在[这里](https://www.w3schools.com/cssref/css_colors.asp)被预定义的CSS颜色

### 2. 良好的LaTeX公式支持

本库支持如下格式的Html的Latex公式:

```html
<span class="mathquill-embedded-latex" style="width: 170px; height: 50px;">x=\frac{-b\pm\sqrt[2]{b^2-4ac}}{2a}</span>
```
可以用应用较广的 [UEditor](http://ueditor.baidu.com/website/umeditor.html) 或者其他类似的编辑器产生.

本库使用 [JLaTeXMath](https://github.com/mksmbrtsh/jlatexmath-android) 来显示LaTeX.

### 如果有需要将添加更多特性

## 添加到你的工程里

第一步，在项目的根gradle文件下添加jitpack.io：

```gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
	
第二步，在模块的gradle文件中添加依赖

```gradle
dependencies {
        compile 'com.github.kniost:EnhancedHtml:[VERSION_HERE]'
}
```

最新版本如下: 
[![](https://jitpack.io/v/kniost/EnhancedHtml.svg)](https://jitpack.io/#kniost/EnhancedHtml)

## 用法

如果需要使用LaTeX，你必须先初始化 JLaTeXMath :

```java
AjLatexMath.init(context); // init library: load fonts, create paint, etc.
```

示例:

```java
Spanned spannableString = EnhancedHtml.fromHtml(mContext, 
                TEST_STRING, 
                0, 
                CustomImageGetter, 
                CustomTagHandler);
mTestTv.setText(spannableString);
```

[![](https://jitpack.io/v/kniost/EnhancedHtml.svg)](https://jitpack.io/#kniost/EnhancedHtml)