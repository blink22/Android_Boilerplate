# Blink22 Android Coding Standards

## Table of contents

* [Code](#code)
    * [Style](#style)
    * [Indentation](#indentation)
    * [Line length](#line-length)
    * [Whitespace](#whitespace)
    * [Imports](#imports)
* [XML](#xml)
    * [Indentation](#indentation)
    * [Structure](#structure)
    * [Resources](#resource-Id-names)
    * [Layout Names](#layout-names)
    * [Id names](#id-names)
    * [Example](#example)
* [Documentation](#documentation)
    * [Javadoc](#javadoc)
    * [Comments](#comments)

## Code
#### Style
Follow the official Android code style guidelines: [http://source.android.com/source/code-style.html](http://source.android.com/source/code-style.html)

#### Indentation
Use 4 spaces per indentation level and no tabs.

#### Line Length
Stick within the 120 char line limit. Use line breaks to split up code according to the style guidelines.

#### Whitespace
Code should not have any trailing whitespace to avoid creating unnecessary diff issues. Please setup your IDE to remove these as a save action.

#### Imports
Please setup your IDE to remove all unused imports as a save action.

## XML

#### Indentation
Use 4 spaces per indentation level and no tabs.
Each attribute should appear on its own line.

#### Structure
XML tags should be ordered as follows: 'xmlns' first, then id, then layout_width and layout_height then alphabetically.

Add a space between the closing slash and the final attribute. E.g. ```android:textSize="10dp" />```

#### Resource Id names
String Resources -> ```if related to the app we use app_<screen name>_<string specific name> ```
#### Layout names
Activities layouts ->  ```activity_<screen name>```
Fragments layouts  ->  ```fragment_<screen name> ```
Cards/Items of lists,recyclerviews...etc -> ```item_<cell name> ```
#### Id names
Layout resource ids should use the following naming convention where possible:<br/>
```<object type>_<object name>```<br/>
E.g.
```
listview_hotels
imageview_star_rating
```

#### Example
Given a layout called activity_profile.xml:
```
<?xml  version="1.0"  encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical" >

    <!-- Screen title -->
    <TextView
        android:id="@+id/textview_profile_title"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text = "@string/app_profile_title" />
</LinearLayout>
```


## Documentation

#### Javadoc
Any new classes that are committed must include a class descriptor Javadoc along with:
```@author name@address.com```
Javadoc any public methods, variables and constants. Javadoc private methods where beneficial.

#### Comments
Use in-line commenting to help the next developer who might be editing your code, even if it seems obvious now. Inline comments should appear on the line above the code your are commenting.
Comment XML View elements using ```<!-- Comment -->```.

