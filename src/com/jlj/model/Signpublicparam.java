package com.jlj.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Signpublicparam entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "signpublicparam", schema = "dbo", catalog = "jtd")
public class Signpublicparam implements java.io.Serializable {

	// Fields

	private Integer id;
	private Sig sig;
	private Integer qchdtime;
	private String kjhstime;
	private String number;
	private String comparam;
	private Integer checkflow;
	private String innermark;
	private Integer workingset;
	private Integer mon;
	private Integer tue;
	private Integer wes;
	private Integer thir;
	private Integer fra;
	private Integer sata;
	private Integer sun;
	private Date paramversion;
	private Integer gmintime;
	private Integer gmaxtime;
	private Integer zdbctime;
	private Integer countdownmode;
	private Integer jgkz;
	private String ip;
	private String centerport;
	private String centerip;
	private Integer checklight;
	private Integer xrfxtime;
	private Integer cycle;
	private Integer xyxr;
	private String sbnetmastk;
	private String gateway;
	private String specialday0;
	private String specialday1;
	private String specialday2;
	private String specialday3;
	private String specialday4;
	private String specialday5;
	private String specialday6;
	private String specialday7;
	private String specialday8;
	private String specialday9;
	private String specialday10;
	private String specialday11;
	private String specialday12;
	private String specialday13;
	private String specialday14;
	private String specialday15;
	private String specialday16;
	private String specialday17;
	private String specialday18;
	private String specialday19;
	private String specialday20;
	private String specialday21;
	private String specialday22;
	private String specialday23;

	// Constructors

	/** default constructor */
	public Signpublicparam() {
	}

	/** minimal constructor */
	public Signpublicparam(Sig sig) {
		this.sig = sig;
	}

