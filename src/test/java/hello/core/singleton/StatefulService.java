package hello.core.singleton;

public class StatefulService {
//    private int price;//상태를 유지하는 필드. 10000원이 20000원으로 바뀜(같은객체라서;)

    public int order(String name, int price){

        System.out.println("name = " + name+"price="+price);
//        this.price = price;//여기가 문제
        return price;
    }

//    public int getPrice(){
//        return price;
//    }
}
