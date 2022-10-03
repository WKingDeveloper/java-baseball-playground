package study;

public class PlayResult {

    private Integer[] result = new Integer[]{0, 0};

    public void addBall() {
        this.result[0] = this.result[0] + 1;
    }

    public void addStrike() {
        this.result[1] = this.result[1] + 1;
    }

    public boolean isThreeStrike() {
        return this.result[1] == 3;
    }

    public boolean isFourBall() {
        return this.result[0] == 0 && this.result[1] == 0;
    }

    public Integer[] getResult() {
        return this.result;
    }
}
