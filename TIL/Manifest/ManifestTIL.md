# 매니페스트 Manifest.xml

앱에 대한 필수적인 정보가 담김. <br> 
안드로이드 빌드 툴, Android OS, 구글플레이에 제공.

<br>

## 내용

1. 앱 패키지 이름
2. 앱에서 사용되는 컴포넌트
3. 권한
4. 앱에서 요구하는 하드웨어와 소프트웨어 특징

<br>

<hr>

### 패키지 이름과 어플리케이션 ID

```xml
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
  package="com.example.myapplication">
```
xmlns로 **네임스페이스** 지정 
(android 속성 지정) <br>

package에 **고유한 application ID** 지정 
(App resource 접근할 때 상대경로)

<br>

```xml
<application
             android:allowBackup="true"  //앱이 백업 및 복원 인프라에 참여하도록 허용할지 여부
             android:supportsRtl="true"  //앱이 right to left를 지원해주는지 여부
             android:icon="@mipmap/ic_launcher"  //앱 전체를 위한 아이콘과 각각의 컴포넌트를 위한 아이콘 지정
             android:label="@string/app_name"  //앱의 이름 지정
             android:theme="@style/AppTheme"  //앱의 모든 기능들을 위한 기본 테마를 정의한 스타일 자원의 참조점
             android:allowClearUserData="true" //앱이 사용자 데이터를 재설정하도록 허용할지 여부
             android:backupAgent="@string/"  //백업에이전트인 BackupAgent의 서브클래스를 구현하는 클래스 이름
             android:backupInforeground="false"  //앱이 foreground에 상응하는 상태일 때도 앱에서 자동 백업 작업이 수행될 수 있다는 것을 나타냄 (false면 OS가 앱이 포그라운드에서 실행되는 동안 백업되지 않게 함.
             android:banner="@drawable/"  //연결된 항목에 확장 그래픽 배너를 제공하는 drawable 리소스
             android:debugger="false"  //사용자 모드로 기기에서 실행할 때에서 앱 디버그를 할 수 있는지 여부
             android:description="@string/"  //앱에 관해 사용자가 읽을 수 있는 텍스트
             android:directBootAware="false" //앱이 직접 부팅을 인식하는지 여부, 사용자가 기기를 잠금해제 하기 전에 앱이 실행될 수 있을지 여부
             android:enabled="true"  //앱의 구성요소를 인스턴스화할 수 있는지 여부. true일 때 각 구성요소의 enabled 속성은 구성요소가 사용 설정되는지 여부 결정, false일 때 구성요소별 값을 재정의하여 모든 구성요소가 사용 중지됨
             android:extractNativeLibs="false"  //패키지 설치 프로그램이 APK에서 파일 시스템으로 네이티브 라이브러리를 추출하는지 여부
             android:fullBackupContent="@string/"  //자동 백업용 전체 백업 규칙이 포함된 xml 가리킴
             android:fullBackupOnly="false"  //자동 백업을 기기에서 사용할지 여부
             android:hasCode="true"  //앱에 코드가 포함되는지 여부. false일 때 구성요소를 시작할 때 앱 코드를 로드하지 않음
             android:hardwareAccelerated="true"  //앱의 모든 Activity과 View에 하드웨어 가속 렌더링을 사용 설정 해야하는지 여부
             android:isGame="false"  //앱이 게임인지 여부. 시스템에서 해당 앱을 게임으로 분류해 그룹화하거나 다른 앱과 별도로 표시 가능
             android:killAfterRestore="true"  //전체 시스템 복원 작업 중에 설정이 복원된 후 문제의 앱을 종료할 지 여부. true일 때 앱이 데이터 처리를 완료한 후에 앱 종료
             android:largeHeap="false"  //대규모 Dalvik힙으로 앱의 프로세스를 생성해야 하는지 여부
             android:logo="@drawable/"  //전체 앱의 각 구성요소의 기본 아이콘
             android:manageSpaceActivity="@string/"  //사용자가 기기에서 앱이 차지하는 메모리를 관리할 수 있게 시스템이 시작할 수 있는 Activity 서브클래스의 정규화된 이름
             android:name="@string/"  //앱에 관해 구현되는 application 서브클래스의 정규화된 이름
             android:networkSecurityConfig="@xml/"  //네트워크 보안 구성이 포함된 xml파일 이름 지정
             android:permission="@string/"  //클라이언트가 앱과 상호작용하기 위해 있어야 하는 권한의 이름
             android:persistent="false"  //앱을 항상 실행상태로 유지할지 여부
             android:process="@string/"  //앱의 모든 구성요소를 실행해야하는 프로세스 이름
             android:restoreAnyVersion="true"  //앱이 백업된 데이터 세트를 복원할 준비가 되었음을 나타냄
             android:requiredAccountType="@string/"  //앱이 작동하는데 필요한 계정 유형을 지정
             android:resizeableActivity="false"  //앱이 멀티 윈도우 화면을 지원하는지 여부. true시 분할 화면 모드와 자유 형식 모드로 Activity 시작 가능
             android:restrictedAccountType="true"  //앱이 필요한 계정 유형을 지정하며 제한된 프로필이 소유자 사용자가 가진 유형의 계정에 액세스 할 수 있음을 나타냄
             android:taskAffinity="@string/"
             android:testOnly="false"  //앱이 테스트만을 목적으로 하는지 여부. 외부에 노출할 수도 있으며 보안에는 허점이 생기지만 테스트는 유용
             android:uiOptions="none"  //Activity의 UI에 적용되는 추가 옵션
             android:usesCleartextTraffic="false"  //앱이 일반 텍스트 HTTP와 같은 일반 텍스트 네트워크 트래픽을 사용하는지 여부
             android:vmSafeMode="false">  //앱이 가상 머신을 안전모드로 작동할지 여부
```

