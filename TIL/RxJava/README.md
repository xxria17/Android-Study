## Rx Java 이용해 연습하기

## flatMap()

원하는 입력값을 어떤 함수에 넣어서 변환하여 결과가 Observable로 리턴.

일대다 혹은 일대일 Observable 함수.

```kotlin
val element = subject.flatMap { it ->
	Observable.just("input : $it")
}

/*
	element type
	io.reactivex.rxjava3.internal.operators.observable.ObservableFlatMap
*/
```

이후 텍스트뷰에 넣으면 input : (입력값) 으로 출력됨.

## scan()

reduce와 비슷한 함수

실행할 때마다 입력값에 맞는 중간 결과 및 최종 결과를 구독자에게 발행함.

Observable 타입을 가짐.

```kotlin
val element = subject.flatMap { input ->
                    Observable.just("input : $input")
                }.scan { it1, it2 -> "$it1$it2"}

/*  
		element type
		io.reactivex.rxjava3.internal.operators.observable.ObservableScan
*/
```
