/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.eclipse.formatter.customizer;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.prefs.Preferences;
import javax.swing.event.ChangeListener;
import org.netbeans.eclipse.formatter.options.EclipseFormatterPanel;


public class ProjectSpecificSettingsPanel extends javax.swing.JPanel implements VerifiableConfigPanel {

    private final Preferences projectPreferences;
    private final EclipseFormatterPanel innerComponent;
    public static final String USE_PROJECT_SETTINGS = "useProjectSettings";

    ProjectSpecificSettingsPanel(EclipseFormatterPanel innerComponent, Preferences projectPreferences) {
        initComponents();
        this.innerComponent = innerComponent;
        this.projectPreferences = projectPreferences;

        innerPanel.setLayout(new BorderLayout());
        innerPanel.add(this.innerComponent, BorderLayout.CENTER);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbOverrideGlobalSettings = new javax.swing.JCheckBox();
        innerPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        org.openide.awt.Mnemonics.setLocalizedText(cbOverrideGlobalSettings, org.openide.util.NbBundle.getMessage(ProjectSpecificSettingsPanel.class, "ProjectSpecificSettingsPanel.cbOverrideGlobalSettings.text")); // NOI18N
        cbOverrideGlobalSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbOverrideGlobalSettingsActionPerformed(evt);
            }
        });
        add(cbOverrideGlobalSettings, java.awt.BorderLayout.PAGE_START);
        add(innerPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void cbOverrideGlobalSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOverrideGlobalSettingsActionPerformed
        innerPanel.setVisible(cbOverrideGlobalSettings.isSelected());
        fireChangedListener();
    }//GEN-LAST:event_cbOverrideGlobalSettingsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbOverrideGlobalSettings;
    private javax.swing.JPanel innerPanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void load() {
        boolean useProjectSettings = projectPreferences.getBoolean(USE_PROJECT_SETTINGS, false);
        cbOverrideGlobalSettings.setSelected(useProjectSettings);
        innerPanel.setVisible(useProjectSettings);
    }

    @Override
    public void store() {
        projectPreferences.putBoolean(USE_PROJECT_SETTINGS, cbOverrideGlobalSettings.isSelected());
    }

    private transient final Collection<ChangeListener> changeListeners = new ArrayList<ChangeListener>();

    public void addChangeListener(ChangeListener listener) {
        changeListeners.add(listener);
    }

    private void fireChangedListener() {
        for (ChangeListener changeListener : changeListeners) {
            changeListener.stateChanged(null);
        }
    }

    @Override
    public boolean holdsValidConfig() {
        boolean result = true;
        if (cbOverrideGlobalSettings.isSelected()) {
            return innerComponent.holdsValidConfig();
        }
        return result;
    }

}
