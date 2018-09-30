# Android Boilerplate


## Description
Android boilerplate project to create new Android projects from. It provides basic architecture, tools and guidelines that we use when developing Android apps.

## Getting started
First clone the boilerplate repository. Next, if you want to copy the boilerplate into your own repository follow _Clone into your own repository_.
If you just want to get started with customizing things for your own project skip onto _Make it your own_.

### Clone into your own repository
Follow these steps if you have a repository with a branch you'd like to copy the boilerplate project into:
```
$ cd <path to boilerplate>
$ git remote add newrepo <path to newrepo>
$ git checkout --orphan copy
$ git commit -m "Copying boilerplate"
$ git push newrepo copy:<branch on new repo>
```
This will copy the boilerplate project without history to your own branch in your repository.

### Make it your own
Personalise the boilerplate for your own project:
1. Rename `com.blink22.blink22_boilerplate` packages to your own domain's stucture. E.g `com.mydomain.myapp`.
    See [StackOverflow](http://stackoverflow.com/a/29092698) for steps to easily accomplish this in Android Studio.

2. Open `app/build.gradle` and change the following to match your new package names:
    * `applicationId "com.mydomain.myapp"`
    * `testInstrumentationRunner "com.mydomain.myapp.application.ApplicationTestRunner"`



## Modules
This project consists of the following modules:

- app : contains all android related code -> activities - fragments ..etc
- core : contains almost all app logic pure java -> presenters - api client - models

## Code Standards
[Code Style](.github/CodeStyle.md)

## Code Structure 
This project is based on Model View Presenter Structure, this project make use of Dagger 2, RxJava, RxAndroid, Retrofit. 
## Used Third Parties : 
* [scalable DP](https://github.com/intuit/sdp)
* [Progress/Loading](https://github.com/81813780/AVLoadingIndicatorView)
* [Toast/Alert](https://github.com/Tapadoo/Alerter) 
* [Android Utility](https://github.com/mohsenoid/android_utils)
* [ButterKnife](https://github.com/JakeWharton/butterknife)
* [Image Chooser"PIX"](https://github.com/akshay2211/PixImagePicker)
* [Image Loader/Caching"Glide"](https://github.com/bumptech/glide) 
* [WebVIEW](https://github.com/TheFinestArtist/FinestWebView-Android)
* [RxPermission](https://github.com/tbruyelle/RxPermissions)

## Tools
* [Android Studio](https://developer.android.com/studio/index.html), Provides the fastest tools for building apps on every type of Android device.
* [Gradle](https://gradle.org/), An open source build automation system.

## Testing and CI
##TODO