<br>

**android:icon과 android:logo의 차이점은?**
차이점은 모르겠지만 application 태그에 android:logo 안먹음. icon과 roundIcon만 적용됨.

<br>

### 앱 구성요소 선언

```xml
<activity android:name=".MainActivity"/>

<activity android:name=".SplashActivity">
  <intent-filter>
    <action android:name="android.intent.action.MAIN"/>
    <category android:name="android.intent.category.LAUNCHER"/>
  </intent-filter>
</activity>
```
activity를 선언해주지 않으면 해당 컴포넌트 사용할 수 없음.

컴포넌트는 Intent에 의해 작업 활성화. 

**action.MAIN, category.LAUNCHER** -> 첫 시작하는 화면이라고 지정!
<br>
~~intent는 모아서 정리 예정~~

```xml
    <provider android:authorities="list"
              android:directBootAware=["true" | "false"]
              android:enabled=["true" | "false"]
              android:exported=["true" | "false"]
              android:grantUriPermissions=["true" | "false"]
              android:icon="drawable resource"
              android:initOrder="integer"
              android:label="string resource"
              android:multiprocess=["true" | "false"]
              android:name="string"
              android:permission="string"
              android:process="string"
              android:readPermission="string"
              android:syncable=["true" | "false"]
              android:writePermission="string" >
        . . .
    </provider>
```
**콘텐츠 제공자** 구성요소를 선언. <br>
콘텐츠 제공자는 애플리케이션에서 관리되는 데이터에 관해 구조화된 액세스를 제공하는 ContentProvider의 서브클래스. <br>
애플리케이션의 모든 콘텐츠 제공자는 manifest 파일의 <provider> 요소에서 정의해야 함. 그러지 않으면 시스템에서 인식되지 않고 실행되지 않음.

  
```xml
<receiver android:directBootAware=["true" | "false"]
              android:enabled=["true" | "false"]
              android:exported=["true" | "false"]
              android:icon="drawable resource"
              android:label="string resource"
              android:name="string"
              android:permission="string"
              android:process="string" >
        . . .
    </receiver>
```
**broadcast receiver** (BroadcastReceiver 서브클래스)를 애플리케이션의 구성요소 중 하나로 선언.  <br>
broadcast receiver를 사용하면 애플리케이션의 다른 구성요소가 실행되고 있지 않을 때도 시스템이나 다른 애플리케이션에서 브로드캐스트팅하는 인텐트를 애플리케이션에서 수신할 수 있음.
  

```xml
<service android:description="string resource"
         android:directBootAware=["true" | "false"]
         android:enabled=["true" | "false"]
         android:exported=["true" | "false"]
         android:foregroundServiceType=["connectedDevice" | "dataSync" |
                                        "location" | "mediaPlayback" | "mediaProjection" |
                                        "phoneCall"]
         android:icon="drawable resource"
         android:isolatedProcess=["true" | "false"]
         android:label="string resource"
         android:name="string"
         android:permission="string"
         android:process="string" >
    . . .
</service>
```
**서비스** (Service 하위 클래스)를 애플리케이션의 구성요소 중 하나로 선언.  <br>
Activity와 달리, 서비스는 시각적 사용자 인터페이스가 없음.  <br>
서비스는 오래 실행되는 백그라운드 작업이나 다른 애플리케이션에서 호출할 수 있는 리치 커뮤니케이션 API를 구현하는 데 사용함.
  
  
<br>

