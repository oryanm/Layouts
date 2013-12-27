package net.oryanmat.gui.util.layout;

import javax.swing.JPanel;

public class JPanelFactory implements PanelFactory<JPanel> {
	@Override
	public JPanel getPanel() {
		return new JPanel();
	}
}
