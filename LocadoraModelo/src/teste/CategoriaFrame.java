package teste;

import javax.swing.JInternalFrame;

public class CategoriaFrame extends JInternalFrame {
	static final int xPosition = 30, yPosition = 30;

	public CategoriaFrame() {
		super("Categoria", true, // resizable
				true, // closable
				true, // maximizable
				true);// iconifiable
		setSize(300, 300);
		setLocation(xPosition, yPosition);
	}
}
