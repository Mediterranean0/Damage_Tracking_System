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
@Table(name = "ARABA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Araba.findAll", query = "SELECT a FROM Araba a")
    , @NamedQuery(name = "Araba.findByAracId", query = "SELECT a FROM Araba a WHERE a.aracId = :aracId")
    , @NamedQuery(name = "Araba.findByMusteriId", query = "SELECT a FROM Araba a WHERE a.musteriId = :musteriId")
    , @NamedQuery(name = "Araba.findByModel", query = "SELECT a FROM Araba a WHERE a.model = :model")
    , @NamedQuery(name = "Araba.findByTarih", query = "SELECT a FROM Araba a WHERE a.tarih = :tarih")})
public class Araba implements Serializable, Arac {

    @javax.persistence.Transient
    private int onCamO = 2000;
    @javax.persistence.Transient
    private int lastiklerO = 900;
    @javax.persistence.Transient
    private int farO = 600;
    @javax.persistence.Transient
    private int arkaCamO = 1500;
    @javax.persistence.Transient
    private int kapılarO = 3400;

    @javax.persistence.Transient
    private int onCamY = 1000;
    @javax.persistence.Transient
    private int lastiklerY = 600;
    @javax.persistence.Transient
    private int farY = 300;
    @javax.persistence.Transient
    private int arkaCamY = 750;
    @javax.persistence.Transient
    private int kapılarY = 2900;

    public int getFiyat(String parca, String kalite) {
        int fiyat = 0;
        if (kalite.equals("Orjinal")) {
            if (parca.equals("Ön Cam")) {
                fiyat = onCamO;
            } else if (parca.equals("Farlar")) {
                fiyat = farO;
            } else if (parca.equals("Lastikler")) {
                fiyat = lastiklerO;
            } else if (parca.equals("Arka Cam")) {
                fiyat = arkaCamO;
            } else if (parca.equals("Kapılar")) {
                fiyat = kapılarO;
            }

        } else {

            if (parca.equals("Ön Cam")) {
                fiyat = onCamY;
            } else if (parca.equals("Farlar")) {
                fiyat = farY;
            } else if (parca.equals("Lastikler")) {
                fiyat = lastiklerY;
            } else if (parca.equals("Arka Cam")) {
                fiyat = arkaCamY;
            } else if (parca.equals("Kapılar")) {
                fiyat = kapılarY;
            }

        }

        return fiyat;
    }

    public String getAracTur() {
        return "Araba";

    }

    public String[] getParcalar() {
        String p[] = new String[5];
        p[0] = "Ön Cam";
        p[1] = "Arka Cam";
        p[2] = "Lastikler";
        p[3] = "Farlar";
        p[4] = "Kapılar";
        return p;
    }
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ARAC_ID")
    private Integer aracId;
    @Column(name = "MUSTERI_ID")
    private Integer musteriId;
    @Column(name = "MODEL")
    private String model;
    @Column(name = "TARIH")
    @Temporal(TemporalType.DATE)
    private Date tarih;

    public Araba() {
    }

    public Araba(Integer aracId) {
        this.aracId = aracId;
    }

    public Integer getAracId() {
        return aracId;
    }

    public void setAracId(Integer aracId) {
        this.aracId = aracId;
    }

    public Integer getMusteriId() {
        return musteriId;
    }

    public void setMusteriId(Integer musteriId) {
        this.musteriId = musteriId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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
        hash += (aracId != null ? aracId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Araba)) {
            return false;
        }
        Araba other = (Araba) object;
        if ((this.aracId == null && other.aracId != null) || (this.aracId != null && !this.aracId.equals(other.aracId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getAracId() + " Araba " + getModel();
    }
    
    
     

}
