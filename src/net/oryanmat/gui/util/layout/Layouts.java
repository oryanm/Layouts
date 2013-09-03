package net.oryanmat.gui.util.layout;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("UnusedDeclaration")
public class Layouts {
	public static class Grid {
		public static <C extends Container> GridLayoutBuilder<C> buildContainer(C container) {
			return buildContainer(container, 1, 0);
		}

		public static <C extends Container> GridLayoutBuilder<C> buildContainer(C container, int rows, int columns) {
			return buildContainer(container, rows, columns, 0, 0);
		}

		public static <C extends Container> GridLayoutBuilder<C> buildContainer(C container, int rows, int columns, int horizontalGap, int verticalGap) {
			return new GridLayoutBuilder<C>(container, rows, columns, horizontalGap, verticalGap);
		}
	}

	public static class Border {
		public static BorderLayoutBuilder<JPanel> buildJPanel() {
			return buildJPanel(0, 0);
		}

		public static BorderLayoutBuilder<JPanel> buildJPanel(int horizontalGap, int verticalGap) {
			return buildContainer(new JPanel(), horizontalGap, verticalGap);
		}

		public static <C extends Container> BorderLayoutBuilder<C> buildContainer(C container) {
			return buildContainer(container, 0, 0);
		}

		public static <C extends Container> BorderLayoutBuilder<C> buildContainer(C container, int horizontalGap, int verticalGap) {
			return new BorderLayoutBuilder<C>(container, horizontalGap, verticalGap);
		}
	}

	public static class Flow {
		public static JPanel getJPanel(Component... components) {
			return getContainer(new JPanel(), components);
		}

		public static JPanel getJPanel(int align, Component... components) {
			return getContainer(new JPanel(), align, components);
		}

		public static JPanel getJPanel(int align, int horizontalGap, int verticalGap, Component... components) {
			return getContainer(new JPanel(), align, horizontalGap, verticalGap, components);
		}

		public static <C extends Container> C getContainer(C container, Component... components) {
			return getContainer(container, FlowLayout.CENTER, components);
		}

		public static <C extends Container> C getContainer(C container, int align, Component... components) {
			return getContainer(container, align, 5, 5, components);
		}

		public static <C extends Container> C getContainer(C container, int align, int horizontalGap, int verticalGap, Component... components) {
			return buildContainer(container, align, horizontalGap, verticalGap, components).getContainer();
		}

		public static <C extends Container> FlowLayoutBuilder<C> buildContainer(C container, Component... components) {
			return buildContainer(container, FlowLayout.CENTER, components);
		}

		public static <C extends Container> FlowLayoutBuilder<C> buildContainer(C container, int align, Component... components) {
			return buildContainer(container, align, 5, 5, components);
		}

		public static <C extends Container> FlowLayoutBuilder<C> buildContainer(C container, int align, int horizontalGap, int verticalGap, Component... components) {
			return new FlowLayoutBuilder<C>(container, align, horizontalGap, verticalGap).add(components);
		}
	}

	public static class Box {
		public static JPanel getHorizontalJPanel(int gap, Component... components) {
			return getHorizontalContainer(new JPanel(), gap, components);
		}

		public static JPanel getVerticalJPanel(int gap, Component... components) {
			return getVerticalContainer(new JPanel(), gap, components);
		}

		public static JPanel getHorizontalJPanel(Component... components) {
			return getHorizontalContainer(new JPanel(), components);
		}

		public static JPanel getVerticalJPanel(Component... components) {
			return getVerticalContainer(new JPanel(), components);
		}

		public static <C extends Container> C getHorizontalContainer(C container, Component... components) {
			return getContainer(container, BoxLayout.LINE_AXIS, components);
		}

		public static <C extends Container> C getVerticalContainer(C container, Component... components) {
			return getContainer(container, BoxLayout.PAGE_AXIS, components);
		}

		public static <C extends Container> C getHorizontalContainer(C container, int gap, Component... components) {
			return getContainer(container, BoxLayout.LINE_AXIS, gap, components);
		}

		public static <C extends Container> C getVerticalContainer(C container, int gap, Component... components) {
			return getContainer(container, BoxLayout.PAGE_AXIS, gap, components);
		}

		private static <C extends Container> C getContainer(C container, int axis, Component... components) {
			return buildContainer(container, axis, components).getContainer();
		}

		private static <C extends Container> C getContainer(C container, int axis, int gap, Component... components) {
			return buildContainer(container, axis, gap, components).getContainer();
		}

		public static <C extends Container> BoxLayoutBuilder<C> buildHorizontalContainer(C container, Component... components) {
			return buildContainer(container, BoxLayout.LINE_AXIS, components);
		}

		public static <C extends Container> BoxLayoutBuilder<C> buildVerticalContainer(C container, Component... components) {
			return buildContainer(container, BoxLayout.PAGE_AXIS, components);
		}

		public static <C extends Container> BoxLayoutBuilder<C> buildHorizontalContainer(C container, int gap, Component... components) {
			return buildContainer(container, BoxLayout.LINE_AXIS, gap, components);
		}

		public static <C extends Container> BoxLayoutBuilder<C> buildVerticalContainer(C container, int gap, Component... components) {
			return buildContainer(container, BoxLayout.PAGE_AXIS, gap, components);
		}

		private static <C extends Container> BoxLayoutBuilder<C> buildContainer(C container, int axis, Component... components) {
			return new BoxLayoutBuilder<C>(container, axis).add(components);
		}

		private static <C extends Container> BoxLayoutBuilder<C> buildContainer(C container, int axis, int gap, Component... components) {
			return new BoxLayoutBuilder<C>(container, axis, gap).add(components);
		}
	}
}
