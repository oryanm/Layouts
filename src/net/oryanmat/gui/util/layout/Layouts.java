package net.oryanmat.gui.util.layout;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("UnusedDeclaration")
public class Layouts {
	public static class Border {
		public static BorderLayoutBuilder<JPanel> buildJPanel() {
			return buildJPanel(0, 0);
		}

		public static BorderLayoutBuilder<JPanel> buildJPanel(int horizontalGap, int verticalGap) {
			return buildContainer(new JPanel(), horizontalGap, verticalGap);
		}

		public static <T extends Container> BorderLayoutBuilder<T> buildContainer(T container) {
			return buildContainer(container, 0, 0);
		}

		public static <T extends Container> BorderLayoutBuilder<T> buildContainer(T container, int horizontalGap, int verticalGap) {
			return new BorderLayoutBuilder<T>(container, horizontalGap, verticalGap);
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

		public static <T extends Container> T getContainer(T container, Component... components) {
			return getContainer(container, FlowLayout.CENTER, components);
		}

		public static <T extends Container> T getContainer(T container, int align, Component... components) {
			return getContainer(container, align, 5, 5, components);
		}

		public static <T extends Container> T getContainer(T container, int align, int horizontalGap, int verticalGap, Component... components) {
			return buildContainer(container, align, horizontalGap, verticalGap, components).getContainer();
		}

		public static <T extends Container> FlowLayoutBuilder<T> buildContainer(T container, Component... components) {
			return buildContainer(container, FlowLayout.CENTER, components);
		}

		public static <T extends Container> FlowLayoutBuilder<T> buildContainer(T container, int align, Component... components) {
			return buildContainer(container, align, 5, 5, components);
		}

		public static <T extends Container> FlowLayoutBuilder<T> buildContainer(T container, int align, int horizontalGap, int verticalGap, Component... components) {
			return new FlowLayoutBuilder<T>(container, align, horizontalGap, verticalGap).add(components);
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

		public static <T extends Container> T getHorizontalContainer(T container, Component... components) {
			return getContainer(container, BoxLayout.LINE_AXIS, components);
		}

		public static <T extends Container> T getVerticalContainer(T container, Component... components) {
			return getContainer(container, BoxLayout.PAGE_AXIS, components);
		}

		public static <T extends Container> T getHorizontalContainer(T container, int gap, Component... components) {
			return getContainer(container, BoxLayout.LINE_AXIS, gap, components);
		}

		public static <T extends Container> T getVerticalContainer(T container, int gap, Component... components) {
			return getContainer(container, BoxLayout.PAGE_AXIS, gap, components);
		}

		private static <T extends Container> T getContainer(T container, int axis, Component... components) {
			return buildContainer(container, axis, components).getContainer();
		}

		private static <T extends Container> T getContainer(T container, int axis, int gap, Component... components) {
			return buildContainer(container, axis, gap, components).getContainer();
		}

		public static <T extends Container> BoxLayoutBuilder<T> buildHorizontalContainer(T container, Component... components) {
			return buildContainer(container, BoxLayout.LINE_AXIS, components);
		}

		public static <T extends Container> BoxLayoutBuilder<T> buildVerticalContainer(T container, Component... components) {
			return buildContainer(container, BoxLayout.PAGE_AXIS, components);
		}

		public static <T extends Container> BoxLayoutBuilder<T> buildHorizontalContainer(T container, int gap, Component... components) {
			return buildContainer(container, BoxLayout.LINE_AXIS, gap, components);
		}

		public static <T extends Container> BoxLayoutBuilder<T> buildVerticalContainer(T container, int gap, Component... components) {
			return buildContainer(container, BoxLayout.PAGE_AXIS, gap, components);
		}

		private static <T extends Container> BoxLayoutBuilder<T> buildContainer(T container, int axis, Component... components) {
			return new BoxLayoutBuilder<T>(container, axis).add(components);
		}

		private static <T extends Container> BoxLayoutBuilder<T> buildContainer(T container, int axis, int gap, Component... components) {
			return new BoxLayoutBuilder<T>(container, axis, gap).add(components);
		}
	}
}
