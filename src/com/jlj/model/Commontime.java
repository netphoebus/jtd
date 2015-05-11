package com.jlj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Commontime entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "commontime", schema = "dbo", catalog = "jtd")
public class Commontime implements java.io.Serializable {

	// Fields

	private Integer id;
	private Sig sig;
	private Integer hour;
	private Integer minute;
	private Integer seconds;
	private Integer workingway;
	private Integer workingprogram;
	private Integer lstime;
	private Integer hdtime;
	private Integer qchdtime;
	private Integer t0;
	private Integer t1;
	private Integer t2;
	private Integer t3;
	private Integer t4;
	private Integer t5;
	private Integer t6;
	private Integer t7;
	private Integer t8;
	private Integer t9;
	private Integer t10;
	private Integer t11;
	private Integer t12;
	private Integer t13;
	private Integer t14;
	private Integer t15;
	private Integer t16;
	private Integer t17;
	private Integer t18;
	private Integer t19;
	private Integer t20;
	private Integer t21;
	private Integer t22;
	private Integer t23;
	private Integer t24;
	private Integer t25;
	private Integer t26;
	private Integer t27;
	private Integer t28;
	private Integer t29;
	private Integer t30;
	private Integer t31;
	private Integer commontype;

	// Constructors

	/** default constructor */
	public Commontime() {
	}

	/** full constructor */
	public Commontime(Sig sig, Integer hour, Integer minute, Integer seconds,
			Integer workingway, Integer workingprogram, Integer lstime,
			Integer hdtime, Integer qchdtime, Integer t0, Integer t1,
			Integer t2, Integer t3, Integer t4, Integer t5, Integer t6,
			Integer t7, Integer t8, Integer t9, Integer t10, Integer t11,
			Integer t12, Integer t13, Integer t14, Integer t15, Integer t16,
			Integer t17, Integer t18, Integer t19, Integer t20, Integer t21,
			Integer t22, Integer t23, Integer t24, Integer t25, Integer t26,
			Integer t27, Integer t28, Integer t29, Integer t30, Integer t31,
			Integer commontype) {
		this.sig = sig;
		this.hour = hour;
		this.minute = minute;
		this.seconds = seconds;
		this.workingway = workingway;
		this.workingprogram = workingprogram;
		this.lstime = lstime;
		this.hdtime = hdtime;
		this.qchdtime = qchdtime;
		this.t0 = t0;
		this.t1 = t1;
		this.t2 = t2;
		this.t3 = t3;
		this.t4 = t4;
		this.t5 = t5;
		this.t6 = t6;
		this.t7 = t7;
		this.t8 = t8;
		this.t9 = t9;
		this.t10 = t10;
		this.t11 = t11;
		this.t12 = t12;
		this.t13 = t13;
		this.t14 = t14;
		this.t15 = t15;
		this.t16 = t16;
		this.t17 = t17;
		this.t18 = t18;
		this.t19 = t19;
		this.t20 = t20;
		this.t21 = t21;
		this.t22 = t22;
		this.t23 = t23;
		this.t24 = t24;
		this.t25 = t25;
		this.t26 = t26;
		this.t27 = t27;
		this.t28 = t28;
		this.t29 = t29;
		this.t30 = t30;
		this.t31 = t31;
		this.commontype = commontype;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "signid")
	public Sig getSig() {
		return this.sig;
	}

	public void setSig(Sig sig) {
		this.sig = sig;
	}

	@Column(name = "hour")
	public Integer getHour() {
		return this.hour;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}

	@Column(name = "minute")
	public Integer getMinute() {
		return this.minute;
	}

	public void setMinute(Integer minute) {
		this.minute = minute;
	}

	@Column(name = "seconds")
	public Integer getSeconds() {
		return this.seconds;
	}

	public void setSeconds(Integer seconds) {
		this.seconds = seconds;
	}

	@Column(name = "workingway")
	public Integer getWorkingway() {
		return this.workingway;
	}

	public void setWorkingway(Integer workingway) {
		this.workingway = workingway;
	}

	@Column(name = "workingprogram")
	public Integer getWorkingprogram() {
		return this.workingprogram;
	}

	public void setWorkingprogram(Integer workingprogram) {
		this.workingprogram = workingprogram;
	}

	@Column(name = "lstime")
	public Integer getLstime() {
		return this.lstime;
	}

	public void setLstime(Integer lstime) {
		this.lstime = lstime;
	}

	@Column(name = "hdtime")
	public Integer getHdtime() {
		return this.hdtime;
	}

	public void setHdtime(Integer hdtime) {
		this.hdtime = hdtime;
	}

	@Column(name = "qchdtime")
	public Integer getQchdtime() {
		return this.qchdtime;
	}

	public void setQchdtime(Integer qchdtime) {
		this.qchdtime = qchdtime;
	}

	@Column(name = "t0")
	public Integer getT0() {
		return this.t0;
	}

	public void setT0(Integer t0) {
		this.t0 = t0;
	}

	@Column(name = "t1")
	public Integer getT1() {
		return this.t1;
	}