	/** full constructor */
	public Signpublicparam(Sig sig, Integer qchdtime, String kjhstime,
			String number, String comparam, Integer checkflow,
			String innermark, Integer workingset, Integer mon, Integer tue,
			Integer wes, Integer thir, Integer fra, Integer sata, Integer sun,
			Date paramversion, Integer gmintime, Integer gmaxtime,
			Integer zdbctime, Integer countdownmode, Integer jgkz, String ip,
			String centerport, String centerip, Integer checklight,
			Integer xrfxtime, Integer cycle, Integer xyxr, String sbnetmastk,
			String gateway, String specialday0, String specialday1,
			String specialday2, String specialday3, String specialday4,
			String specialday5, String specialday6, String specialday7,
			String specialday8, String specialday9, String specialday10,
			String specialday11, String specialday12, String specialday13,
			String specialday14, String specialday15, String specialday16,
			String specialday17, String specialday18, String specialday19,
			String specialday20, String specialday21, String specialday22,
			String specialday23) {
		this.sig = sig;
		this.qchdtime = qchdtime;
		this.kjhstime = kjhstime;
		this.number = number;
		this.comparam = comparam;
		this.checkflow = checkflow;
		this.innermark = innermark;
		this.workingset = workingset;
		this.mon = mon;
		this.tue = tue;
		this.wes = wes;
		this.thir = thir;
		this.fra = fra;
		this.sata = sata;
		this.sun = sun;
		this.paramversion = paramversion;
		this.gmintime = gmintime;
		this.gmaxtime = gmaxtime;
		this.zdbctime = zdbctime;
		this.countdownmode = countdownmode;
		this.jgkz = jgkz;
		this.ip = ip;
		this.centerport = centerport;
		this.centerip = centerip;
		this.checklight = checklight;
		this.xrfxtime = xrfxtime;
		this.cycle = cycle;
		this.xyxr = xyxr;
		this.sbnetmastk = sbnetmastk;
		this.gateway = gateway;
		this.specialday0 = specialday0;
		this.specialday1 = specialday1;
		this.specialday2 = specialday2;
		this.specialday3 = specialday3;
		this.specialday4 = specialday4;
		this.specialday5 = specialday5;
		this.specialday6 = specialday6;
		this.specialday7 = specialday7;
		this.specialday8 = specialday8;
		this.specialday9 = specialday9;
		this.specialday10 = specialday10;
		this.specialday11 = specialday11;
		this.specialday12 = specialday12;
		this.specialday13 = specialday13;
		this.specialday14 = specialday14;
		this.specialday15 = specialday15;
		this.specialday16 = specialday16;
		this.specialday17 = specialday17;
		this.specialday18 = specialday18;
		this.specialday19 = specialday19;
		this.specialday20 = specialday20;
		this.specialday21 = specialday21;
		this.specialday22 = specialday22;
		this.specialday23 = specialday23;
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
	@JoinColumn(name = "sigid", nullable = false)
	public Sig getSig() {
		return this.sig;
	}

	public void setSig(Sig sig) {
		this.sig = sig;
	}

	@Column(name = "qchdtime")
	public Integer getQchdtime() {
		return this.qchdtime;
	}

	public void setQchdtime(Integer qchdtime) {
		this.qchdtime = qchdtime;
	}

	@Column(name = "kjhstime", length = 20)
	public String getKjhstime() {
		return this.kjhstime;
	}

	public void setKjhstime(String kjhstime) {
		this.kjhstime = kjhstime;
	}

	@Column(name = "number", length = 20)
	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Column(name = "comparam", length = 20)
	public String getComparam() {
		return this.comparam;
	}

	public void setComparam(String comparam) {
		this.comparam = comparam;
	}

	@Column(name = "checkflow")
	public Integer getCheckflow() {
		return this.checkflow;
	}

	public void setCheckflow(Integer checkflow) {
		this.checkflow = checkflow;
	}

	@Column(name = "innermark", length = 20)
	public String getInnermark() {
		return this.innermark;
	}

	public void setInnermark(String innermark) {
		this.innermark = innermark;
	}

	@Column(name = "workingset")
	public Integer getWorkingset() {
		return this.workingset;
	}

	public void setWorkingset(Integer workingset) {
		this.workingset = workingset;
	}

	@Column(name = "mon")
	public Integer getMon() {
		return this.mon;
	}

	public void setMon(Integer mon) {
		this.mon = mon;
	}

	@Column(name = "tue")
	public Integer getTue() {
		return this.tue;
	}

	public void setTue(Integer tue) {
		this.tue = tue;
	}

	@Column(name = "wes")
	public Integer getWes() {
		return this.wes;
	}

	public void setWes(Integer wes) {
		this.wes = wes;
	}

	@Column(name = "thir")
	public Integer getThir() {
		return this.thir;
	}

	public void setThir(Integer thir) {
		this.thir = thir;
	}

	@Column(name = "fra")
	public Integer getFra() {
		return this.fra;
	}

	public void setFra(Integer fra) {
		this.fra = fra;
	}

	@Column(name = "sata")
	public Integer getSata() {
		return this.sata;
	}

	public void setSata(Integer sata) {
		this.sata = sata;
	}

	@Column(name = "sun")
	public Integer getSun() {
		return this.sun;
	}

	public void setSun(Integer sun) {
		this.sun = sun;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "paramversion", length = 23)
	public Date getParamversion() {
		return this.paramversion;
	}

	public void setParamversion(Date paramversion) {
		this.paramversion = paramversion;
	}

	@Column(name = "gmintime")
	public Integer getGmintime() {
		return this.gmintime;
	}

	public void setGmintime(Integer gmintime) {
		this.gmintime = gmintime;
	}

	@Column(name = "gmaxtime")
	public Integer getGmaxtime() {
		return this.gmaxtime;
	}

	public void setGmaxtime(Integer gmaxtime) {
		this.gmaxtime = gmaxtime;
	}

	@Column(name = "zdbctime")
	public Integer getZdbctime() {
		return this.zdbctime;
	}

	public void setZdbctime(Integer zdbctime) {
		this.zdbctime = zdbctime;
	}

	@Column(name = "countdownmode")
	public Integer getCountdownmode() {
		return this.countdownmode;
	}

	public void setCountdownmode(Integer countdownmode) {
		this.countdownmode = countdownmode;
	}

	@Column(name = "jgkz")
	public Integer getJgkz() {
		return this.jgkz;
	}

	public void setJgkz(Integer jgkz) {
		this.jgkz = jgkz;
	}

	@Column(name = "ip", length = 20)
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name = "centerport", length = 20)
	public String getCenterport() {
		return this.centerport;
	}

	public void setCenterport(String centerport) {
		this.centerport = centerport;
	}

	@Column(name = "centerip", length = 20)
	public String getCenterip() {
		return this.centerip;
	}

	public void setCenterip(String centerip) {
		this.centerip = centerip;
	}

	@Column(name = "checklight")
	public Integer getChecklight() {
		return this.checklight;
	}

	public void setChecklight(Integer checklight) {
		this.checklight = checklight;
	}

	@Column(name = "xrfxtime")
	public Integer getXrfxtime() {
		return this.xrfxtime;
	}

	public void setXrfxtime(Integer xrfxtime) {
		this.xrfxtime = xrfxtime;
	}

	@Column(name = "cycle")
	public Integer getCycle() {
		return this.cycle;
	}

	public void setCycle(Integer cycle) {
		this.cycle = cycle;
	}

	@Column(name = "xyxr")
	public Integer getXyxr() {
		return this.xyxr;
	}

	public void setXyxr(Integer xyxr) {
		this.xyxr = xyxr;
	}

	@Column(name = "sbnetmastk", length = 20)
	public String getSbnetmastk() {
		return this.sbnetmastk;
	}

	public void setSbnetmastk(String sbnetmastk) {
		this.sbnetmastk = sbnetmastk;
	}

