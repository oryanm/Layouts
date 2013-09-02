package net.oryanmat.gui.util.layout;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("UnusedDeclaration")
public class Layouts {
	public static class Border {
		public static BorderLayoutBuilder<JPanel> buildPanel() {
			return buildPanel(0, 0);
		}

		public static BorderLayoutBuilder<JPanel> buildPanel(int horizontalGap, int verticalGap) {
			return buildPanel(new JPanel(), horizontalGap, verticalGap);
		}

		public static <T extends JPanel> BorderLayoutBuilder<T> buildPanel(T panel) {
			return buildPanel(panel, 0, 0);
		}

		public static <T extends JPanel> BorderLayoutBuilder<T> buildPanel(T panel, int horizontalGap, int verticalGap) {
			return new BorderLayoutBuilder<T>(panel, horizontalGap, verticalGap);
		}
	}

	public static class Flow {
		public static JPanel getJPanel(Component... components) {
			return getPanel(new JPanel(), components);
		}

		public static JPanel getJPanel(int align, Component... components) {
			return getPanel(new JPanel(), align, components);
		}

		public static JPanel getJPanel(int align, int horizontalGap, int verticalGap, Component... components) {
			return getPanel(new JPanel(), align, horizontalGap, verticalGap, components);
		}

		public static <T extends JPanel> T getPanel(T panel, Component... components) {
			return getPanel(panel, FlowLayout.CENTER, components);
		}

		public static <T extends JPanel> T getPanel(T panel, int align, Component... components) {
			return getPanel(panel, align, 5, 5, components);
		}

		public static <T extends JPanel> T getPanel(T panel, int align, int horizontalGap, int verticalGap, Component... components) {
			return buildPanel(panel, align, horizontalGap, verticalGap, components).getPanel();
		}

		public static <T extends JPanel> FlowLayoutBuilder<T> buildPanel(T panel, Component... components) {
			return buildPanel(panel, FlowLayout.CENTER, components);
		}

		public static <T extends JPanel> FlowLayoutBuilder<T> buildPanel(T panel, int align, Component... components) {
			return buildPanel(panel, align, 5, 5, components);
		}

		public static <T extends JPanel> FlowLayoutBuilder<T> buildPanel(T panel, int align, int horizontalGap, int verticalGap, Component... components) {
			return new FlowLayoutBuilder<T>(panel, align, horizontalGap, verticalGap).add(components);
		}
	}

	public static class Box {
		public static JPanel getHorizontalJPanel(int gap, Component... components) {
			return getHorizontalPanel(new JPanel(), gap, components);
		}

		public static JPanel getVerticalJPanel(int gap, Component... components) {
			return getVerticalPanel(new JPanel(), gap, components);
		}

		public static JPanel getHorizontalJPanel(Component... components) {
			return getHorizontalPanel(new JPanel(), components);
		}

		public static JPanel getVerticalJPanel(Component... components) {
			return getVerticalPanel(new JPanel(), components);
		}

		public static <T extends JPanel> T getHorizontalPanel(T panel, Component... components) {
			return getPanel(panel, BoxLayout.LINE_AXIS, components);
		}

		public static <T extends JPanel> T getVerticalPanel(T panel, Component... components) {
			return getPanel(panel, BoxLayout.PAGE_AXIS, components);
		}

		public static <T extends JPanel> T getHorizontalPanel(T panel, int gap, Component... components) {
			return getPanel(panel, BoxLayout.LINE_AXIS, gap, components);
		}

		public static <T extends JPanel> T getVerticalPanel(T panel, int gap, Component... components) {
			return getPanel(panel, BoxLayout.PAGE_AXIS, gap, components);
		}

		private static <T extends JPanel> T getPanel(T panel, int axis, Component... components) {
			return buildPanel(panel, axis, components).getPanel();
		}

		private static <T extends JPanel> T getPanel(T panel, int axis, int gap, Component... components) {
			return buildPanel(panel, axis, gap, components).getPanel();
		}

		public static <T extends JPanel> BoxLayoutBuilder<T> buildHorizontalPanel(T panel, Component... components) {
			return buildPanel(panel, BoxLayout.LINE_AXIS, components);
		}

		public static <T extends JPanel> BoxLayoutBuilder<T> buildVerticalPanel(T panel, Component... components) {
			return buildPanel(panel, BoxLayout.PAGE_AXIS, components);
		}

		public static <T extends JPanel> BoxLayoutBuilder<T> buildHorizontalPanel(T panel, int gap, Component... components) {
			return buildPanel(panel, BoxLayout.LINE_AXIS, gap, components);
		}

		public static <T extends JPanel> BoxLayoutBuilder<T> buildVerticalPanel(T panel, int gap, Component... components) {
			return buildPanel(panel, BoxLayout.PAGE_AXIS, gap, components);
		}

		private static <T extends JPanel> BoxLayoutBuilder<T> buildPanel(T panel, int axis, Component... components) {
			return new BoxLayoutBuilder<T>(panel, axis).add(components);
		}

		private static <T extends JPanel> BoxLayoutBuilder<T> buildPanel(T panel, int axis, int gap, Component... components) {
			return new BoxLayoutBuilder<T>(panel, axis, gap).add(components);
		}
	}
}
