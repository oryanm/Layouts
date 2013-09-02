package net.oryanmat.gui.util.layout;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("UnusedDeclaration")
public class BorderLayoutBuilder<T extends JPanel> {
	private T panel;

	protected BorderLayoutBuilder(T panel, int hgap, int vgap) {
		this.panel = panel;
		this.panel.setLayout(new BorderLayout(hgap, vgap));
	}

	public T getPanel() {
		return this.panel;
	}

	public BorderLayoutBuilder<T> setCenter(Component component) {
		this.panel.add(component, BorderLayout.CENTER);
		return this;
	}

	public BorderLayoutBuilder<T> setNorth(Component component) {
		this.panel.add(component, BorderLayout.NORTH);
		return this;
	}

	public BorderLayoutBuilder<T> setSouth(Component component) {
		this.panel.add(component, BorderLayout.SOUTH);
		return this;
	}

	public BorderLayoutBuilder<T> setEast(Component component) {
		this.panel.add(component, BorderLayout.EAST);
		return this;
	}

	public BorderLayoutBuilder<T> setWest(Component component) {
		this.panel.add(component, BorderLayout.WEST);
		return this;
	}
}
