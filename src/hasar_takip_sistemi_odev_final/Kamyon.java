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
@Table(name = "KAMYON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kamyon.findAll", query = "SELECT k FROM Kamyon k")
    , @NamedQuery(name = "Kamyon.findByAracId", query = "SELECT k FROM Kamyon k WHERE k.aracId = :aracId")
    , @NamedQuery(name = "Kamyon.findByModel", query = "SELECT k FROM Kamyon k WHERE k.model = :model")
    , @NamedQuery(name = "Kamyon.findByTarih", query = "SELECT k FROM Kamyon k WHERE k.tarih = :tarih")
    , @NamedQuery(name = "Kamyon.findByMusteriId", query = "SELECT k FROM Kamyon k WHERE k.musteriId = :musteriId")})
public class Kamyon implements Serializable ,Arac{
@javax.persistence.Transient 
    private int onCamO = 5000;
@javax.persistence.Transient 
    private int lastiklerO = 4500;
@javax.persistence.Transient 
    private int farO = 800;
@javax.persistence.Transient 
    private int arkaCamO = 700;
@javax.persistence.Transient 
    private int kapılarO = 400;
@javax.persistence.Transient 
     private int dorseO = 10000;
     
     
@javax.persistence.Transient 
   private  int onCamY = 3000;
@javax.persistence.Transient 
    private int lastiklerY = 2200;
@javax.persistence.Transient 
    private int farY = 500;
@javax.persistence.Transient 
    private int arkaCamY = 330;
@javax.persistence.Transient 
    private int kapılarY = 260;
    @javax.persistence.Transient 
    private int dorseY = 7000;

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
            } else if (parca.equals("Dorse")) {
                fiyat = dorseO;
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
            } else if (parca.equals("Dorse")) {
                fiyat = dorseY;
            }

        }

        return fiyat;
    }
    
    public String getAracTur() {
        return "Kamyon";

    }

    public String[] getParcalar() {
        String p[] = new String[6];
        p[0] = "Ön Cam";
        p[1] = "Arka Cam";
        p[2] = "Lastikler";
        p[3] = "Farlar";
        p[4] = "Kapılar";
        p[5] = "Dorse";
        return p;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ARAC_ID")
    private Integer aracId;
    @Column(name = "MODEL")
    private String model;
    @Column(name = "TARIH")
    @Temporal(TemporalType.DATE)
    private Date tarih;
    @Column(name = "MUSTERI_ID")
    private Integer musteriId;

    public Kamyon() {
    }

    public Kamyon(Integer aracId) {
        this.aracId = aracId;
    }

    public Integer getAracId() {
        return aracId;
    }

    public void setAracId(Integer aracId) {
        this.aracId = aracId;
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

    public Integer getMusteriId() {
        return musteriId;
    }

    public void setMusteriId(Integer musteriId) {
        this.musteriId = musteriId;
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
        if (!(object instanceof Kamyon)) {
            return false;
        }
        Kamyon other = (Kamyon) object;
        if ((this.aracId == null && other.aracId != null) || (this.aracId != null && !this.aracId.equals(other.aracId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getAracId() + " Kamyon " + getModel();
    }

}
