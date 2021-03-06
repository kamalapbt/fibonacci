## Fibonacci App
This is single Activity application to show fibonacci series. Initially it shows 0th fibonacci number.
When `Next` button clicked, it will show next fibonacci number and calculation for that(if applicable).
- First and Second number shows as `0` and `1` as they defined (f0=0, f1=1)
- Next numbers will show `(n)th-fibonacci` followed by the calculation `(n-2)th-fibonacci` +  `(n-1)th-fibonacci`
<img src="https://user-images.githubusercontent.com/830437/121342938-466ffb80-c976-11eb-99ee-a8a972f06f88.gif" width="240px"/>

### Requirements
- Minimum Android SDK API: 26
- Based Android SDK: 29.0.3
- Language: Kotlin

### Architecture
Application is designed based on MVVM architechture.
- fibonacci
  - model: contains data model
  - view: represents the UI of the application and observe the ViewModel
  - viewmodel: link/connection between the model and view
  - generator: grouped fibonacci number series generator utilities

### Technologies
Viewbinding, Constraintlayout, Junit, Esspresso, Mockito

### Testing
- Unit test: `FibonacciGeneratorImpUnitTest` and `FibonacciViewModelUnitTest`
- Automated test: `FibonacciActivityInstrumentedTest`
