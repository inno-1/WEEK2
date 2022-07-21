public class Taxi extends Transport {
    String destination;    // 목적지
    int distance;    // 목적지까지 거리
    int fareByDistance;    // 거리당 요금
    int basicDistance;    // 기본 거리

    public Taxi() {    // 택시 기본 셋팅
        super();
        this.fare = 3000;    // 기본 요금
        this.fareByDistance = 1000;
        this.maxPassengers = 4;
        this.basicDistance = 1;
        this.number = countTaxi;
        countTaxi += 1;    // 택시 카운트
        getNumber();
        getFuel();
        getState();
    }

    @Override
    public void take(int passengers, String destination, int distance) {
        if (!this.state.equals("일반")) {    // 택시는 일반에 승객을 태움
            System.out.println("탑승 불가 상태");
        }
        else if (checkFuel()) {    // 주유 상태 체크
            if (this.curPassengers + passengers < this.maxPassengers) {
                setState("운행 중");    // 승객을 태우면 운행 중으로 상태 변경
                System.out.println("탑승 승객 수 = " + passengers);
                this.curPassengers += passengers;
                System.out.println("잔여 승객 수 = " + (this.maxPassengers - this.curPassengers));
                System.out.println("기본 요금 확인 = " + this.fare);
                System.out.println("목적지 = " + destination);
                this.destination = destination;
                System.out.println("목적지까지의 거리 = " + distance + "km");
                this.distance = distance;
                System.out.println("지불할 요금 = " + getTotalFare());
                getState();
            }
            else {
                System.out.println("최대 승객 수 초과");
            }
        }
    }

    public void pay() {    // 요금 결제
        this.curPassengers = 0;    // 손님 내림
        this.income += getTotalFare();    // 돈 받음
        setState("일반");    // 손님 받을 수 있는 상태
        if (checkFuel()) {    // 택시는 요금 결제 때 주유량 체크
            getFuel();
        }
        System.out.println("누적 요금 = " + this.income);
    }

    @Override
    public void setFuel(int fuel) {    // 택시는 요금 결제 때 주유량 체크
        if (this.fuel + fuel >= 0) {
            this.fuel += fuel;
        }
        else {
            System.out.println("기름이 " + (-fuel - this.fuel) + "만큼 부족하다.");    // 주유량이 마이너스는 안 됨
        }
    }

    public int getTotalFare() {
        return this.fare + (this.fareByDistance * (this.distance - this.basicDistance));
    }

    @Override
    public void getNumber() {
        System.out.println("택시 번호 = " + this.number);
    }

    @Override
    void take(int passengers) {    // 택시에 승객수만 입력하면 탑승 가능 여부만 체크
        if (!this.state.equals("일반")) {    // 택시는 일반에 승객을 태움
            System.out.println("탑승 불가 상태");
        }
        else if (checkFuel()) {    // 주유 상태 체크
            if (this.curPassengers + passengers < this.maxPassengers) {
                System.out.println("탑승 가능 상태");
            }
            else {
                System.out.println("최대 승객 수 초과");
            }
        }
    }
}
