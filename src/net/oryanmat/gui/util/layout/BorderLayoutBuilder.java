package net.oryanmat.gui.util.layout;

import java.awt.*;

@SuppressWarnings("UnusedDeclaration")
public class BorderLayoutBuilder<C extends Container> extends AbstractBuilder<C, BorderLayout> {
	protected BorderLayoutBuilder(C container, int horizontalGap, int verticalGap) {
		super(container, new BorderLayout(horizontalGap, verticalGap));
	}

	public BorderLayoutBuilder<C> setHorizontalGap(int horizontalGap) {
		layout.setHgap(horizontalGap);
		return this;
	}

	public BorderLayoutBuilder<C> setVerticalGap(int verticalGap) {
		layout.setVgap(verticalGap);
		return this;
	}

	public BorderLayoutBuilder<C> setCenter(Component component) {
		this.container.add(component, BorderLayout.CENTER);
		return this;
	}

	public BorderLayoutBuilder<C> setNorth(Component component) {
		this.container.add(component, BorderLayout.NORTH);
		return this;
	}

	public BorderLayoutBuilder<C> setSouth(Component component) {
		this.container.add(component, BorderLayout.SOUTH);
		return this;
	}

	public BorderLayoutBuilder<C> setEast(Component component) {
		this.container.add(component, BorderLayout.EAST);
		return this;
	}

	public BorderLayoutBuilder<C> setWest(Component component) {
		this.container.add(component, BorderLayout.WEST);
		return this;
	}
}
