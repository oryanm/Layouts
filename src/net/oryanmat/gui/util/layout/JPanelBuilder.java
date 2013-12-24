package net.oryanmat.gui.util.layout;

import javax.swing.JPanel;

public class JPanelBuilder implements PanelBuilder<JPanel> {
	@Override
	public JPanel getPanel() {
		return new JPanel();
	}
}
