package net.oryanmat.gui.util.layout;

import java.awt.*;

@SuppressWarnings("UnusedDeclaration")
public class FlowLayoutBuilder<T extends Container> {
	private T container;

	@SuppressWarnings("MagicConstant")
	protected FlowLayoutBuilder(T container, int align, int horizontalGap, int verticalGap) {
		this.container = container;
		this.container.setLayout(new FlowLayout(align, horizontalGap, verticalGap));
	}

	public T getContainer() {
		return this.container;
	}

	public FlowLayoutBuilder<T> add(Component... components) {
		for (Component component : components) {
			this.container.add(component);
		}

		return this;
	}
}
