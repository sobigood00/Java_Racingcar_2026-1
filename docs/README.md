1. 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
2. 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
3. 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
4. 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
5. 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
6. 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
7. 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
8. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.


Car class / Validator class / main(사용자 입출력/게임 실행)
1. Car
- 이름/위치 정보
- move, getter 메서드

2. Validator
- 자동차 이름 입력값 검사
- 횟수 입력값 검사

3. Application(main)
- 사용자로부터 입력받음
- Validator로 검사
- Car 객체 생성-> 레이스 동작
- 결과 출력


2주차_리팩토링(주요 변경사항)
1. Application
main() 안에 로직이 많음 ->>> 메서드 분리
- getCarNames(): 이름 입력,검사
- getTryCount(): 횟수 입력,검사
- setupCars(String names): 입력받은 이름으로 car 리스트 만듦
- runRace(List<Car> racingCars, int tryCount): 경주 진행(자동차 움직임, 핵심)
- void printCarStatus(Car car): 차 위치(position)에 따른 - 출력
- void printWinners(List<Car> racingCars): 최종 우승자 출력
- main(): 위의 메서드 사용 -> 실행!

2. Validator
- int name_max 상수 선언했지만, 사용하지 않았음 -> 사용
- 이름 검사: 2.2 이름 빈값/공백 감지 시, 메세지 출력하도록 수정


