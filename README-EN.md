# ViewSupport

[![License](https://img.shields.io/badge/license-Apache%202-green.svg)](https://www.apache.org/licenses/LICENSE-2.0)
![](https://img.shields.io/badge/Support-7%2B-green.svg)
[![](https://jitpack.io/v/GcsSloop/ViewSupport.svg)](https://jitpack.io/#GcsSloop/ViewSupport)

### Weibo: [@GcsSloop](http://weibo.com/GcsSloop)

This is a library for View and CustomView，it has some tools can help you operate view or help you custom view easily.

*****

## Tools list

you can click the tools name to see the source.

Utils           | Summary
----------------|----------------------------------
CanvasAidUtils  | Canvas Aid util， you can use it draw a coordinate system to help you check the view position.
DensityUtils    | A utils of screen density. it can help you convert the different unit. <br/> *E.g: dp -> px  ps->dp sp->px px->sp*
MathUtils       | A Math utils, It can help you make some common calculations. <br/> *E.g: Get the distance between two points; angle2Radian; radian2Angle and others*
ViewUtils       | Utils for view. it can help you measure view, if you want get the view size before it not measured. or you can use it set view margin on code.



## Get it

#### Gradle:

**Step 1. Add the JitPack repository to your build file**

Add it in your root build.gradle at the end of repositories:

``` gradle
	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```

**Step 2. Add the dependency**

``` gradle
	dependencies {
	        compile 'com.github.GcsSloop:ViewSupport:v1.0.3'
	}
```

#### Maven

**Step 1. Add the JitPack repository to your build file**

Add it in your root build.gradle at the end of repositories:

``` maven
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```

**Step 2. Add the dependency**

``` maven
	<dependency>
	    <groupId>com.github.GcsSloop</groupId>
	    <artifactId>ViewSupport</artifactId>
	    <version>v1.0.2</version>
	</dependency>
```

## About Me

### Weibo: [@GcsSloop](http://weibo.com/GcsSloop)

<a href="https://github.com/GcsSloop/README/blob/master/README.md" target="_blank"> <img src="http://ww4.sinaimg.cn/large/005Xtdi2gw1f1qn89ihu3j315o0dwwjc.jpg" width=300 height=100 /> </a>

## License

```
Copyright (c) 2016 GcsSloop

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
