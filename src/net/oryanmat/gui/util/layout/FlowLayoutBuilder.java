package net.oryanmat.gui.util.layout;

import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;

public class FlowLayoutBuilder<C extends Container> extends AbstractBuilder<C, FlowLayout>{
	protected FlowLayoutBuilder(C container, int align, int horizontalGap, int verticalGap) {
		super(container, new FlowLayout(align, horizontalGap, verticalGap));
	}

	public FlowLayoutBuilder<C> setAlign(int align) {
		layout.setAlignment(align);
		return this;
	}

	public FlowLayoutBuilder<C> setHorizontalGap(int horizontalGap) {
		layout.setHgap(horizontalGap);
		return this;
	}

	public FlowLayoutBuilder<C> setVerticalGap(int verticalGap) {
		layout.setVgap(verticalGap);
		return this;
	}

	public FlowLayoutBuilder<C> add(Component... components) {
		for (Component component : components) {
			this.container.add(component);
		}

		return this;
	}
}
