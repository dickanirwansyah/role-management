/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arms.app.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bariskreatif
 */
@Entity
@Table(name = "REQUEST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Request.findAll", query = "SELECT r FROM Request r"),
    @NamedQuery(name = "Request.findById", query = "SELECT r FROM Request r WHERE r.id = :id"),
    @NamedQuery(name = "Request.findByKtp", query = "SELECT r FROM Request r WHERE r.ktp = :ktp"),
    @NamedQuery(name = "Request.findByNama", query = "SELECT r FROM Request r WHERE r.nama = :nama"),
    @NamedQuery(name = "Request.findByTtl", query = "SELECT r FROM Request r WHERE r.ttl = :ttl"),
    @NamedQuery(name = "Request.findByJk", query = "SELECT r FROM Request r WHERE r.jk = :jk"),
    @NamedQuery(name = "Request.findByBlood", query = "SELECT r FROM Request r WHERE r.blood = :blood"),
    @NamedQuery(name = "Request.findByAlamat", query = "SELECT r FROM Request r WHERE r.alamat = :alamat"),
    @NamedQuery(name = "Request.findByCountry", query = "SELECT r FROM Request r WHERE r.country = :country"),
    @NamedQuery(name = "Request.findByJob", query = "SELECT r FROM Request r WHERE r.job = :job"),
    @NamedQuery(name = "Request.findByReligion", query = "SELECT r FROM Request r WHERE r.religion = :religion"),
    @NamedQuery(name = "Request.findByStatus", query = "SELECT r FROM Request r WHERE r.status = :status"),
    @NamedQuery(name = "Request.findByCitizen", query = "SELECT r FROM Request r WHERE r.citizen = :citizen"),
    @NamedQuery(name = "Request.findByTgl", query = "SELECT r FROM Request r WHERE r.tgl = :tgl")})
public class Request implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ID")
    private String id;
    @Size(max = 300)
    @Column(name = "KTP")
    private String ktp;
    @Size(max = 300)
    @Column(name = "NAMA")
    private String nama;
    @Size(max = 300)
    @Column(name = "TTL")
    private String ttl;
    @Size(max = 10)
    @Column(name = "JK")
    private String jk;
    @Size(max = 10)
    @Column(name = "BLOOD")
    private String blood;
    @Size(max = 500)
    @Column(name = "ALAMAT")
    private String alamat;
    @Size(max = 250)
    @Column(name = "COUNTRY")
    private String country;
    @Size(max = 250)
    @Column(name = "JOB")
    private String job;
    @Size(max = 250)
    @Column(name = "RELIGION")
    private String religion;
    @Size(max = 250)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 250)
    @Column(name = "CITIZEN")
    private String citizen;
    @Column(name = "TGL")
    @Temporal(TemporalType.DATE)
    private Date tgl;
    @Column(name = "SIGNATURE")
    private Boolean signature;
         
    public Request() {
    }

    public Request(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKtp() {
        return ktp;
    }

    public void setKtp(String ktp) {
        this.ktp = ktp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCitizen() {
        return citizen;
    }

    public void setCitizen(String citizen) {
        this.citizen = citizen;
    }

    public Date getTgl() {
        return tgl;
    }

    public void setTgl(Date tgl) {
        this.tgl = tgl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Request)) {
            return false;
        }
        Request other = (Request) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.service.app.entity.Request[ id=" + id + " ]";
    }

    /**
     * @return the signature
     */
    public Boolean getSignature() {
        return signature;
    }

    /**
     * @param signature the signature to set
     */
    public void setSignature(Boolean signature) {
        this.signature = signature;
    }
    
}
