package com.jlj.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	private Set<Sigordinarytime> sigordinarytimes = new HashSet<Sigordinarytime>(
			0);
	private Set<Sigspecialtime> sigspecialtimes = new HashSet<Sigspecialtime>(0);
	private Set<Sigsuntime> sigsuntimes = new HashSet<Sigsuntime>(0);

	// Constructors

	/** default constructor */
	public Signpublicparam() {
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
			String gateway, Set<Sigordinarytime> sigordinarytimes,
			Set<Sigspecialtime> sigspecialtimes, Set<Sigsuntime> sigsuntimes) {
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
		this.sigordinarytimes = sigordinarytimes;
		this.sigspecialtimes = sigspecialtimes;
		this.sigsuntimes = sigsuntimes;
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

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "signid")
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "signpublicparam")
	public Set<Sigordinarytime> getSigordinarytimes() {
		return this.sigordinarytimes;
	}

	public void setSigordinarytimes(Set<Sigordinarytime> sigordinarytimes) {
		this.sigordinarytimes = sigordinarytimes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "signpublicparam")
	public Set<Sigspecialtime> getSigspecialtimes() {
		return this.sigspecialtimes;
	}

	public void setSigspecialtimes(Set<Sigspecialtime> sigspecialtimes) {
		this.sigspecialtimes = sigspecialtimes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "signpublicparam")
	public Set<Sigsuntime> getSigsuntimes() {
		return this.sigsuntimes;
	}

	public void setSigsuntimes(Set<Sigsuntime> sigsuntimes) {
		this.sigsuntimes = sigsuntimes;
	}

}