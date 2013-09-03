package net.oryanmat.gui.util.layout;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("UnusedDeclaration")
public class BoxLayoutBuilder<T extends Container> {
	private T container;
	private int gap = 0;

	protected BoxLayoutBuilder(T container, int axis, int gap) {
		this(container, axis);
		this.gap = gap;
	}

	@SuppressWarnings("MagicConstant")
	protected BoxLayoutBuilder(T container, int axis) {
		this.container = container;
		this.container.setLayout(new BoxLayout(this.container, axis));
	}

	public T getContainer() {
		return this.container;
	}

	public BoxLayoutBuilder<T> setGap(int gap) {
		this.gap = gap;
		return this;
	}

	public BoxLayoutBuilder<T> add(Component... components) {
		for (Component component : components) {
			if (gap > 0) container.add(createRigidArea(gap));
			this.container.add(component);
		}

		if (gap > 0) container.add(createRigidArea(gap));

		return this;
	}

	private static Component createRigidArea(int gap) {
		return Box.createRigidArea(new Dimension(gap, gap));
	}
}
