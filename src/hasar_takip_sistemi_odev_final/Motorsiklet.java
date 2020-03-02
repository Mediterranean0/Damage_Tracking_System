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
@Table(name = "MOTORSIKLET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Motorsiklet.findAll", query = "SELECT m FROM Motorsiklet m")
    , @NamedQuery(name = "Motorsiklet.findByAracId", query = "SELECT m FROM Motorsiklet m WHERE m.aracId = :aracId")
    , @NamedQuery(name = "Motorsiklet.findByMusteriId", query = "SELECT m FROM Motorsiklet m WHERE m.musteriId = :musteriId")
    , @NamedQuery(name = "Motorsiklet.findByModel", query = "SELECT m FROM Motorsiklet m WHERE m.model = :model")
    , @NamedQuery(name = "Motorsiklet.findByTarih", query = "SELECT m FROM Motorsiklet m WHERE m.tarih = :tarih")})
public class Motorsiklet implements Serializable ,Arac{

    @javax.persistence.Transient
    private int onCamO = 700;
    @javax.persistence.Transient
    private int lastiklerO = 700;
    @javax.persistence.Transient
    private int farO = 400;
    @javax.persistence.Transient
    private int camurlukO = 300;
    @javax.persistence.Transient
    private int suspansiyonO = 2400;

    @javax.persistence.Transient
    private int onCamY = 500;
    @javax.persistence.Transient
    private int lastiklerY = 400;
    @javax.persistence.Transient
    private int farY = 200;
    @javax.persistence.Transient
    private int camurlukY = 100;
    @javax.persistence.Transient
    private int suspansiyonY = 1000;

    public String[] getParcalar() {
        String p[] = new String[5];
        p[0] = "Ön Cam";
        p[1] = "Farlar";
        p[2] = "Lastikler";
        p[3] = "Çamurluk";
        p[4] = "Süspansiyon";

        return p;
    }

    public int getFiyat(String parca, String kalite) {
        int fiyat = 0;
        if (kalite.equals("Orjinal")) {
            if (parca.equals("Ön Cam")) {
                fiyat = onCamO;
            } else if (parca.equals("Farlar")) {
                fiyat = farO;
            } else if (parca.equals("Lastikler")) {
                fiyat = lastiklerO;
            } else if (parca.equals("Çamurluk")) {
                fiyat = camurlukO;
            } else if (parca.equals("Süspansiyon")) {
                fiyat = suspansiyonO;
            }

        } else {

            if (parca.equals("Ön Cam")) {
                fiyat = onCamY;
            } else if (parca.equals("Farlar")) {
                fiyat = farY;
            } else if (parca.equals("Lastikler")) {
                fiyat = lastiklerY;
            } else if (parca.equals("Çamurluk")) {
                fiyat = camurlukY;
            } else if (parca.equals("Süspansiyon")) {
                fiyat = suspansiyonY;
            }

        }

        return fiyat;
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

    public Motorsiklet() {
        
    }
    
    public String getAracTur() {
        return "Motorsiklet";

    }

    public Motorsiklet(Integer aracId) {
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
        if (!(object instanceof Motorsiklet)) {
            return false;
        }
        Motorsiklet other = (Motorsiklet) object;
        if ((this.aracId == null && other.aracId != null) || (this.aracId != null && !this.aracId.equals(other.aracId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getAracId() + " Motorsiklet " + getModel();
    }

}
