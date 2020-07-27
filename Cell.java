public class Cell {
    private char state;
    private char generatedState;
    private int greenStatesCount;

    public Cell(char state) {
        this.state = state;
        this.generatedState = state;
        this.greenStatesCount = (state == '1' ? 1 : 0);
    }

    public void changeState(char state) {
        this.state = state;

        if (state == '1') {
            this.greenStatesCount++;
        }
    }

    public char getState() {
        return this.state;
    }

    public char getGeneratedState() {
        return generatedState;
    }

    public void setGeneratedState(char generatedState) {
        this.generatedState = generatedState;
    }

    public int getGreenStatesCount() {
        return this.greenStatesCount;
    }
}
