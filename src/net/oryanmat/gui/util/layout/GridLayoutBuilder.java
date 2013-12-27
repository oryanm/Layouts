package net.oryanmat.gui.util.layout;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;

public class GridLayoutBuilder<C extends Container> extends AbstractBuilder<C, GridLayout> {
	protected GridLayoutBuilder(C container, int rows, int columns, int horizontalGap, int verticalGap) {
		super(container, new GridLayout(rows, columns, horizontalGap, verticalGap));
	}

	public GridLayoutBuilder<C> setHorizontalGap(int horizontalGap) {
		layout.setHgap(horizontalGap);
		return this;
	}

	public GridLayoutBuilder<C> setVerticalGap(int verticalGap) {
		layout.setVgap(verticalGap);
		return this;
	}

	public GridLayoutBuilder<C> setRows(int rows) {
		layout.setRows(rows);
		return this;
	}

	public GridLayoutBuilder<C> setColumns(int columns) {
		layout.setColumns(columns);
		return this;
	}

	public GridLayoutBuilder<C> addRow(Component... components) {
		for (Component component : components) {
			container.add(component);
		}

		return this;
	}
}
