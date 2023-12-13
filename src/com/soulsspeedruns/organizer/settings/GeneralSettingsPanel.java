package com.soulsspeedruns.organizer.settings;


import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import com.soulsspeedruns.organizer.data.OrganizerManager;


/**
 * GeneralSettingsPanel
 * <p>
 * Contains general settings for the user to change.
 *
 * @author Kahmul (www.twitch.tv/kahmul78)
 * @date 3 Jun 2016
 */
public class GeneralSettingsPanel extends JPanel
{

	private static final long serialVersionUID = -7722457804075174686L;

	private JCheckBox alwaysOnTopCheckBox;
	private JCheckBox hotkeysCheckbox;
	private JCheckBox doubleClickLoadCheckbox;


	/**
	 * Creates a new general settings panel.
	 */
	protected GeneralSettingsPanel()
	{
		GroupLayout layout = new GroupLayout(this);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		Component glue = Box.createHorizontalGlue();

		JLabel alwaysOnTopLabel = new JLabel("Always On Top:");
		alwaysOnTopCheckBox = new JCheckBox("", OrganizerManager.isAlwaysOnTop());

		JLabel hotkeysLabel = new JLabel("Global Hotkeys:");
		hotkeysCheckbox = new JCheckBox("", OrganizerManager.areGlobalHotkeysEnabled());
		
		JLabel doubleClickLoadLabel = new JLabel("Double Click To Load Savefile:");
		doubleClickLoadCheckbox = new JCheckBox("", OrganizerManager.isDoubleClickLoadEnabled());

		// Horizontal
		GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

		hGroup.addGroup(layout.createParallelGroup().addComponent(hotkeysLabel).addComponent(alwaysOnTopLabel).addComponent(doubleClickLoadLabel));
		hGroup.addGroup(layout.createParallelGroup().addComponent(glue));
		hGroup.addGroup(layout.createParallelGroup().addComponent(hotkeysCheckbox).addComponent(alwaysOnTopCheckBox).addComponent(doubleClickLoadCheckbox));

		layout.setHorizontalGroup(hGroup);

		// Vertical
		GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(glue));
		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(alwaysOnTopLabel).addComponent(alwaysOnTopCheckBox));
		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(hotkeysLabel).addComponent(hotkeysCheckbox));
		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(doubleClickLoadLabel).addComponent(doubleClickLoadCheckbox));

		layout.setVerticalGroup(vGroup);

		setLayout(layout);
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "General"));
	}


	/**
	 * Applies the changes to the settings to the program.
	 */
	protected void applyChanges()
	{
		OrganizerManager.setGlobalHotkeysEnabled(hotkeysCheckbox.isSelected());
		OrganizerManager.setAlwaysOnTop(alwaysOnTopCheckBox.isSelected());
		OrganizerManager.setDoubleClickLoadEnabled(doubleClickLoadCheckbox.isSelected());
	}

}
