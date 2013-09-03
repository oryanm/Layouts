package net.oryanmat.gui.util.layout;

import java.awt.*;

@SuppressWarnings("UnusedDeclaration")
public class BorderLayoutBuilder<T extends Container> {
	private T container;

	protected BorderLayoutBuilder(T container, int horizontalGap, int verticalGap) {
		this.container = container;
		this.container.setLayout(new BorderLayout(horizontalGap, verticalGap));
	}

	public T getContainer() {
		return this.container;
	}

	public BorderLayoutBuilder<T> setCenter(Component component) {
		this.container.add(component, BorderLayout.CENTER);
		return this;
	}

	public BorderLayoutBuilder<T> setNorth(Component component) {
		this.container.add(component, BorderLayout.NORTH);
		return this;
	}

	public BorderLayoutBuilder<T> setSouth(Component component) {
		this.container.add(component, BorderLayout.SOUTH);
		return this;
	}

	public BorderLayoutBuilder<T> setEast(Component component) {
		this.container.add(component, BorderLayout.EAST);
		return this;
	}

	public BorderLayoutBuilder<T> setWest(Component component) {
		this.container.add(component, BorderLayout.WEST);
		return this;
	}
}
