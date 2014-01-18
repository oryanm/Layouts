package net.oryanmat.gui.util.layout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;

public class Layouts {
	static PanelFactory panelFactory = new JPanelFactory();

	private Layouts() {}

	public static class Grid {
		public static final int DEFAULT_ROW_NUM = 1;
		public static final int DEFAULT_COLUMNS_NUM = 0;
		public static final int DEFAULT_HORIZONTAL_GAP = 0;
		public static final int DEFAULT_VERTICAL_GAP = 0;

		private Grid() {}

		public static GridLayoutBuilder<JPanel> buildJPanel() {
			return buildContainer(panelFactory.getPanel());
		}

		public static GridLayoutBuilder<JPanel> buildJPanel(int rows, int columns) {
			return buildJPanel().setRows(rows).setColumns(columns);
		}

		public static GridLayoutBuilder<JPanel> buildJPanel(int rows, int columns, int horizontalGap, int verticalGap) {
			return buildJPanel(rows, columns).setHorizontalGap(horizontalGap).setVerticalGap(verticalGap);
		}

		public static <C extends Container> GridLayoutBuilder<C> buildContainer(C container) {
			return buildContainer(container, DEFAULT_ROW_NUM, DEFAULT_COLUMNS_NUM);
		}

		public static <C extends Container> GridLayoutBuilder<C> buildContainer(C container, int rows, int columns) {
			return buildContainer(container, rows, columns, DEFAULT_HORIZONTAL_GAP, DEFAULT_VERTICAL_GAP);
		}

		public static <C extends Container> GridLayoutBuilder<C> buildContainer(
			C container, int rows, int columns, int horizontalGap, int verticalGap) {
			return new GridLayoutBuilder<>(container, rows, columns, horizontalGap, verticalGap);
		}
	}

	public static class Border {
		public static final int DEFAULT_HORIZONTAL_GAP = 0;
		public static final int DEFAULT_VERTICAL_GAP = 0;

		private Border() {}

		public static BorderLayoutBuilder<JPanel> buildJPanel() {
			return buildJPanel(DEFAULT_HORIZONTAL_GAP, DEFAULT_VERTICAL_GAP);
		}

		public static BorderLayoutBuilder<JPanel> buildJPanel(int horizontalGap, int verticalGap) {
			return buildContainer(panelFactory.getPanel(), horizontalGap, verticalGap);
		}

		public static BorderLayoutBuilder<JPanel> buildJPanel(int gap) {
			return buildContainer(Borders.setEmptyBorder(gap, panelFactory.getPanel()), gap, gap);
		}

		public static BorderLayoutBuilder<JPanel> buildJPanel(javax.swing.border.Border border) {
			return buildContainer(Borders.setBorder(border, panelFactory.getPanel()));
		}

		public static BorderLayoutBuilder<JPanel> buildJPanel(
			javax.swing.border.Border border, int horizontalGap, int verticalGap) {
			return buildContainer(Borders.setBorder(border, panelFactory.getPanel()), horizontalGap, verticalGap);
		}

		public static <C extends Container> BorderLayoutBuilder<C> buildContainer(C container) {
			return buildContainer(container, DEFAULT_HORIZONTAL_GAP, DEFAULT_VERTICAL_GAP);
		}

		public static <C extends Container> BorderLayoutBuilder<C> buildContainer(
			C container, int horizontalGap, int verticalGap) {
			return new BorderLayoutBuilder<>(container, horizontalGap, verticalGap);
		}
	}

	public static class Flow {
		public static final int DEFAULT_HORIZONTAL_GAP = 5;
		public static final int DEFAULT_VERTICAL_GAP = 5;
		public static final int DEFAULT_ALIGNMENT = FlowLayout.CENTER;

		private Flow() {}

		public static JPanel getRightAlignedJPanel(Component... components) {
			return getRightAlignedJPanel(DEFAULT_HORIZONTAL_GAP, DEFAULT_VERTICAL_GAP, components);
		}

		public static JPanel getRightAlignedJPanel(int horizontalGap, int verticalGap, Component... components) {
			return getContainer(panelFactory.getPanel(), FlowLayout.RIGHT, horizontalGap, verticalGap, components);
		}

		public static JPanel getLeftAlignedJPanel(Component... components) {
			return getLeftAlignedJPanel(DEFAULT_HORIZONTAL_GAP, DEFAULT_VERTICAL_GAP, components);
		}

		public static JPanel getLeftAlignedJPanel(int horizontalGap, int verticalGap, Component... components) {
			return getContainer(panelFactory.getPanel(), FlowLayout.LEFT, horizontalGap, verticalGap, components);
		}

		public static JPanel getJPanel(Component... components) {
			return getContainer(panelFactory.getPanel(), components);
		}

		public static JPanel getJPanel(int align, Component... components) {
			return getContainer(panelFactory.getPanel(), align, components);
		}

		public static JPanel getJPanel(int align, int horizontalGap, int verticalGap, Component... components) {
			return getContainer(panelFactory.getPanel(), align, horizontalGap, verticalGap, components);
		}

		public static <C extends Container> C getRightAlignedContainer(C container, Component... components) {
			return getRightAlignedContainer(container, DEFAULT_HORIZONTAL_GAP, DEFAULT_VERTICAL_GAP, components);
		}

		public static <C extends Container> C getRightAlignedContainer(
			C container, int horizontalGap, int verticalGap, Component... components) {
			return buildRightAlignedContainer(container, horizontalGap, verticalGap, components).getContainer();
		}

