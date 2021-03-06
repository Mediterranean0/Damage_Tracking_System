/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hasar_takip_sistemi_odev_final;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author veliakdeniz
 */
public class musteriler extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel();

    /**
     * Creates new form musteriler
     */
    public musteriler() {
        initComponents();
        dtm.setColumnIdentifiers(new Object[]{"Id", "Adı", "Soyadı", "Borç"});
        setTablo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablo = new javax.swing.JTable();
        sil = new javax.swing.JButton();
        aktarMusteri = new javax.swing.JButton();
        datYaz = new javax.swing.JButton();
        datOku = new javax.swing.JButton();
        geri = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
        jScrollPane1.setViewportView(tablo);

        sil.setText("Müşteri Kaydını Sil");
        sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                silActionPerformed(evt);
            }
        });

        aktarMusteri.setText("Müşteri Listesini Text Dosyasına Aktar");
        aktarMusteri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aktarMusteriActionPerformed(evt);
            }
        });

        datYaz.setText("Müşteri  Listesini Dat Dosyasına Aktar");
        datYaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datYazActionPerformed(evt);
            }
        });

        datOku.setText("Müşteri Listesini Dat Dosyasından Oku");
        datOku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datOkuActionPerformed(evt);
            }
        });

        geri.setText("Geri Dön");
        geri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                geriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(datYaz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(geri)
                            .addComponent(aktarMusteri)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(datOku, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sil)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(sil))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(aktarMusteri)))
                .addGap(37, 37, 37)
                .addComponent(datYaz)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(datOku)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(geri)
                .addGap(0, 42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silActionPerformed
        if (tablo.getSelectedRow() == -1) {
            return;
        }
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("odev");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        int id = ((Musteri) tablo.getValueAt(tablo.getSelectedRow(), 1)).getId();
        Query q = em.createQuery("select m from Musteri m where m.id= " + id);
        List<Musteri> musteriler = q.getResultList();

        for (Musteri m : musteriler) {
            if (m.getBorc() == 0) {
                em.remove(m);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Müşteri kayıtlı borcu olduğu için sistemden silinemez", "Hata ", JOptionPane.WARNING_MESSAGE);

            }

        }
        em.getTransaction().commit();
        em.close();
        emf.close();
        setTablo();
    }//GEN-LAST:event_silActionPerformed

    private void aktarMusteriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aktarMusteriActionPerformed
        BufferedWriter br = null;

        int i = JOptionPane.showConfirmDialog(rootPane, "Kayıtlar dosyaya aktarılsın mı ? ?", "Emin misiniz ?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (i == 0) {
            try {
                String dosya = "/Users/veliakdeniz/Desktop/test/MusteriListe.txt";

                br = new BufferedWriter(new FileWriter(dosya));

                EntityManagerFactory emf = Persistence.createEntityManagerFactory("odev");
                EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();
                Query q = em.createQuery("select m from Musteri m");
                List<Musteri> musteriler = q.getResultList();

                for (Musteri m : musteriler) {
                    br.write("\n" + "\n" + "Müşteri Id : " + m.getId() + "   Adı : " + m.getAdi() + "    Soyadı : " + m.getSoyadi() + "    Borç : " + m.getBorc());
                }
                em.close();
                emf.close();
            } catch (IOException ex) {
                Logger.getLogger(borc.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(borc.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }


    }//GEN-LAST:event_aktarMusteriActionPerformed

    private void datOkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datOkuActionPerformed

        ObjectInputStream ois = null;
        try {
            String dosya = "/Users/veliakdeniz/Desktop/text/MusteriListe.dat";
            ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dosya)));
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("odev");
            EntityManager em = emf.createEntityManager();
            List <Musteri> musteriler = (List <Musteri>)ois.readObject();
            dtm.setRowCount(0);
            
            for (Musteri m : musteriler) {
                
                dtm.addRow(new Object[]{m.getId(),m,m.getSoyadi(),m.getBorc()});
                
            }
            

        } catch (FileNotFoundException ex) {
            Logger.getLogger(musteriler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(musteriler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(musteriler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ois.close();
            } catch (IOException ex) {
                Logger.getLogger(musteriler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_datOkuActionPerformed

    private void datYazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datYazActionPerformed
        ObjectOutputStream oos = null;
        try {
            String dosya = "/Users/veliakdeniz/Desktop/text/MusteriListe.dat";
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(dosya)));
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("odev");
            EntityManager em = emf.createEntityManager();
            Query q = em.createQuery("select m from Musteri m");

            oos.writeObject(q.getResultList());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(musteriler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(musteriler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                oos.close();
            } catch (IOException ex) {
                Logger.getLogger(musteriler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_datYazActionPerformed

    private void geriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_geriActionPerformed
      setTablo();
    }//GEN-LAST:event_geriActionPerformed

    public void setTablo() {

        dtm.setRowCount(0);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("odev");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("select m from Musteri m ");
        List<Musteri> musteriler = q.getResultList();

        for (Musteri m : musteriler) {
            dtm.addRow(new Object[]{m.getId(), m, m.getSoyadi(), m.getBorc()});
        }
        tablo.setModel(dtm);
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
            java.util.logging.Logger.getLogger(musteriler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(musteriler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(musteriler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(musteriler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new musteriler().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aktarMusteri;
    private javax.swing.JButton datOku;
    private javax.swing.JButton datYaz;
    private javax.swing.JButton geri;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton sil;
    private javax.swing.JTable tablo;
    // End of variables declaration//GEN-END:variables
}
