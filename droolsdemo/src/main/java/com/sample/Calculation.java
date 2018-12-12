package com.sample;

public class Calculation {
	private double wage;//当月工资
	private double actualwage;//当月税后工资
	private double wagemore;//全月应纳税所得额
	private double cess;//税率
	private double preminus;//速算扣除数
	private double wageminus;//当月工资扣减数
	/**
	 * 当月工资
	 * @return
	 */
	public double getWage() {
		return wage;
	}
	public void setWage(double wage) {
		this.wage = wage;
	}
	/**
	 * 当月税后工资
	 * @return
	 */
	public double getActualwage() {
		return actualwage;
	}
	public void setActualwage(double actualwage) {
		this.actualwage = actualwage;
	}
	/**
	 * 全月应纳税所得额
	 * @return
	 */
	public double getWagemore() {
		return wagemore;
	}
	public void setWagemore(double wagemore) {
		this.wagemore = wagemore;
	}
	/**
	 * 税率
	 * @return
	 */
	public double getCess() {
		return cess;
	}
	public void setCess(double cess) {
		this.cess = cess;
	}
	/**
	 * 速算扣除数
	 * @return
	 */
	public double getPreminus() {
		return preminus;
	}
	public void setPreminus(double preminus) {
		this.preminus = preminus;
	}
	/**
	 * 当月工资扣减数
	 * @return
	 */
	public double getWageminus() {
		return wageminus;
	}
	public void setWageminus(double wageminus) {
		this.wageminus = wageminus;
	}
	public Calculation() {
	}
	public Calculation(double wage) {
		super();
		this.wage = wage;
	}
	public Calculation(double wage,double wagemore) {
		super();
		this.wage = wage;
		this.wagemore=wagemore;
	}
	@Override
	public String toString() {
		return "当月工资="+wage+"\n当月税后工资="+actualwage+"\n全月应纳税所得额="+wagemore+
				"\n税率="+cess+"\n速算扣除数="+preminus+"\n当月工资扣减数="+wageminus;

	}



}
