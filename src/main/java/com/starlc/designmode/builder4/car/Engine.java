/**
 * 
 */
package com.starlc.designmode.builder4.car;

/**
 * @author liucheng2
 *
 */
public class Engine {
    private final String pl;  //����
    private final String maxOutputPower; //����������
    private final int rpm;  //ת��

    Engine(String pl, String maxOutputPower, int rpm) {
        this.pl = pl;
        this.maxOutputPower = maxOutputPower;
        this.rpm = rpm;
    }

    public static Builder custom(){

        return new Builder();
    }

    public static class Builder{
        private String pl;  //����
        private String maxOutputPower; //����������
        private int rpm;  //ת��

        public Builder pl(String pl){
            this.pl = pl;
            return this;
        }

        public Builder maxOutputPower(String maxOutputPower){
            this.maxOutputPower = maxOutputPower;
            return this;
        }

        public Builder rpm(int rpm){
            this.rpm = rpm;
            return this;
        }

        public Engine build(){

            return new Engine(pl, maxOutputPower, rpm);
        }
    }
}
