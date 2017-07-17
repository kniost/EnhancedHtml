# Enhanced Html

Add it in your root build.gradle at the end of repositories:

```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
	
Step 2. Add the dependency

```
dependencies {
        compile 'com.github.kniost:EnhancedHtml:v0.0.4'
}
```

[Click here to find the newest release version](https://github.com/kniost/EnhancedHtml/releases)

- support `<span "style=underline">`
- support a lot of colors
- plan to support `Latex`

[![](https://jitpack.io/v/kniost/EnhancedHtml.svg)](https://jitpack.io/#kniost/EnhancedHtml)