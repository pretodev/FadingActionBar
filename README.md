# FadindActionBar

Simple example of fading like Action bar with the Field Trip, and other applications.

### How to use

Modify your style.xml with:
```xml
<resources>
    <!-- Base application theme. -->
    <style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
        <item name="windowActionBarOverlay">true</item>
        <item name="android:windowContentOverlay">@null</item>
    </style>
</resources>
```

Add to FadingScrollView.java class to your project and use the code in xml layout:
```xml
<view xmlns:android="http://schemas.android.com/apk/res/android"
    class="com.example.sapps.fadingactionbarexample.FadingScrollView"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    ...
</view>
```
