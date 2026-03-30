package racingcar;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;


//3. main
//- 입력받음 -> Validator로 검사
//- Car 객체 생성/레이스 동작
//- 결과 출력
public class Application {
    public static void main(String[] args) {
        //1.사용자로부터 이름/횟수 입력받기 -> 검사
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine(); //내부적으로 Scanner.nextLine()과 동일하게 작동
        Validator.validateCarName(names);

        System.out.println("시도할 회수는 몇회인가요?");
        String times = Console.readLine();
        int tryCount = Validator.validateTry(times);

        //2.Car 객체 리스트 생성
        String[] nameList = names.split(",",-1);
        List <Car> racingCars= new ArrayList<>();
        for (String name: nameList){
            racingCars.add(new Car(name));
        }
        //4. 결과 출력(실행 결과, 최종 우승자)
        System.out.println("\n실행 결과");
        for (int i = 0; i<tryCount; i++){
            for(Car car : racingCars){
                car.move();
                System.out.print(car.getName() + " : ");
                for(int j = 0; j < car.getPosition(); j++){
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();

        }
        //최종 우승자
        int maxPosition = 0; //최고 거리
        for (Car car : racingCars){
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition(); //최고 거리 갱신
            }
        }
        List<String> winners = new ArrayList<>();
        for (Car car : racingCars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winners));











    }
}
