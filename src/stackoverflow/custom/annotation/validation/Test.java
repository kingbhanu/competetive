package stackoverflow.custom.annotation.validation;

import javax.validation.constraints.NotNull;

public class Test {
    @NotNull
    @CustomValidator(min = 20)
    @CustomValidator(max = 80)
    private int no;
    public void setNo(int n) {this.no = n;}
    public int getNo() {return no;}
    public Test(int n) {
        this.no = n;
    }
}
