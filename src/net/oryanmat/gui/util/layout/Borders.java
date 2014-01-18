package net.oryanmat.gui.util.layout;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.Border;
import java.awt.Color;

public class Borders {
	private Borders() {}

	public static <C extends JComponent> C setLineBorder(Color color, C component) {
		return setBorder(BorderFactory.createLineBorder(color), component);
	}

	public static <C extends JComponent> C setLineBorder(Color color, int thickness, C component) {
		return setBorder(BorderFactory.createLineBorder(color, thickness), component);
	}

	public static <C extends JComponent> C setLineBorder(Color color, int thickness, boolean rounded, C component) {
		return setBorder(BorderFactory.createLineBorder(color, thickness, rounded), component);
	}

	public static <C extends JComponent> C setEmptyBorder(int thickness, C component) {
		return setEmptyBorder(thickness, thickness, thickness, thickness, component);
	}

	public static <C extends JComponent> C setEmptyBorder(int top, int left, int bottom, int right, C component) {
		return setBorder(BorderFactory.createEmptyBorder(top, left, bottom, right), component);
	}

	public static <C extends JComponent> C setEmptyBorder(C component) {
		return setBorder(BorderFactory.createEmptyBorder(), component);
	}

	public static <C extends JComponent> C compoundWith(Border outsideBorder, C component) {
		return setBorder(BorderFactory.createCompoundBorder(outsideBorder, component.getBorder()), component);
	}

	public static <C extends JComponent> C setBorder(Border border, C component) {
		component.setBorder(border);
		return component;
	}
}