### 권한 요청

```xml
<uses-permission android:name="android.permission.INTERNET"/>  //인터넷 사용 권한
<uses-permission android:name="android.permission.BLUETOOTH"/>  //블루투스 상태 확인
<uses-permission android:name="android.permission.VIBRATE"/>  //진동 설정 권한
<uses-permission android:name="android.permission.SET_ALRAM"/>  //알람 설정 권한
<uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>  //와이파이 상태 확인
<uses-permission android:name="android.permission.CAMERA"/> //카메라 권한
<uses-permission android:name="android.permission.CONTACTS.READ_CONTACTS"/>  //주소록 읽기
<uses-permission android:name="android.permission.CONTACTS.WRITE_CONTACTS"/>  //주소록 쓰기
<uses-permission android:name="android.permission.LOCATION.ACCESS_FINE_LOCATION"/>  //위치 정보 사용
<uses-permission android:name="android.permission.LOCATION.ACCESS_COARSE_LOCATION"/>  //위치 정보 사용
<uses-permission android:name="android.permission.CALENDAR.READ_CALENDAR"/>  //캘린더 읽기
<uses-permission android:name="android.permission.CALENDAR.WRITE_CALENDAR"/>  //캘린더 쓰기
<uses-permission android:name="android.permission.SEND_SMS"/>  //SMS 전송
```
앱이 동작하면서 시스템의 특정 부분을 사용하려면 안드로이드로부터 권한을 위임받아야 함. <br>
사용하려는 권한이 개인정보를 요청한다면 사용자로부터 동의를 받아야 함. <br>

(카메라, 위치 정보, 주소록 등이 따로 허용을 받아야 하는 **위험 권한**) <br>

그 밖의 인터넷 접근 권한, 와이파이 접근 권한, 블루투스 접근 권한 등은 **일반 권한**. <br>

그리고 **서명 권한** (이 권한을 사용하려는 앱이 권한을 정의하는 앱과 동일한 인증서로 서명된 경우 자동으로 권한 부여) 이 있음. <br>

(권한 종류는 매우 많기 때문에 필요할 때마다 찾아쓰면 될듯...)


<br>

```xml
<permission-tree android:icon="drawable resource"
                     android:label="string resource" ]
                     android:name="string" />
```
권한 트리의 기본 이름을 선언함. <br>
애플리케이션은 트리 내의 모든 이름의 소유권을 가지며 PackageManager.addPermission()을 호출하여 동적으로 새 권한을 트리에 추가할 수 있음. <br>
예를 들어 기본 이름이 com.example.project.taxes이면 다음과 같은 권한이 추가될 수 있음.


```xml
<permission-group android:description="string resource"
                      android:icon="drawable resource"
                      android:label="string resource"
                      android:name="string" />
```
관련 권한의 논리적인 그룹 이름을 선언함. <br>
개별 권한은 <permission> 요소의 permissionGroup 속성을 통해 그룹에 참여함.  <br>
그룹의 구성원은 사용자 인터페이스에 함께 표시됩니다. <br>
  
  
```xml
<grant-uri-permission android:path="string"
                          android:pathPattern="string"
                          android:pathPrefix="string" />
```
상위 콘텐츠 제공업체에게 액세스 권한이 있는 앱 데이터의 하위 집합을 지정함. <br>
데이터 하위 집합은 content: URI의 경로 부분으로 나타냄.  <br>
권한 부여는 일반적으로 데이터 액세스 권한이 없는 제공업체의 클라이언트가 일회성으로 제한을 극복할 수 있도록 하는 방법. 
                                  

```xml
    <path-permission android:path="string"
                     android:pathPrefix="string"
                     android:pathPattern="string"
                     android:permission="string"
                     android:readPermission="string"
                     android:writePermission="string" />
```
콘텐츠 제공자 내의 특정 데이터 하위 집합과 관련하여 경로와 필수 권한을 정의.  <br>
이 요소를 여러 번 지정하여 여러 경로를 제공할 수 있습니다.
  
  
### 기기 호환성

```xml
<uses-feature android:name="android.hardware.sensor.compass"
              android:required="true" />
```
**uses-feature**를 이용하여 앱에 필요한 하드웨어 및 소프트웨어 기능을 선언할 수 있음.
위 태그는 나침반 센서 선언.


```xml
<uses-sdk android:minSdkVersion="integer"
          android:targetSdkVersion="integer"
          android:maxSdkVersion="integer" />
```
**uses-sdk**를 이용하여 하나 이상의 안드로이드 플랫폼 버전과의 애플리케이션 호환성을 API 레벨 정수로 표시.
플랫폼 버전 요구사항을 충족하지 않는 기기에서 앱을 필터링함.


