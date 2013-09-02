package net.oryanmat.gui.util.layout;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("UnusedDeclaration")
public class FlowLayoutBuilder<T extends JPanel> {
	private T panel;

	@SuppressWarnings("MagicConstant")
	protected FlowLayoutBuilder(T panel, int align, int horizontalGap, int verticalGap) {
		this.panel = panel;
		this.panel.setLayout(new FlowLayout(align, horizontalGap, verticalGap));
	}

	public T getPanel() {
		return this.panel;
	}

	public FlowLayoutBuilder<T> add(Component... components) {
		for (Component component : components) {
			this.panel.add(component);
		}

		return this;
	}
}
