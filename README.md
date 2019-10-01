[![](https://jitpack.io/v/darkmat13r/android-echo.svg)](https://jitpack.io/#darkmat13r/android-echo)
# Android  Echo

Android echo is the port of Laravel Echo library
[Laravel Echo](https://github.com/laravel/echo)

# Installation
**Step 1.** Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

```css
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

**Step 2.**  Add the dependency

```css
	dependencies {
	        implementation 'com.github.darkmat13r:android-echo:$LATEST_VERSION'
	}
```

# Usage

**Initialize Echo Instance**
```css
    val options = Connector.Options()  
    //Required for private and presence channel
    options.auth.headers["authorization"] = "Bearer ${YOUR ACCESS TOKEN}"  
    options.broadcaster = Broadcaster.SOCKET_IO  
    options.host = "http://your_laravel_project_url:port"  
    val echo = Echo(options)
```
**Private Channel**
Subscribing to a public channel
```css
echo.channel("public_channel_name")  
    ?.listen("post", object :EchoListener<LinkedTreeMap<String, Any>>(){  
        override fun onDataReceived(data: LinkedTreeMap<String, Any>?) {  
            requireActivity().runOnUiThread {  
                //TODO: Put your code here
	     } 
	  }  
    })
```

**Private Channel**
Subscribing to a private channel. 
```css
    echo.private("chat.${1}")  
        ?.listen("chat", object:EchoListener<LinkedTreeMap<String, Any>>(){  
            override fun onDataReceived(data: LinkedTreeMap<String,Any>?) {  
                Log.e(TAG, "On data received ${data}")  
                requireActivity().runOnUiThread {  
                //TODO: Put your code here
	             }  
	  }  
   })
  ``
