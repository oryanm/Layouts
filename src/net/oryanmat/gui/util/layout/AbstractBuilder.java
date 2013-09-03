package net.oryanmat.gui.util.layout;

import java.awt.*;

public class AbstractBuilder<C extends Container, L extends LayoutManager> {
	protected C container;
	protected L layout;

	protected AbstractBuilder(C container, L layout) {
		this.container = container;
		this.layout = layout;
		this.container.setLayout(layout);
	}

	public C getContainer() {
		return container;
	}
}
