package net.oryanmat.gui.util.layout;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("UnusedDeclaration")
public class BoxLayoutBuilder<C extends Container> extends AbstractBuilder<C, BoxLayout>{
	private int gap = 0;

	protected BoxLayoutBuilder(C container, int axis, int gap) {
		this(container, axis);
		this.gap = gap;
	}

	@SuppressWarnings("MagicConstant")
	protected BoxLayoutBuilder(C container, int axis) {
		super(container, new BoxLayout(container, axis));
	}

	public BoxLayoutBuilder<C> setGap(int gap) {
		this.gap = gap;
		return this;
	}

	public BoxLayoutBuilder<C> add(Component... components) {
		for (Component component : components) {
			if (gap > 0) container.add(createRigidArea(gap));
			this.container.add(component);
		}

		if (gap > 0) container.add(createRigidArea(gap));

		return this;
	}

	public BoxLayoutBuilder<C> addGlue() {
		container.add(Box.createGlue());
		return this;
	}

	private static Component createRigidArea(int gap) {
		return Box.createRigidArea(new Dimension(gap, gap));
	}
}
