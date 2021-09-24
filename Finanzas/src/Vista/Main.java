package Vista;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;

/* @author Diego Vásquez*/

public class Main extends javax.swing.JFrame {
 private MntDivisa formMantenimiento_Moneda;
    public Main() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JDesktopMain = new javax.swing.JDesktopPane();
        JMenuBarMain = new javax.swing.JMenuBar();
        JMenuArchivo = new javax.swing.JMenu();
        JMenuConta = new javax.swing.JMenu();
        Menu_MantCT = new javax.swing.JMenuItem();
        JMenuBancos = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        JMenuNominas = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modulo de Finanzas");

        javax.swing.GroupLayout JDesktopMainLayout = new javax.swing.GroupLayout(JDesktopMain);
        JDesktopMain.setLayout(JDesktopMainLayout);
        JDesktopMainLayout.setHorizontalGroup(
            JDesktopMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        JDesktopMainLayout.setVerticalGroup(
            JDesktopMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 626, Short.MAX_VALUE)
        );

        JMenuArchivo.setText("Archivo");
        JMenuBarMain.add(JMenuArchivo);

        JMenuConta.setText("Contabilidad");

        Menu_MantCT.setText("Mantenimientos");
        Menu_MantCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_MantCTActionPerformed(evt);
            }
        });
        JMenuConta.add(Menu_MantCT);

        JMenuBarMain.add(JMenuConta);

        JMenuBancos.setText("Bancos");

        jMenuItem1.setText("DIVISAS");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        JMenuBancos.add(jMenuItem1);

        JMenuBarMain.add(JMenuBancos);

        JMenuNominas.setText("Nóminas");

        jMenu1.setText("Mantenimientos");

        jMenuItem2.setText("Mantenimiento Empleados");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        JMenuNominas.add(jMenu1);

        JMenuBarMain.add(JMenuNominas);

        setJMenuBar(JMenuBarMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JDesktopMain)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JDesktopMain)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
               formMantenimiento_Moneda = new MntDivisa();
        JDesktopMain.add(formMantenimiento_Moneda);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void Menu_MantCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_MantCTActionPerformed
        Mantenimientos_Contabilidad mantenimientosContabilidad = new Mantenimientos_Contabilidad();
        mantenimientosContabilidad.setVisible(true);
        JDesktopMain.add(mantenimientosContabilidad);
    }//GEN-LAST:event_Menu_MantCTActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Mantenimiento_Empleados mantenimientoEmpleados = new Mantenimiento_Empleados();
        mantenimientoEmpleados.setVisible(true);
        JDesktopMain.add(mantenimientoEmpleados);
    }//GEN-LAST:event_jMenuItem2ActionPerformed


    public static void main(String args[]) {
        
         try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane JDesktopMain;
    private javax.swing.JMenu JMenuArchivo;
    private javax.swing.JMenu JMenuBancos;
    private javax.swing.JMenuBar JMenuBarMain;
    private javax.swing.JMenu JMenuConta;
    private javax.swing.JMenu JMenuNominas;
    private javax.swing.JMenuItem Menu_MantCT;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    // End of variables declaration//GEN-END:variables
}
