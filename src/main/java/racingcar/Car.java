package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

/*Car
- 이름/위치 정보
- move, getter 메서드*/

public class Car {
    private final String name;
    private int position;

    //정보를 넘겨받아 필드에 저장(생성자)
    public Car(String name){
        this.name = name;
        this.position = 0;
    }
    
    //동작: move 메서드
    public int move(){
        if (Randoms.pickNumberInRange(0,9) >=4){
            position++;
        }
        return position;
    }

    //현재 이름/위치 반환: getter 메서드 넘겨주기 위해
    public String getName(){
        return name;
    }
    public int getPosition(){
        return position;
    }
}