	public void setT1(Integer t1) {
		this.t1 = t1;
	}

	@Column(name = "t2")
	public Integer getT2() {
		return this.t2;
	}

	public void setT2(Integer t2) {
		this.t2 = t2;
	}

	@Column(name = "t3")
	public Integer getT3() {
		return this.t3;
	}

	public void setT3(Integer t3) {
		this.t3 = t3;
	}

	@Column(name = "t4")
	public Integer getT4() {
		return this.t4;
	}

	public void setT4(Integer t4) {
		this.t4 = t4;
	}

	@Column(name = "t5")
	public Integer getT5() {
		return this.t5;
	}

	public void setT5(Integer t5) {
		this.t5 = t5;
	}

	@Column(name = "t6")
	public Integer getT6() {
		return this.t6;
	}

	public void setT6(Integer t6) {
		this.t6 = t6;
	}

	@Column(name = "t7")
	public Integer getT7() {
		return this.t7;
	}

	public void setT7(Integer t7) {
		this.t7 = t7;
	}

	@Column(name = "t8")
	public Integer getT8() {
		return this.t8;
	}

	public void setT8(Integer t8) {
		this.t8 = t8;
	}

	@Column(name = "t9")
	public Integer getT9() {
		return this.t9;
	}

	public void setT9(Integer t9) {
		this.t9 = t9;
	}

	@Column(name = "t10")
	public Integer getT10() {
		return this.t10;
	}

	public void setT10(Integer t10) {
		this.t10 = t10;
	}

	@Column(name = "t11")
	public Integer getT11() {
		return this.t11;
	}

	public void setT11(Integer t11) {
		this.t11 = t11;
	}

	@Column(name = "t12")
	public Integer getT12() {
		return this.t12;
	}

	public void setT12(Integer t12) {
		this.t12 = t12;
	}

	@Column(name = "t13")
	public Integer getT13() {
		return this.t13;
	}

	public void setT13(Integer t13) {
		this.t13 = t13;
	}

	@Column(name = "t14")
	public Integer getT14() {
		return this.t14;
	}

	public void setT14(Integer t14) {
		this.t14 = t14;
	}

	@Column(name = "t15")
	public Integer getT15() {
		return this.t15;
	}

	public void setT15(Integer t15) {
		this.t15 = t15;
	}

	@Column(name = "t16")
	public Integer getT16() {
		return this.t16;
	}

	public void setT16(Integer t16) {
		this.t16 = t16;
	}

	@Column(name = "t17")
	public Integer getT17() {
		return this.t17;
	}

	public void setT17(Integer t17) {
		this.t17 = t17;
	}

	@Column(name = "t18")
	public Integer getT18() {
		return this.t18;
	}

	public void setT18(Integer t18) {
		this.t18 = t18;
	}

	@Column(name = "t19")
	public Integer getT19() {
		return this.t19;
	}

	public void setT19(Integer t19) {
		this.t19 = t19;
	}

	@Column(name = "t20")
	public Integer getT20() {
		return this.t20;
	}

	public void setT20(Integer t20) {
		this.t20 = t20;
	}

	@Column(name = "t21")
	public Integer getT21() {
		return this.t21;
	}

	public void setT21(Integer t21) {
		this.t21 = t21;
	}

	@Column(name = "t22")
	public Integer getT22() {
		return this.t22;
	}

	public void setT22(Integer t22) {
		this.t22 = t22;
	}

	@Column(name = "t23")
	public Integer getT23() {
		return this.t23;
	}

	public void setT23(Integer t23) {
		this.t23 = t23;
	}

	@Column(name = "t24")
	public Integer getT24() {
		return this.t24;
	}

	public void setT24(Integer t24) {
		this.t24 = t24;
	}

	@Column(name = "t25")
	public Integer getT25() {
		return this.t25;
	}

	public void setT25(Integer t25) {
		this.t25 = t25;
	}

	@Column(name = "t26")
	public Integer getT26() {
		return this.t26;
	}

	public void setT26(Integer t26) {
		this.t26 = t26;
	}

	@Column(name = "t27")
	public Integer getT27() {
		return this.t27;
	}

	public void setT27(Integer t27) {
		this.t27 = t27;
	}

	@Column(name = "t28")
	public Integer getT28() {
		return this.t28;
	}

	public void setT28(Integer t28) {
		this.t28 = t28;
	}

	@Column(name = "t29")
	public Integer getT29() {
		return this.t29;
	}

	public void setT29(Integer t29) {
		this.t29 = t29;
	}

	@Column(name = "t30")
	public Integer getT30() {
		return this.t30;
	}

	public void setT30(Integer t30) {
		this.t30 = t30;
	}

	@Column(name = "t31")
	public Integer getT31() {
		return this.t31;
	}

	public void setT31(Integer t31) {
		this.t31 = t31;
	}

	@Column(name = "commontype")
	public Integer getCommontype() {
		return this.commontype;
	}

	public void setCommontype(Integer commontype) {
		this.commontype = commontype;
	}

}