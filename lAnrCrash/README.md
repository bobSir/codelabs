# ANR & Crash

- /Applications/Android Studio.app/Contents/bin/lldb/bin 应用程序中右键显示包内容
  minidump_stackwalk /Users/bob/Desktop/test.dmp > crash.txt
  这里拿到的crash.txt都是寄存器地址，找到crash的so和寄存器信息

- /Users/bob/Library/Android/sdk/ndk/21.0.6113669/toolchains/x86_64-4.9/prebuilt/darwin-x86_64/bin/x86_64-linux-android-addr2line
  x86_64-linux-android-addr2line -f -C -e x.so 0x47744