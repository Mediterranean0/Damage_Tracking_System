/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hasar_takip_sistemi_odev_final;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author veliakdeniz
 */
public class hasarEkleme extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel();
    DefaultListModel dlm = new DefaultListModel();
    DefaultListModel dlmP = new DefaultListModel();
    Date d = new Date(System.currentTimeMillis());

    /**
     * Creates new form hasarEkleme
     */
    public hasarEkleme() {
        initComponents();

        setTablo();
        pack();

        dlm.clear();
        aracList.setModel(dlm);
        dlmP.clear();
        parcalar.setModel(dlmP);
        orjinal.setSelected(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        odevEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("odev").createEntityManager();
        musteriQuery = java.beans.Beans.isDesignTime() ? null : odevEntityManager.createQuery("SELECT m FROM Musteri m");
        musteriList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : musteriQuery.getResultList();
        musteriQuery1 = java.beans.Beans.isDesignTime() ? null : odevEntityManager.createQuery("SELECT m FROM Musteri m");
        musteriList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : musteriQuery1.getResultList();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablo = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        aracList = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        yansanayi = new javax.swing.JRadioButton();
        orjinal = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        parcalar = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        hasar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        fiyat = new javax.swing.JLabel();
        sil = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Müşteriler");

        tablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabloMouseClicked(evt);
            }
        });
        tablo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tabloPropertyChange(evt);
            }
        });
        tablo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabloKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tablo);

        aracList.setModel(new javax.swing.AbstractListModel<Object>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        aracList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aracListMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(aracList);

        jLabel2.setText("Seçilen Müşterinin Araçları:");

        yansanayi.setText("Yan Sanayi");
        yansanayi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                yansanayiİtemStateChanged(evt);
            }
        });
        yansanayi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yansanayiActionPerformed(evt);
            }
        });
        yansanayi.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                yansanayiPropertyChange(evt);
            }
        });

        orjinal.setText("Orjinal");
        orjinal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                orjinalİtemStateChanged(evt);
            }
        });
        orjinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orjinalActionPerformed(evt);
            }
        });
        orjinal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                orjinalPropertyChange(evt);
            }
        });

        jLabel3.setText("Parça Kalitesini Seçiniz :");

        parcalar.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        parcalar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                parcalarMouseClicked(evt);
            }
        });
        parcalar.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                parcalarValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(parcalar);

        jLabel4.setText("Onarılacak Parçayı Seçiniz:");

        hasar.setText("Hasar Oluştur");
        hasar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hasarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel5.setText("Fiyat :");

        fiyat.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N

        sil.setText("Aracı Sil");
        sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                silActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(yansanayi)
                            .addComponent(orjinal)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel3)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(hasar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(fiyat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(sil)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(yansanayi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(orjinal))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sil)
                        .addContainerGap(30, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(fiyat, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hasar)
                        .addGap(102, 102, 102))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aracListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aracListMouseClicked
        dlmP.clear();
        String parcalar[] = ((Arac) dlm.getElementAt(aracList.getSelectedIndex())).getParcalar();
        for (String p : parcalar) {
            dlmP.addElement(p);

        }


    }//GEN-LAST:event_aracListMouseClicked

    private String getRadio() {
        String txt;
        if (orjinal.isSelected()) {
            txt = orjinal.getText();
        } else {
            txt = yansanayi.getText();

        }
        return txt;
    }

    ;
    private void yansanayiİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_yansanayiİtemStateChanged

    }//GEN-LAST:event_yansanayiİtemStateChanged

    private void orjinalİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_orjinalİtemStateChanged


    }//GEN-LAST:event_orjinalİtemStateChanged

    private void yansanayiPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_yansanayiPropertyChange

    }//GEN-LAST:event_yansanayiPropertyChange

    private void orjinalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_orjinalPropertyChange

    }//GEN-LAST:event_orjinalPropertyChange

    private void yansanayiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yansanayiActionPerformed
        orjinal.setSelected(false);
    }//GEN-LAST:event_yansanayiActionPerformed

    private void hasarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hasarActionPerformed
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("odev");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        if (tablo.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen Tablodan Bir Müşteri seçiniz", "Hata", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (aracList.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen Araç Listesinden Bir Araç seçiniz", "Hata", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (parcalar.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen Parçalar Listesinden Bir Parça seçiniz", "Hata", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Random r = new Random();
        Query q = em.createQuery("select h from Hasarkayit h");
        List<Hasarkayit> kayitlar = q.getResultList();

        int hasarId = 0;
        boolean b = true;
        while (true) {
            b = true;
            int c = r.nextInt(10000);
            for (Hasarkayit h : kayitlar) {
                if (h.getHasarid() == c) {
                    b = false;
                }
            }
            if (b == true) {
                hasarId = c;
                break;
            }

        }

        int musteriId = ((Musteri) tablo.getValueAt(tablo.getSelectedRow(), 1)).getId();
        int aracId = ((Arac) dlm.getElementAt(aracList.getSelectedIndex())).getAracId();
        String aracTuru = ((Arac) dlm.getElementAt(aracList.getSelectedIndex())).getAracTur();
        String aracModel = ((Arac) dlm.getElementAt(aracList.getSelectedIndex())).getModel();
        String parca = parcalar.getSelectedValue();
        String kalite = getRadio();
        int fiyat = ((Arac) dlm.getElementAt(aracList.getSelectedIndex())).getFiyat(parca, kalite);

        Hasarkayit h = new Hasarkayit();
        h.setHasarid(hasarId);
        h.setAracId(aracId);
        h.setMusteriId(musteriId);
        h.setAracTuru(aracTuru);
        h.setAracModel(aracModel);
        h.setParca(parca);
        h.setKalite(kalite);
        h.setFiyat(fiyat);
        h.setTarih(d);

        em.persist(h);

        int borc = ((Musteri) tablo.getValueAt(tablo.getSelectedRow(), 1)).getBorc();
        Query q1 = em.createQuery("select m from Musteri m where m.id= " + musteriId);
        List<Musteri> m = q1.getResultList();
        for (Musteri musteri : m) {
            musteri.setBorc(borc + fiyat);
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
        setTablo();


    }//GEN-LAST:event_hasarActionPerformed

    private void orjinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orjinalActionPerformed
        yansanayi.setSelected(false);
    }//GEN-LAST:event_orjinalActionPerformed

    private void parcalarValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_parcalarValueChanged

    }//GEN-LAST:event_parcalarValueChanged

    private void parcalarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parcalarMouseClicked
        String parca = parcalar.getSelectedValue();
        String kalite = getRadio();
        fiyat.setText(((Arac) dlm.getElementAt(aracList.getSelectedIndex())).getFiyat(parca, kalite) + "");
    }//GEN-LAST:event_parcalarMouseClicked

    private void tabloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabloKeyPressed

    }//GEN-LAST:event_tabloKeyPressed

    private void tabloPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tabloPropertyChange

    }//GEN-LAST:event_tabloPropertyChange

    private void tabloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabloMouseClicked
        dlm.clear();
        int i = ((Musteri) tablo.getValueAt(tablo.getSelectedRow(), 1)).getId();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("odev");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query qa = em.createQuery("select a from Araba a where a.musteriId= " + i);
        List<Araba> a = qa.getResultList();

        Query qk = em.createQuery("select a from Kamyon a where a.musteriId= " + i);
        List<Kamyon> k = qk.getResultList();

        Query qm = em.createQuery("select a from Motorsiklet a where a.musteriId= " + i);
        List<Motorsiklet> m = qm.getResultList();

        for (Araba araba : a) {
            dlm.addElement(araba);
        }
        for (Kamyon kamyon : k) {
            dlm.addElement(kamyon);
        }
        for (Motorsiklet motorsiklet : m) {
            dlm.addElement(motorsiklet);
        }
        aracList.setModel(dlm);
        em.close();
        emf.close();
    }//GEN-LAST:event_tabloMouseClicked

    private void silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silActionPerformed
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("odev");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        int i = ((Arac) dlm.getElementAt(aracList.getSelectedIndex())).getAracId();
        Query qa = em.createQuery("select a from Araba a where a.aracId =" + i);
        List<Araba> a = qa.getResultList();

        Query qk = em.createQuery("select a from Kamyon a where a.aracId =" + i);
        List<Kamyon> k = qk.getResultList();

        Query qm = em.createQuery("select a from Motorsiklet a where a.aracId =" + i);
        List<Motorsiklet> m = qm.getResultList();

        for (Araba araba : a) {
            em.remove(araba);
        }
        for (Kamyon kamyon : k) {
            em.remove(kamyon);
        }
        for (Motorsiklet motorsiklet : m) {
            em.remove(motorsiklet);
        }

        dlm.removeElementAt(aracList.getSelectedIndex());

        em.getTransaction().commit();

        em.close();
        emf.close();
    }//GEN-LAST:event_silActionPerformed

    public void setTablo() {

        dtm.setRowCount(0);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("odev");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        String sql = "select m from Musteri m";
        Query q = em.createQuery(sql);
        dtm.setColumnIdentifiers(new Object[]{"Id", "Adı", "Soyadı", "Borc"});
        List<Musteri> musteriler = q.getResultList();
        for (Musteri m : musteriler) {
            dtm.addRow(new Object[]{m.getId(), m, m.getSoyadi(), m.getBorc()});
        }

        tablo.setModel(dtm);
        em.close();
        emf.close();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(hasarEkleme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(hasarEkleme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(hasarEkleme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(hasarEkleme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new hasarEkleme().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<Object> aracList;
    private javax.swing.JLabel fiyat;
    private javax.swing.JButton hasar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private java.util.List<hasar_takip_sistemi_odev_final.Musteri> musteriList;
    private java.util.List<hasar_takip_sistemi_odev_final.Musteri> musteriList1;
    private javax.persistence.Query musteriQuery;
    private javax.persistence.Query musteriQuery1;
    private javax.persistence.EntityManager odevEntityManager;
    private javax.swing.JRadioButton orjinal;
    private javax.swing.JList<String> parcalar;
    private javax.swing.JButton sil;
    private javax.swing.JTable tablo;
    private javax.swing.JRadioButton yansanayi;
    // End of variables declaration//GEN-END:variables
}