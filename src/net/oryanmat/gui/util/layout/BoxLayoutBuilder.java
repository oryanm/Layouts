package net.oryanmat.gui.util.layout;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("UnusedDeclaration")
public class BoxLayoutBuilder<T extends JPanel> {
	private T panel;
	private int gap = 0;

	protected BoxLayoutBuilder(T panel, int axis, int gap) {
		this(panel, axis);
		this.gap = gap;
	}

	@SuppressWarnings("MagicConstant")
	protected BoxLayoutBuilder(T panel, int axis) {
		this.panel = panel;
		this.panel.setLayout(new BoxLayout(this.panel, axis));
	}

	public T getPanel() {
		return this.panel;
	}

	public BoxLayoutBuilder<T> setGap(int gap) {
		this.gap = gap;
		return this;
	}

	public BoxLayoutBuilder<T> add(Component... components) {
		for (Component component : components) {
			if (gap > 0) panel.add(createRigidArea(gap));
			this.panel.add(component);
		}

		if (gap > 0) panel.add(createRigidArea(gap));

		return this;
	}

	private static Component createRigidArea(int gap) {
		return Box.createRigidArea(new Dimension(gap, gap));
	}
}
