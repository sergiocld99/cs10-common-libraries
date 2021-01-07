package cs10.common.model.term;

public abstract class MathTerm {
    private boolean positive;

    public MathTerm(){
        this.positive = true;
    }

    public MathTerm(boolean positive) {
        this.positive = positive;
    }

    public void setPositive(boolean positive) {
        this.positive = positive;
    }

    public abstract double resolve();

    public abstract int getAppearancesOf(String op);

    public void invertSign(){
        positive = !positive;
    }

    public boolean isPositive() {
        return positive;
    }
}
