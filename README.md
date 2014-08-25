Layouts
=======
Layouts provides an simple, clean and readable way for arranging Swing components in containers.
Layouts was built with `JPanel` in mind but works with any `Container`.
Four of Swing's basic LayoutManagers are represented:
* Flow
* Box
* Border
* Grid

Using a [fluent interface](http://en.wikipedia.org/wiki/Fluent_interface) and varargs, we're able to create a container, 
set it's layout and add it's components in one line. 
Since `Container extends Component`, it's also possible to compose calls to Layouts to create complex structures.

How to use
==========

Here is the most basic example:
```java
Layouts.Flow.getJPanel(component1, component2, ..., componentN);
```
This line creates a new JPanel, sets it's layout to be a new `FlowLayout` and adds the components to the panel.

We can do the same basic thing with a Box:
```java
Layouts.Box.getHorizontalJPanel(component1, component2, ..., componentN);
Layouts.Box.getVerticalJPanel(component1, component2, ..., componentN);
```

Border and Grid are a tiny bit more complex:
```java
Layouts.Border.buildJPanel()
	.setNorth(northComponent)
	.setWest(westComponent).setCenter(centerComponent).setEast(eastComponent)
	.setSouth(southComponent).getContainer();

Layouts.Grid.buildJPanel().setRows(2).setColumns(3)
	.addRow(component1, component2, component3)
	.addRow(component4, component5, component6).getContainer();
```
Notice the use of the word `build` instead of `get` and the call to `getContainer()` at the end. 
This stems from the fact that just adding components to Border and Grid panels is not enough, 
we also need to specify where the component is added to. 
Although this is not entirely true in regards to `GridLayout`, it does offer better readability.

Builders
--------
Building a panel (as opposed to just "getting" one) will return an appropriate builder. 
Every builder exposes all of the setters/modifiers relevant to it's layout.
All of the builder's methods return `this`, allowing us to chain together calls.
For example, the `FlowLayoutBuilder` exposes these methods:
```java
Layouts.Flow.buildContainer(...)
	.setAlign(FlowLayout.Center)
	.setHorizontalGap(5)
	.setVerticalGap(5)
	.add(Components);
```

Containers
----------
The `buildContainer()` and `getContainer()` methods allow us to use anything that `<C extends Container>` rather then just JPanels:
```java
// we can setup a frame's content pane
JFrame frame = ...
Layouts.Border.buildContainer(frame.getContentPane()).setCenter(...);

// use our own implementation of JPanel
class XPanel extends JPanel {...}
Layouts.Box.getVerticalContainer(new XPanel(), component1, component2, ..., componentN)

// or any other component for that matter
Layouts.Grid.buildContainer(new JButton()).addRow(component1, component2, ..., componentN)
```

Composition
-----------
Since `Container extends Component`, we can combine all of the above to create one big mess:
```java
Layouts.Border.buildContainer(frame.getContentPane()).setCenter(
	Layouts.Border.buildJPanel()
		.setNorth(Layouts.Flow.buildContainer(new XPanel())
			.setAlign(FlowLayout.Center)
			.setHorizontalGap(5)
			.setVerticalGap(5)
			.add(Layouts.Box.getHorizontalJPanel(component1, component2, ..., componentN)).getContainer())
		.setWest(eastComponent).setCenter(Layouts.Grid.buildJPanel().setRows(2).setColumns(3)
			.addRow(component1, component2, component3)
			.addRow(component4, component5, component6).getContainer()).setEast(westComponent)
		.setSouth(Layouts.Grid.buildContainer(new JButton())
			.addRow(component1, component2, ..., componentN)).getContainer());
```

Or something more sensible:
```java
Layouts.Border.buildContainer(frame.getContentPane())
	.setCenter((Layouts.Border.buildJPanel()
		.setNorth(Layouts.Box.getVerticalJPanel(
			Layouts.Border.buildJPanel()
				.setNorth(label)
				.setCenter(Layouts.Flow.getJPanel(FlowLayout.LEFT, label1, value, label2, field)).getContainer(),
			Layouts.Border.buildJPanel()
				.setNorth(label3)
				.setCenter(Layouts.Flow.getJPanel(FlowLayout.LEFT, label4, stuff, label5, more)).getContainer()))
		.setCenter(Layouts.Border.buildJPanel()
			.setNorth(label6)
			.setCenter(scrollPane).getContainer())
		.setSouth(Layouts.Box.getVerticalJPanel(
			Layouts.Border.buildJPanel()
				.setNorth(label7)
				.setCenter(Layouts.Flow.getJPanel(FlowLayout.LEFT, label8, stuff1, label9, more1)).getContainer(),
			Layouts.Flow.getJPanel(FlowLayout.RIGHT, ok, exit))).getContainer()));
```

Which results in:

![Code Example](http://i.imgur.com/AT7Ud98.jpg "Code Example")

Download 
========
As a maven dependency:
```
<dependency>
  <groupId>com.github.oryanmat</groupId>
  <artifactId>Layouts</artifactId>
  <version>2.0</version>
</dependency>
```
