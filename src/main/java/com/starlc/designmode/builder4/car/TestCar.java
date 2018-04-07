/**
 * 
 */
package com.starlc.designmode.builder4.car;

/**
 * @author liucheng2
 *
 */
public class TestCar {
	public static void main(String[] args) {
		Car car = new Car.Builder("Audi", "�µ�", "Q5")
        .producingArea("�й���½")
        .producingDate("2016-07-01 00:00:00")
        .engine(Engine.custom()
                .pl("2L")
                .maxOutputPower("110kW")
                .rpm(5400)
                .build())
        .wheel(Wheel.custom()
                .brand("AA")
                .producingDate("2016-03-01 00:00:00")
                .build())
        .light(Light.custom()
                .brand("5A")
                .structure("���Ȳ���")
                .producingDate("2016-02-01 00:00:00")
                .build())
        .build();

		System.out.println(car);
	}
}
