# 액티비티 Activity

Android 수준의 구성요소로, 같은 수준에는 Content Provider, Broadcast Receiver, Service가 있음.

Android Manifest에도 등록됨.

앱의 UI로 보여지는 부분이기도 함.

Android framework가 앱을 실행하면 보이는 것 (런처 아이콘, 앱 바로가기, 멀티 화면에서) 모두 Activity임.

**앱 UI로의 진입점 (=entry point)**

화면을 관리하고 사용자가 발생시키는 다양한 이벤트를 처리하는 컴포넌트.


## Activity Lifecycle

안드로이드는 앱이 실행된 후 다른 액티비티 화면으로 전환되거나, 스마트폰 화면이 꺼지거나 혹은 앱이 종료될 때와 같이 <br> 
상태 변화가 있을 때마다 화면에 보이는 액티비티의 생명 주기 메서드를 호출해서 상태변화를 알려줌.

<br>

``onCreate`` &nbsp; Activity가 **최초 생성될 때 호출**. 초기화 단계 <br> 

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  ↓  <br>
     
``onStart`` &nbsp; **상호작용하기 전**에 호출  <br>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  ↓  <br>
    
``onResume`` &nbsp; 사용자와 **상호작용이 시작**됐을 때 호출  <br> 

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  ↓  <br>
    
``onPause`` &nbsp; 현재 **Activity가 가려졌을 때** 호출  <br>  

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  ↓  <br>
    
``onStop`` &nbsp; Activity가 **더이상 보이지 않을 때** 호출 <br>  

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  ↓  <br>
    
``onDestroy`` &nbsp; 시스템 리소스가 부족하거나 finish가 실행되어 **Activity가 아예 종료됐을 떄** 호출  <br>

<br>

``onRestart``  &nbsp; onStart가 호출되기 전, **가려진 Activity가 다시 보여질 때** 호출

<hr>

### 테스트 해보기

**Activity를 실행했을 때** <br>
<img width="600" alt="activitylifecycle(1)" src="https://user-images.githubusercontent.com/41279544/129861865-0d50d7c4-9d9d-47a5-94c5-c9ee312ebd21.PNG">

<br>

**Activity를 종료하지 않고 홈버튼을 눌러 나갔을 때** <br>
<img width="600" alt="activitylifecycle(2)" src="https://user-images.githubusercontent.com/41279544/129862040-4500caa3-ccb0-4ff7-bd7d-0a1c4928a5b2.PNG">

<br>

**Activity에 다시 들어왔을 때** <br>
<img width="600" alt="activitylifecycle(3)" src="https://user-images.githubusercontent.com/41279544/129862122-0507b557-6aa0-4395-a3f3-3883ab9ea3c6.PNG">

<br>

**Activity를 아예 없애버렸을 때 (현재 실행중인 앱에서 지웠을 때)** <br>
<img width="600" alt="activitylifecycle(4)" src="https://user-images.githubusercontent.com/41279544/129862202-83f6c6d0-6def-42c4-a4b9-0e4614f58311.PNG">