		public static <C extends Container> C getLeftAlignedContainer(C container, Component... components) {
			return getLeftAlignedContainer(container, DEFAULT_HORIZONTAL_GAP, DEFAULT_VERTICAL_GAP, components);
		}

		public static <C extends Container> C getLeftAlignedContainer(
			C container, int horizontalGap, int verticalGap, Component... components) {
			return buildLeftAlignedContainer(container, horizontalGap, verticalGap, components).getContainer();
		}

		public static <C extends Container> C getContainer(C container, Component... components) {
			return getContainer(container, DEFAULT_ALIGNMENT, components);
		}

		public static <C extends Container> C getContainer(C container, int align, Component... components) {
			return getContainer(container, align, DEFAULT_HORIZONTAL_GAP, DEFAULT_VERTICAL_GAP, components);
		}

		public static <C extends Container> C getContainer(
			C container, int align, int horizontalGap, int verticalGap, Component... components) {
			return buildContainer(container, align, horizontalGap, verticalGap, components).getContainer();
		}

		public static <C extends Container> FlowLayoutBuilder<C> buildRightAlignedContainer(
			C container, Component... components) {
			return buildRightAlignedContainer(container, DEFAULT_HORIZONTAL_GAP, DEFAULT_VERTICAL_GAP, components);
		}

		public static <C extends Container> FlowLayoutBuilder<C> buildLeftAlignedContainer(
			C container, Component... components) {
			return buildLeftAlignedContainer(container, DEFAULT_HORIZONTAL_GAP, DEFAULT_VERTICAL_GAP, components);
		}

		public static <C extends Container> FlowLayoutBuilder<C> buildRightAlignedContainer(
			C container, int horizontalGap, int verticalGap, Component... components) {
			return buildContainer(container, FlowLayout.RIGHT, horizontalGap, verticalGap, components);
		}

		public static <C extends Container> FlowLayoutBuilder<C> buildLeftAlignedContainer(
			C container, int horizontalGap, int verticalGap, Component... components) {
			return buildContainer(container, FlowLayout.LEFT, horizontalGap, verticalGap, components);
		}

		public static <C extends Container> FlowLayoutBuilder<C> buildContainer(C container, Component... components) {
			return buildContainer(container, DEFAULT_ALIGNMENT, components);
		}

		public static <C extends Container> FlowLayoutBuilder<C> buildContainer(C container, int align, Component... components) {
			return buildContainer(container, align, DEFAULT_HORIZONTAL_GAP, DEFAULT_VERTICAL_GAP, components);
		}

		public static <C extends Container> FlowLayoutBuilder<C> buildContainer(
			C container, int align, int horizontalGap, int verticalGap, Component... components) {
			return new FlowLayoutBuilder<>(container, align, horizontalGap, verticalGap).add(components);
		}
	}

	public static class Box {
		private Box() {}

		public static JPanel getHorizontalJPanel(int gap, Component... components) {
			return getHorizontalContainer(panelFactory.getPanel(), gap, components);
		}

		public static JPanel getVerticalJPanel(int gap, Component... components) {
			return getVerticalContainer(panelFactory.getPanel(), gap, components);
		}

		public static JPanel getHorizontalJPanel(Component... components) {
			return getHorizontalContainer(panelFactory.getPanel(), components);
		}

		public static JPanel getVerticalJPanel(Component... components) {
			return getVerticalContainer(panelFactory.getPanel(), components);
		}

		public static <C extends Container> C getHorizontalContainer(
			C container, Component... components) {
			return buildHorizontalContainer(container, components).getContainer();
		}

		public static <C extends Container> C getVerticalContainer(
			C container, Component... components) {
			return buildVerticalContainer(container, components).getContainer();
		}

		public static <C extends Container> C getHorizontalContainer(
			C container, int gap, Component... components) {
			return buildHorizontalContainer(container, gap, components).getContainer();
		}

		public static <C extends Container> C getVerticalContainer(
			C container, int gap, Component... components) {
			return buildVerticalContainer(container, gap, components).getContainer();
		}

		private static <C extends Container> C getContainer(
			C container, int axis, Component... components) {
			return buildContainer(container, axis, components).getContainer();
		}

		private static <C extends Container> C getContainer(
			C container, int axis, int gap, Component... components) {
			return buildContainer(container, axis, gap, components).getContainer();
		}

		public static <C extends Container> BoxLayoutBuilder<C> buildHorizontalContainer(
			C container, Component... components) {
			return buildContainer(container, BoxLayout.LINE_AXIS, components);
		}

		public static <C extends Container> BoxLayoutBuilder<C> buildVerticalContainer(
			C container, Component... components) {
			return buildContainer(container, BoxLayout.PAGE_AXIS, components);
		}

		public static <C extends Container> BoxLayoutBuilder<C> buildHorizontalContainer(
			C container, int gap, Component... components) {
			return buildContainer(container, BoxLayout.LINE_AXIS, gap, components);
		}

		public static <C extends Container> BoxLayoutBuilder<C> buildVerticalContainer(
			C container, int gap, Component... components) {
			return buildContainer(container, BoxLayout.PAGE_AXIS, gap, components);
		}

		private static <C extends Container> BoxLayoutBuilder<C> buildContainer(
			C container, int axis, Component... components) {
			return new BoxLayoutBuilder<>(container, axis).add(components);
		}

		private static <C extends Container> BoxLayoutBuilder<C> buildContainer(
			C container, int axis, int gap, Component... components) {
			return new BoxLayoutBuilder<>(container, axis).setGap(gap).add(components);
		}
	}

	public static void setPanelFactory(PanelFactory panelFactory) {
		Layouts.panelFactory = panelFactory;
	}
}
