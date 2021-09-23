package Vista;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;

/* @author Diego Vásquez*/

public class Main extends javax.swing.JFrame {

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
        JMenuBancos = new javax.swing.JMenu();
        JMenuNominas = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modulo de Finanzas");

        JDesktopMain.setBackground(new java.awt.Color(15, 60, 75));

        javax.swing.GroupLayout JDesktopMainLayout = new javax.swing.GroupLayout(JDesktopMain);
        JDesktopMain.setLayout(JDesktopMainLayout);
        JDesktopMainLayout.setHorizontalGroup(
            JDesktopMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        JDesktopMainLayout.setVerticalGroup(
            JDesktopMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 622, Short.MAX_VALUE)
        );

        JMenuArchivo.setText("Archivo");
        JMenuArchivo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JMenuBarMain.add(JMenuArchivo);

        JMenuConta.setText("Contabilidad");
        JMenuConta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JMenuBarMain.add(JMenuConta);

        JMenuBancos.setText("Bancos");
        JMenuBancos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JMenuBarMain.add(JMenuBancos);

        JMenuNominas.setText("Nóminas");
        JMenuNominas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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
    // End of variables declaration//GEN-END:variables
}
