/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hasar_takip_sistemi_odev_final;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author veliakdeniz
 */
@Entity
@Table(name = "HASARKAYIT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hasarkayit.findAll", query = "SELECT h FROM Hasarkayit h")
    , @NamedQuery(name = "Hasarkayit.findByHasarid", query = "SELECT h FROM Hasarkayit h WHERE h.hasarid = :hasarid")
    , @NamedQuery(name = "Hasarkayit.findByMusteriId", query = "SELECT h FROM Hasarkayit h WHERE h.musteriId = :musteriId")
    , @NamedQuery(name = "Hasarkayit.findByAracId", query = "SELECT h FROM Hasarkayit h WHERE h.aracId = :aracId")
    , @NamedQuery(name = "Hasarkayit.findByAracTuru", query = "SELECT h FROM Hasarkayit h WHERE h.aracTuru = :aracTuru")
    , @NamedQuery(name = "Hasarkayit.findByAracModel", query = "SELECT h FROM Hasarkayit h WHERE h.aracModel = :aracModel")
    , @NamedQuery(name = "Hasarkayit.findByParca", query = "SELECT h FROM Hasarkayit h WHERE h.parca = :parca")
    , @NamedQuery(name = "Hasarkayit.findByKalite", query = "SELECT h FROM Hasarkayit h WHERE h.kalite = :kalite")
    , @NamedQuery(name = "Hasarkayit.findByFiyat", query = "SELECT h FROM Hasarkayit h WHERE h.fiyat = :fiyat")
    , @NamedQuery(name = "Hasarkayit.findByTarih", query = "SELECT h FROM Hasarkayit h WHERE h.tarih = :tarih")})
public class Hasarkayit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "HASARID")
    private Integer hasarid;
    @Column(name = "MUSTERI_ID")
    private Integer musteriId;
    @Column(name = "ARAC_ID")
    private Integer aracId;
    @Column(name = "ARAC_TURU")
    private String aracTuru;
    @Column(name = "ARAC_MODEL")
    private String aracModel;
    @Column(name = "PARCA")
    private String parca;
    @Column(name = "KALITE")
    private String kalite;
    @Column(name = "FIYAT")
    private Integer fiyat;
    @Column(name = "TARIH")
    @Temporal(TemporalType.DATE)
    private Date tarih;

    public Hasarkayit() {
    }

    public Hasarkayit(Integer hasarid) {
        this.hasarid = hasarid;
    }

    public Integer getHasarid() {
        return hasarid;
    }

    public void setHasarid(Integer hasarid) {
        this.hasarid = hasarid;
    }

    public Integer getMusteriId() {
        return musteriId;
    }

    public void setMusteriId(Integer musteriId) {
        this.musteriId = musteriId;
    }

    public Integer getAracId() {
        return aracId;
    }

    public void setAracId(Integer aracId) {
        this.aracId = aracId;
    }

    public String getAracTuru() {
        return aracTuru;
    }

    public void setAracTuru(String aracTuru) {
        this.aracTuru = aracTuru;
    }

    public String getAracModel() {
        return aracModel;
    }

    public void setAracModel(String aracModel) {
        this.aracModel = aracModel;
    }

    public String getParca() {
        return parca;
    }

    public void setParca(String parca) {
        this.parca = parca;
    }

    public String getKalite() {
        return kalite;
    }

    public void setKalite(String kalite) {
        this.kalite = kalite;
    }

    public Integer getFiyat() {
        return fiyat;
    }

    public void setFiyat(Integer fiyat) {
        this.fiyat = fiyat;
    }

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hasarid != null ? hasarid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hasarkayit)) {
            return false;
        }
        Hasarkayit other = (Hasarkayit) object;
        if ((this.hasarid == null && other.hasarid != null) || (this.hasarid != null && !this.hasarid.equals(other.hasarid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getParca();
    }
    
}
