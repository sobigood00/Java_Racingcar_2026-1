package racingcar;
import java.util.HashSet;
import java.util.Set;

/*2. Validator
- 자동차 이름 입력값 검사
- 횟수 입력값 검사*/


public class Validator {
    //이름 입력 검사
    public static String validateCarName(String names){
        if(names.isBlank()){ //1. 전체 검사
            throw new IllegalArgumentException("이름 입력값이 공백이거나 존재하지 않습니다.");
        }
        //입력을 ,를 기준으로 자른다. 배열로 저장.
        String [] nameList = names.split(",",-1);
        int name_max = 5;
        Set<String> equalNames = new HashSet<>(); //자바에서 문자열 중복 검사는 HashSet을 사용하면 편리하다.
        //2. 개별 입력에 대한 검사
        for(String name:nameList){
            if(name.length() > name_max) { //2.1 이름 길이
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해주세요.");
            }
            if(name.isBlank() || name.contains(" ")){ //2.2 이름 빈 값/공백
                throw new IllegalArgumentException("자동차 이름을 입력하지 않았습니다.");
            }if(!equalNames.add(name)){ //2.3 이름 중복 검사
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }
        }
        return names;

    }

    //시도 횟수 검사
    public static int validateTry(String times){
        int count;
        try{
            count = Integer.parseInt(times); //Integer.parseInt(문자)일 경우, NumberException 에러 발생 ->try/catch
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("시도 횟수를 숫자로 입력해주세요.");
        }
        if (count < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        return count;
    }

}
