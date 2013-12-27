package net.oryanmat.gui.util.layout;

import javax.swing.JPanel;

public interface PanelFactory<P extends JPanel> {
	P getPanel();
}
