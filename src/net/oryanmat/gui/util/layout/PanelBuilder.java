package net.oryanmat.gui.util.layout;

import javax.swing.JPanel;

public interface PanelBuilder<P extends JPanel> {
	P getPanel();
}
