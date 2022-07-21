public abstract class Transport {
    int number;    // 차량 번호
    int fuel;    // 기름 양
    int speed;    // 현재 속도
    int maxPassengers;    // 최대 승객 수
    int curPassengers;    // 현재 승객 수
    String state;    // 운행 상태
    int income;    // 누적 요금 (소득)
    int fare;    // 기본 요금
    static int countBus = 1;    // 버스 카운트
    static int countTaxi = 1;    // 택시 카운트


    public Transport() {    // 차량 기본 셋팅
        this.fuel = 100;
        this.speed = 0;
        this.state = "일반";
        this.income = 0;
        this.curPassengers = 0;
    }

    abstract void take(int passengers);
    abstract void take(int passengers, String destination, int distance);
    public abstract void getNumber();

    public abstract void setFuel(int fuel);

    public void startService() {
        if (checkFuel()) {
            setState("운행 중");
        }
    }

    public void stopService() {
        setState("차고지행");
    }



    public void setSpeed(int speed) {
        if (checkFuel()) {
            this.speed += speed;
            if (this.speed < 0) {    // 후진은 없는 걸로
                this.speed = 0;
            }
        }
    }

    public void setState(String state) {
        if (state.equals("차고지행")) {    // 차고지행은 운행 종료를 뜻함
            this.speed = 0;
            this.curPassengers = 0;
        }
        this.state = state;
    }

    public boolean checkFuel() {
        if (this.fuel < 10) {
            stopService();    // 기름이 부족하면 운행 종료
            getFuel();
            getState();
            System.out.println("주유량을 확인해 주세요.");    // ALERT
            return false;
        }
        else return true;
    }

    public void getState() {
        System.out.println("상태 = " + this.state);
    }

    public void getFuel() {
        System.out.println("주유량 = " + this.fuel);
    }

    public void getSpeed() {
        System.out.println("속도 = " + this.speed);
    }

    public void getPassengers() {
        System.out.println("현재 승객 수 = " + this.curPassengers);
    }

}
