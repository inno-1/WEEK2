public class Main {
    public static void main(String[] args) {
        Bus bus1 = new Bus();    // 버스 2대 생성 -> 각 버스 번호 다른지 확인
        Bus bus2 = new Bus();
        bus1.take(2);    // 승객 +2 -> 탑승 승객 수, 잔여 승객 수, 요금 확인
        bus1.setFuel(-50);    // 주유량 -50
        bus1.setState("차고지행");    // 상태 변경
        bus1.setFuel(10);    // 주유량 +10
        bus1.setState("운행 중");    // 상태 변경
        bus1.take(45);    // 승객 +45 -> 최대 승객 수 초과
        bus1.take(5);    // 승객 +5
        bus1.setFuel(-55);    // 주유량 -55 -> 주유량, 상태, 주유 필요

        Taxi taxi1 = new Taxi();    // 택시 2대 생성 -> 각 택시 번호 다른지 확인, 주유량, 상태
        Taxi taxi2 = new Taxi();
        taxi1.take(2, "서울역", 2);    // 승객 +2, 목적지 = 서울역, 목적지까지 거리 = 2km
                    // -> 탑승 승객 수, 잔여 승객 수, 기본 요금 확인, 목적지, 목적지까지 거리, 지불할 요금, 상태
        taxi1.setFuel(-80);    // 주유량 -80
        taxi1.pay();    // 요금 결제 -> 주유량, 누적 요금
        taxi1.take(5);    // 승객 +5 -> 최대 승객 수 초과
        taxi1.take(3, "구로디지털단지역", 12);    // 승객 +3, 목적지 = 구로디지털단지역, 목적지까지 거리 = 12km
                    // -> 탑승 승객 수, 잔여 승객 수, 기본 요금 확인, 목적지, 목적지까지 거리, 지불할 요금, 상태
        taxi1.setFuel(-20);    // 주유량 -20
        taxi1.pay();    // 요금 결제 -> 주유량, 상태, 누적 요금, 주유 필요
    }
}