	@Column(name = "gateway", length = 20)
	public String getGateway() {
		return this.gateway;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	@Column(name = "specialday0", length = 10)
	public String getSpecialday0() {
		return this.specialday0;
	}

	public void setSpecialday0(String specialday0) {
		this.specialday0 = specialday0;
	}

	@Column(name = "specialday1", length = 10)
	public String getSpecialday1() {
		return this.specialday1;
	}

	public void setSpecialday1(String specialday1) {
		this.specialday1 = specialday1;
	}

	@Column(name = "specialday2", length = 10)
	public String getSpecialday2() {
		return this.specialday2;
	}

	public void setSpecialday2(String specialday2) {
		this.specialday2 = specialday2;
	}

	@Column(name = "specialday3", length = 10)
	public String getSpecialday3() {
		return this.specialday3;
	}

	public void setSpecialday3(String specialday3) {
		this.specialday3 = specialday3;
	}

	@Column(name = "specialday4", length = 10)
	public String getSpecialday4() {
		return this.specialday4;
	}

	public void setSpecialday4(String specialday4) {
		this.specialday4 = specialday4;
	}

	@Column(name = "specialday5", length = 10)
	public String getSpecialday5() {
		return this.specialday5;
	}

	public void setSpecialday5(String specialday5) {
		this.specialday5 = specialday5;
	}

	@Column(name = "specialday6", length = 10)
	public String getSpecialday6() {
		return this.specialday6;
	}

	public void setSpecialday6(String specialday6) {
		this.specialday6 = specialday6;
	}

	@Column(name = "specialday7", length = 10)
	public String getSpecialday7() {
		return this.specialday7;
	}

	public void setSpecialday7(String specialday7) {
		this.specialday7 = specialday7;
	}

	@Column(name = "specialday8", length = 10)
	public String getSpecialday8() {
		return this.specialday8;
	}

	public void setSpecialday8(String specialday8) {
		this.specialday8 = specialday8;
	}

	@Column(name = "specialday9", length = 10)
	public String getSpecialday9() {
		return this.specialday9;
	}

	public void setSpecialday9(String specialday9) {
		this.specialday9 = specialday9;
	}

	@Column(name = "specialday10", length = 10)
	public String getSpecialday10() {
		return this.specialday10;
	}

	public void setSpecialday10(String specialday10) {
		this.specialday10 = specialday10;
	}

	@Column(name = "specialday11", length = 10)
	public String getSpecialday11() {
		return this.specialday11;
	}

	public void setSpecialday11(String specialday11) {
		this.specialday11 = specialday11;
	}

	@Column(name = "specialday12", length = 10)
	public String getSpecialday12() {
		return this.specialday12;
	}

	public void setSpecialday12(String specialday12) {
		this.specialday12 = specialday12;
	}

	@Column(name = "specialday13", length = 10)
	public String getSpecialday13() {
		return this.specialday13;
	}

	public void setSpecialday13(String specialday13) {
		this.specialday13 = specialday13;
	}

	@Column(name = "specialday14", length = 10)
	public String getSpecialday14() {
		return this.specialday14;
	}

	public void setSpecialday14(String specialday14) {
		this.specialday14 = specialday14;
	}

	@Column(name = "specialday15", length = 10)
	public String getSpecialday15() {
		return this.specialday15;
	}

	public void setSpecialday15(String specialday15) {
		this.specialday15 = specialday15;
	}

	@Column(name = "specialday16", length = 10)
	public String getSpecialday16() {
		return this.specialday16;
	}

	public void setSpecialday16(String specialday16) {
		this.specialday16 = specialday16;
	}

	@Column(name = "specialday17", length = 10)
	public String getSpecialday17() {
		return this.specialday17;
	}

	public void setSpecialday17(String specialday17) {
		this.specialday17 = specialday17;
	}

	@Column(name = "specialday18", length = 10)
	public String getSpecialday18() {
		return this.specialday18;
	}

	public void setSpecialday18(String specialday18) {
		this.specialday18 = specialday18;
	}

	@Column(name = "specialday19", length = 10)
	public String getSpecialday19() {
		return this.specialday19;
	}

	public void setSpecialday19(String specialday19) {
		this.specialday19 = specialday19;
	}

	@Column(name = "specialday20", length = 10)
	public String getSpecialday20() {
		return this.specialday20;
	}

	public void setSpecialday20(String specialday20) {
		this.specialday20 = specialday20;
	}

	@Column(name = "specialday21", length = 10)
	public String getSpecialday21() {
		return this.specialday21;
	}

	public void setSpecialday21(String specialday21) {
		this.specialday21 = specialday21;
	}

	@Column(name = "specialday22", length = 10)
	public String getSpecialday22() {
		return this.specialday22;
	}

	public void setSpecialday22(String specialday22) {
		this.specialday22 = specialday22;
	}

	@Column(name = "specialday23", length = 10)
	public String getSpecialday23() {
		return this.specialday23;
	}

	public void setSpecialday23(String specialday23) {
		this.specialday23 = specialday23;
	}

}