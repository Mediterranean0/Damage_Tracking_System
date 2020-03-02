/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hasar_takip_sistemi_odev_final;

/**
 *
 * @author veliakdeniz
 */
public interface Arac {
     public String[] getParcalar();
     public int getFiyat(String parca, String kalite);
     public Integer getAracId();    
     public String getModel();
     public String getAracTur();
     
}
