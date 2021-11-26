package Model;

public class Player {
    private String name;
    private Integer count;
    private Integer number;

    public Player(String name, Integer number) {
        this.name = name;
        this.number = number;
        count=0;
    }

    public boolean pay(Integer number) {
        if(number <= this.number) {
            this.number-=number;
            return true;        }
        else return false;
    }

    public Integer getCount() {
        return count;
    }
    public void addCount() {
         this.count++;
    }
    public void restartCount() {
        this.count=0;
    }
    public Integer getNumber() {
        return number;
    }

    public void addNumber(Integer number) {
        this.number+= number;
    }

}
