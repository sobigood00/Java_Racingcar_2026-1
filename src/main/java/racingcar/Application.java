package racingcar;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String names = getCarNames(); // 입력 및 검증
        int tryCount = getTryCount();
        List<Car> racingCars = setupCarsList(names);  // 자동차(객체) 생성
        runRace(racingCars, tryCount); // 경주 진행/출력
        printWinners(racingCars); // 최종 우승자 출력
    }

    //메서드 분리
    private static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine(); //내부적으로 Scanner.nextLine()과 동일하게 작동
        return Validator.validateCarName(names); //반환값 단순화
    }

    private static int getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String times = Console.readLine();
        return Validator.validateTry(times);
    }

    private static List<Car> setupCarsList(String names) {
        String[] nameList = names.split(",", -1); //문자열을 , 을 구분으로 슬라이싱
        List<Car> racingCars = new ArrayList<>();
        for (String name : nameList) { //이름으로 자동차 리스트
            racingCars.add(new Car(name));
        }
        return racingCars;
    }

    private static void runRace(List<Car> racingCars, int tryCount) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < tryCount; i++) {
            for (Car car : racingCars) {
                car.move();
                printCarStatus(car); //- 출력
            }
            System.out.println();
        }
    }
    private static void printCarStatus(Car car) {
        System.out.print(car.getName() + " : ");
        for (int j = 0; j < car.getPosition(); j++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private static void printWinners(List<Car> racingCars) {
        int maxPosition = 0;
        for (Car car : racingCars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
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


