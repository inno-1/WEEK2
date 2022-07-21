public class Bus extends Transport {
    public Bus() {    // 버스 기본 셋팅
        super();
        this.fare = 1000;
        this.maxPassengers = 30;
        this.number = countBus;
        countBus += 1;    // 버스 카운트
        startService();    // 버스는 최초 상태가 운행 중 (주유 상태 체크)
        getNumber();
    }

    @Override
    public void take(int passengers) {
        if (!this.state.equals("운행 중")) {    // 버스는 운행 중에 승객을 태움
            System.out.println("운행 중이 아닙니다.");
        }
        else if (checkFuel()) {    // 주유 상태 체크
            if (this.curPassengers + passengers <= this.maxPassengers) {
                System.out.println("탑승 승객 수 = " + passengers);
                this.curPassengers += passengers;
                System.out.println("잔여 승객 수 = " + (this.maxPassengers - this.curPassengers));
                System.out.println("요금 확인 = " + (this.fare * passengers));
                this.income += (this.fare * passengers);
            }
            else {
                System.out.println("최대 승객 수 초과");
            }
        }
    }

    @Override
    public void setFuel(int fuel) {
        if (this.fuel + fuel >= 0) {    // 주유량이 마이너스는 안 됨
            this.fuel += fuel;
            if (this.state.equals("차고지행")) {    // 운행 가능 상태인지 체크
                getState();
            }
            if (checkFuel()) {    // 주유량 체크
                getFuel();
            }
        }
        else {
            System.out.println("기름이 " + (-fuel - this.fuel) + "만큼 부족하다.");    // 주유량이 마이너스는 안 됨
        }
    }

    @Override
    public void getNumber() {
        System.out.println("버스 번호 = " + this.number);
    }

    @Override
    void take(int number, String destination, int distance) {    // 오버로딩된 메소드의 오버라이딩은 ??

    }
}