```xml
<uses-library android:name="@string/library name"
              android:required="true" />
```
**uses-library**를 이용하여 어플리케이션이 연결되어야 하는 공유 라이브러리 지정.
패키지의 클래스 로더에 라이브러리의 코드를 포함하도록 시스템에 알림.


```xml
<uses-configuration
      android:reqFiveWayNav=["true" | "false"]
      android:reqHardKeyboard=["true" | "false"]
      android:reqKeyboardType=["undefined" | "nokeys" | "qwerty" | "twelvekey"]
      android:reqNavigation=["undefined" | "nonav" | "dpad" | "trackball" | "wheel"]
      android:reqTouchScreen=["undefined" | "notouch" | "stylus" | "finger"] />
```
애플리케이션에 필요한 하드웨어 및 소프트웨어 기능을 나타냄.
애플리케이션에 5방향 탐색 컨트롤이 필요한지, <br>
애플리케이션에 하드웨어 키보드가 필요한지, <br>
애플리케이션에 필요한 키보드 유형이 뭔지, <br>
애플리케이션에 필요한 탐색 기기가 뭔지, <br>
애플리케이션에 필요한 터치스크린 유형이 뭔지 <br>
지정함.



### 그밖의

```xml
<meta-data android:name="string"
           android:resource="resource specification"
           android:value="string" />
```
상위 구성요소에 제공될 수 있는 추가 임의 데이터 항목의 이름-값 쌍. 
구성요소 요소에는 여러 **meta-data** 하위 요소가 포함될 수 있음.
  
  
```xml
<instrumentation android:functionalTest=["true" | "false"]
                     android:handleProfiling=["true" | "false"]
                     android:icon="drawable resource"
                     android:label="string resource"
                     android:name="string"
                     android:targetPackage="string"
                     android:targetProcesses="string" />
```
애플리케이션과 시스템의 상호작용을 모니터링할 수 있는 Instrumentation 클래스를 선언. 
계측 객체는 애플리케이션의 구성요소 이전에 인스턴스화됨.  

  
```xml
<activity-alias android:enabled=["true" | "false"]
                    android:exported=["true" | "false"]
                    android:icon="drawable resource"
                    android:label="string resource"
                    android:name="string"
                    android:permission="string"
                    android:targetActivity="string" >
        . . .
    </activity-alias>
```
활동의 별칭. <br>
targetActivity 속성에서 이름이 지정됨. 

타겟은 별칭과 동일한 애플리케이션에 있어야 하며 manifest에서 별칭보다 먼저 선언되어야 함.


```xml
    <path-permission android:path="string"
                     android:pathPrefix="string"
                     android:pathPattern="string"
                     android:permission="string"
                     android:readPermission="string"
                     android:writePermission="string" />
```
콘텐츠 제공자 내의 특정 데이터 하위 집합과 관련하여 경로와 필수 권한을 정의. <br>
이 요소를 여러 번 지정하여 여러 경로를 제공할 수 있음.
  
  
```xml
<supports-gl-texture
     android:name="string" />
```
앱에서 지원하는 단일 GL 텍스처 압축 형식을 선언.


```xml
    <compatible-screens>
        <screen android:screenSize=["small" | "normal" | "large" | "xlarge"]
                android:screenDensity=["ldpi" | "mdpi" | "hdpi" | "xhdpi"
                                       | "280" | "360" | "420" | "480" | "560" ] />
        ...
    </compatible-screens>
```
애플리케이션이 호환되는 각 화면 구성을 지정. <br>
manifest에는 <compatible-screens> 요소의 인스턴스 1개만 허용되지만 <screen> 요소는 여러 개 포함할 수 있음. <br>
각 <screen> 요소는 애플리케이션이 호환되는 특정 화면 크기-밀도 조합을 지정함.
 > 주의: 일반적으로 이 manifest 요소를 사용해서는 안 됩니다. 이 요소를 사용하면 사용자가 화면 구성이 목록에 없는 기기를 사용하는 경우 애플리케이션을 설치할 수 없으므로 애플리케이션의 잠재적 사용자층이 현저히 줄어들 수 있습니다. 따라서 이 요소는 애플리케이션이 특정 화면 구성에서 전혀 작동하지 않을 때 최후의 수단으로만 사용해야합니다. 이 요소를 사용하는 대신 여러 화면 지원 가이드에 따라 다양한 화면 크기 및 밀도용 대체 레이아웃과 비트맵을 사용하여 여러 화면을 위한 확장 가능한 지원을 제공해야 합니다.
  
